package org.example.goals.db;

import org.example.exceptions.InvalidOperationException;
import org.example.exceptions.NotFoundException;
import org.example.goals.models.Goal;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class HashmapGoalDbServiceImpl implements GoalDbService {

    private final Map<String, Goal> goalDb = new HashMap<>(0);

    @Override
    public void createGoal(Goal goal) {
        goalDb.put(goal.getId(), goal);
    }

    @Override
    public void updateGoal(Goal goal) {
        goalDb.put(goal.getId(), goal);
    }

    @Override
    public void deleteGoal(String id) {
        if (!goalDb.containsKey(id))
            throw new InvalidOperationException("Failed to delete goal since goal with id not found!");
        goalDb.remove(id);
    }

    @Override
    public Goal getGoal(String id) {
        if (!goalDb.containsKey(id))
            throw new NotFoundException("Goal with id not found!");
        return goalDb.get(id);
    }

    @Override
    public List<Goal> getGoalsByUserId(String userId) {
        return goalDb.values().stream().filter(goal -> Objects.equals(goal.getUserId(), userId)).collect(Collectors.toList());
    }

    @Override
    public List<Goal> getGoalsByUserIdAndTimestamps(String userId, Instant startTimestamp, Instant endTimestamp) {
        return goalDb.values().stream().filter(goal -> Objects.equals(goal.getUserId(), userId) &&
                goal.getGoalCreationTimestamp().isAfter(startTimestamp) && goal.getGoalCreationTimestamp().isBefore(endTimestamp)
        ).collect(Collectors.toList());
    }
}
