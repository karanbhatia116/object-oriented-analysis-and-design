package org.example.goals.db;

import org.example.goals.models.Goal;

import java.time.Instant;
import java.util.List;

public interface GoalDbService {
    void createGoal(Goal goal);

    void updateGoal(Goal goal);

    void deleteGoal(String id);

    Goal getGoal(String id);

    List<Goal> getGoalsByUserId(String userId);

    List<Goal> getGoalsByUserIdAndTimestamps(String userId, Instant startTimestamp, Instant endTimestamp);
}
