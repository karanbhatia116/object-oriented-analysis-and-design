package org.example.goals.managers;

import org.example.goals.models.Goal;

import java.time.Instant;
import java.util.List;

public interface GoalManager {
    void setGoalByUserForMetric(Goal goal);

    void updateGoalValueForUser(int newGoalValue, String goalId);

    void setRewardPointsForGoal(String goalId, int rewardPoints);

    boolean checkIfGoalCompletedForUser(Goal goal);

    void completeGoalForUser(Goal goal);

    List<Goal> getGoalsSetByUser(String userId);

    List<Goal> getGoalsByUserAndTimestamps(String userId, Instant startTimestamp, Instant endTimestamp);
}
