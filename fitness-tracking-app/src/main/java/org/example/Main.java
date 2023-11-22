package org.example;

import org.example.goals.db.GoalDbService;
import org.example.goals.db.HashmapGoalDbServiceImpl;
import org.example.goals.managers.GoalManager;
import org.example.goals.managers.GoalManagerImpl;
import org.example.goals.models.Goal;
import org.example.metrics.db.HashMapMetricsDbServiceImpl;
import org.example.metrics.db.HashMapMetricsForUserDbServiceImpl;
import org.example.metrics.db.MetricsDbService;
import org.example.metrics.db.MetricsForUserDbService;
import org.example.metrics.managers.MetricsManager;
import org.example.metrics.managers.MetricsManagerImpl;
import org.example.metrics.models.Metric;
import org.example.metrics.models.MetricType;
import org.example.notifications.factories.NotificationManagerFactory;
import org.example.notifications.managers.MotivationNotificationManager;
import org.example.notifications.managers.NotificationManager;
import org.example.notifications.managers.PickupNotificationManager;
import org.example.users.db.HashMapUserDbServiceImpl;
import org.example.users.db.UserDbService;
import org.example.users.managers.UserManager;
import org.example.users.managers.UserManagerImpl;
import org.example.users.models.User;

public class Main {
    public static void main(String[] args) {
        // initialize the user services
        UserDbService userDbService = new HashMapUserDbServiceImpl();
        UserManager userManager = new UserManagerImpl(userDbService);

        // initialize the metrics services
        MetricsDbService metricsDbService = new HashMapMetricsDbServiceImpl();
        MetricsForUserDbService metricsForUserDbService = new HashMapMetricsForUserDbServiceImpl();
        MetricsManager metricsManager = new MetricsManagerImpl(
                metricsDbService,
                metricsForUserDbService
        );

        // initialize notification services
        NotificationManager motivationNotificationManager = new MotivationNotificationManager();
        NotificationManager pickupNotificationManager = new PickupNotificationManager();
        NotificationManagerFactory notificationManagerFactory = new NotificationManagerFactory(motivationNotificationManager, pickupNotificationManager);

        // initialize goal services
        GoalDbService goalDbService = new HashmapGoalDbServiceImpl();
        GoalManager goalManager = new GoalManagerImpl(goalDbService, metricsManager, userManager, notificationManagerFactory);


        // initialize few users
        User user1 = new User("Karan");
        userManager.addUser(user1);

        User user2 = new User("Jay");
        userManager.addUser(user2);

        // initialize all metrics
        Metric heartBeat = new Metric(MetricType.HEARTBEAT);
        heartBeat.setCanHaveGoal(false);
        Metric calories = new Metric(MetricType.CALORIES);
        Metric workoutTime = new Metric(MetricType.WORKOUT_TIME);
        Metric steps = new Metric(MetricType.STEPS);
        Metric waterIntake = new Metric(MetricType.WATER_INTAKE);
        metricsManager.addNewMetric(heartBeat);
        metricsManager.addNewMetric(calories);
        metricsManager.addNewMetric(workoutTime);
        metricsManager.addNewMetric(steps);
        metricsManager.addNewMetric(waterIntake);


        // Intialize metric capture for user
        metricsManager.enableMetricCaptureForUser(heartBeat, user1);
        metricsManager.enableMetricCaptureForUser(steps, user1);
        metricsManager.enableMetricCaptureForUser(heartBeat, user2);
        metricsManager.enableMetricCaptureForUser(waterIntake, user2);
        metricsManager.enableMetricCaptureForUser(workoutTime, user2);

        // User 1 creates goals for few of these metrics
        Goal goal = new Goal(
                user1.getId(),
                steps.getId()
        );
        goal.setGoalValue(10_000);
        goalManager.setGoalByUserForMetric(goal);

        // User 2 creates goals for few of these metrics
        Goal goal2 = new Goal(
                user2.getId(),
                workoutTime.getId()
        );
        goal2.setGoalValue(3);
        goalManager.setGoalByUserForMetric(goal2);

        Goal goal3 = new Goal(
                user2.getId(),
                waterIntake.getId()
        );
        goal3.setGoalValue(8);
        goalManager.setGoalByUserForMetric(goal3);

        // Metrics are getting captured
        metricsManager.captureMetricForUser(steps, user1, 500);
        goalManager.checkIfGoalCompletedForUser(goal);

        metricsManager.captureMetricForUser(steps, user1, 600);
        goalManager.checkIfGoalCompletedForUser(goal);

        metricsManager.captureMetricForUser(steps, user1, 5000);
        goalManager.checkIfGoalCompletedForUser(goal);

        metricsManager.captureMetricForUser(steps, user1, 9000);
        goalManager.checkIfGoalCompletedForUser(goal);

    }
}