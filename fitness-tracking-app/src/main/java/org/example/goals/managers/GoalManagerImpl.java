package org.example.goals.managers;

import org.example.exceptions.InvalidOperationException;
import org.example.goals.db.GoalDbService;
import org.example.goals.models.Goal;
import org.example.metrics.managers.MetricsManager;
import org.example.metrics.models.MetricForUser;
import org.example.notifications.factories.NotificationManagerFactory;
import org.example.notifications.models.NotificationType;
import org.example.users.managers.UserManager;
import org.example.users.models.User;

import java.time.Instant;
import java.util.List;

public class GoalManagerImpl implements GoalManager {
    private final GoalDbService goalDbService;
    private final MetricsManager metricsManager;
    private final UserManager userManager;
    private final NotificationManagerFactory notificationManagerFactory;

    public GoalManagerImpl(GoalDbService goalDbService, MetricsManager metricsManager, UserManager userManager, NotificationManagerFactory notificationManagerFactory) {
        this.goalDbService = goalDbService;
        this.metricsManager = metricsManager;
        this.userManager = userManager;
        this.notificationManagerFactory = notificationManagerFactory;
    }

    @Override
    public void setGoalByUserForMetric(Goal goal) {
        MetricForUser metricForUser = metricsManager.getMetricForUser(goal.getUserId(), goal.getMetricId());
        if (!metricForUser.isCaptureEnabled())
            throw new InvalidOperationException("Failed to set goal " + goal + " for user " + metricForUser.getUserId() + " since metric capture is disabled...");

        goalDbService.createGoal(goal);
    }

    @Override
    public void updateGoalValueForUser(int newGoalValue, String goalId) {
        Goal goal = goalDbService.getGoal(goalId);
        if (checkIfGoalCompletedForUser(goal)) {
            completeGoalForUser(goal);
            throw new InvalidOperationException("Goal already completed. Cannot update goal value!");
        }

        goal.setGoalValue(newGoalValue);
        goal.setGoalUpdateTimestamp(Instant.now());
        goalDbService.updateGoal(goal);
    }

    @Override
    public void setRewardPointsForGoal(String goalId, int rewardPoints) {
        Goal goal = goalDbService.getGoal(goalId);
        goal.setRewardForGoal(rewardPoints);
        goalDbService.updateGoal(goal);
    }

    @Override
    public boolean checkIfGoalCompletedForUser(Goal goal) {
        MetricForUser metricForUser = metricsManager.getMetricForUser(goal.getUserId(), goal.getMetricId());
        User user = userManager.getUser(goal.getUserId());
        System.out.println("Last captured value: " + metricForUser.getLastCapturedValue());
        System.out.println("Goal value: " + goal.getGoalValue());
        Double progress = (double) (metricForUser.getLastCapturedValue()) / (double) (goal.getGoalValue()) * 100;
        System.out.println("Progress made: " + progress);
        if (progress <= 60)
            notificationManagerFactory
                    .getNotificationManager(NotificationType.PICKUP)
                    .notifyObserver(user);
        if (progress >= 60 && progress < 100)
            notificationManagerFactory
                    .getNotificationManager(NotificationType.MOTIVATION)
                    .notifyObserver(user);

        return metricForUser.getLastCapturedValue() >= goal.getGoalValue();
    }

    @Override
    public void completeGoalForUser(Goal goal) {
        if (!checkIfGoalCompletedForUser(goal))
            throw new InvalidOperationException("Failed to complete goal for user since goal completion condition not matched!");

        goal.setCompleted(true);
        goal.setGoalUpdateTimestamp(Instant.now());
        goalDbService.updateGoal(goal);
        userManager.addRewardsForUser(goal.getRewardForGoal(), goal.getUserId());

    }

    @Override
    public List<Goal> getGoalsSetByUser(String userId) {
        return goalDbService.getGoalsByUserId(userId);
    }

    @Override
    public List<Goal> getGoalsByUserAndTimestamps(String userId, Instant startTimestamp, Instant endTimestamp) {
        return goalDbService.getGoalsByUserIdAndTimestamps(userId, startTimestamp, endTimestamp);
    }
}
