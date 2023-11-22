package org.example.metrics.models;

import java.util.UUID;

public class Metric {
    private final String id;
    private final MetricType metricType;
    private int minValueForGoal;
    private int maxValueForGoal;
    private boolean canHaveGoal;

    public Metric(MetricType metricType) {
        this.id = UUID.randomUUID().toString();
        this.metricType = metricType;
    }

    public String getId() {
        return id;
    }

    public MetricType getMetricType() {
        return metricType;
    }

    public int getMinValueForGoal() {
        return minValueForGoal;
    }

    public int getMaxValueForGoal() {
        return maxValueForGoal;
    }

    public boolean canHaveGoal() {
        return canHaveGoal;
    }

    public void setMinValueForGoal(int minValueForGoal) {
        this.minValueForGoal = minValueForGoal;
    }

    public void setMaxValueForGoal(int maxValueForGoal) {
        this.maxValueForGoal = maxValueForGoal;
    }

    public void setCanHaveGoal(boolean canHaveGoal) {
        this.canHaveGoal = canHaveGoal;
    }
}
