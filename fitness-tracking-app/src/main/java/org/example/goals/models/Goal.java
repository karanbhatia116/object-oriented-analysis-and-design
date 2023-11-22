package org.example.goals.models;

import java.time.Instant;
import java.util.UUID;

public class Goal {
    private final String id;
    private final String userId;
    private final String metricId;

    private int goalValue;
    private int rewardForGoal;
    private boolean isCompleted;
    private final Instant goalCreationTimestamp;
    private Instant goalUpdateTimestamp;

    public Goal(String userId, String metricId) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.metricId = metricId;
        this.goalCreationTimestamp = Instant.now();
        this.goalUpdateTimestamp = Instant.now();
        this.isCompleted = false;
    }

    public String getId() {
        return id;
    }

    public int getGoalValue() {
        return goalValue;
    }

    public void setGoalValue(int goalValue) {
        this.goalValue = goalValue;
    }

    public int getRewardForGoal() {
        return rewardForGoal;
    }

    public void setRewardForGoal(int rewardForGoal) {
        this.rewardForGoal = rewardForGoal;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Instant getGoalCreationTimestamp() {
        return goalCreationTimestamp;
    }

    public Instant getGoalUpdateTimestamp() {
        return goalUpdateTimestamp;
    }

    public void setGoalUpdateTimestamp(Instant goalUpdateTimestamp) {
        this.goalUpdateTimestamp = goalUpdateTimestamp;
    }

    public String getUserId() {
        return userId;
    }

    public String getMetricId() {
        return metricId;
    }
}
