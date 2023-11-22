package org.example.metrics.models;

import java.time.Instant;
import java.util.UUID;

public class MetricForUser {
    private final String id;
    private final String metricId;
    private final String userId;
    private boolean isCaptureEnabled;
    private int lastCapturedValue;

    private Instant lastCaptureTimestamp;

    public MetricForUser(String metricId, String userId) {
        this.id = UUID.randomUUID().toString();
        this.metricId = metricId;
        this.userId = userId;
        this.isCaptureEnabled = true;
        this.lastCaptureTimestamp = Instant.now();
    }

    public int getLastCapturedValue() {
        return lastCapturedValue;
    }

    public void setLastCapturedValue(int lastCapturedValue) {
        this.lastCapturedValue = lastCapturedValue;
    }

    public String getId() {
        return id;
    }

    public String getMetricId() {
        return metricId;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isCaptureEnabled() {
        return isCaptureEnabled;
    }

    public void setCaptureEnabled(boolean captureEnabled) {
        isCaptureEnabled = captureEnabled;
    }

    public Instant getLastCaptureTimestamp() {
        return lastCaptureTimestamp;
    }

    public void setLastCaptureTimestamp(Instant lastCaptureTimestamp) {
        this.lastCaptureTimestamp = lastCaptureTimestamp;
    }
}
