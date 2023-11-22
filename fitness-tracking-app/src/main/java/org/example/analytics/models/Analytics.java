package org.example.analytics.models;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Analytics {
    private final String id;
    private final AnalyticsType analyticsType;
    private AnalyticsMetric analyticsMetric;
    private List<Integer> trend;
    private Instant startTimestamp;
    private Instant endTimestamp;
    private String userId;
    private String analyticsIdentifier; // here the identifier will either be metric or goal id basis the metric type

    private int numberOfRecordsConsideredInCalculation;

    public int getNumberOfRecordsConsideredInCalculation() {
        return numberOfRecordsConsideredInCalculation;
    }

    public void setNumberOfRecordsConsideredInCalculation(int numberOfRecordsConsideredInCalculation) {
        this.numberOfRecordsConsideredInCalculation = numberOfRecordsConsideredInCalculation;
    }

    public Analytics(AnalyticsType analyticsType) {
        this.id = UUID.randomUUID().toString();
        this.analyticsType = analyticsType;
    }

    public String getId() {
        return id;
    }

    public AnalyticsType getAnalyticsType() {
        return analyticsType;
    }

    public List<Integer> getTrend() {
        return trend;
    }

    public void setTrend(List<Integer> trend) {
        this.trend = trend;
    }

    public Instant getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Instant startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Instant getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Instant endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public String getUserId() {
        return userId;
    }

    public AnalyticsMetric getAnalyticsMetric() {
        return analyticsMetric;
    }

    public void setAnalyticsMetric(AnalyticsMetric analyticsMetric) {
        this.analyticsMetric = analyticsMetric;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAnalyticsIdentifier() {
        return analyticsIdentifier;
    }

    public void setAnalyticsIdentifier(String analyticsIdentifier) {
        this.analyticsIdentifier = analyticsIdentifier;
    }
}
