package org.example.metrics.db;

import org.example.metrics.models.MetricForUser;

public interface MetricsForUserDbService {
    void addMetricForUser(String metricId, String userId, int metricValue);

    void disableMetricForUser(String metricId, String userId);

    MetricForUser getMetricForUser(String userId, String metricId);
}
