package org.example.metrics.managers;

import org.example.metrics.models.Metric;
import org.example.metrics.models.MetricForUser;
import org.example.users.models.User;

public interface MetricsManager {
    void captureMetricForUser(Metric metric, User user, int metricValue);

    void enableMetricCaptureForUser(Metric metric, User user);

    MetricForUser getMetricForUser(String userId, String metricId);

    void addNewMetric(Metric metric);

    void updateMetric(Metric metric);

    void deleteMetric(String id);

    Metric getMetric(String id);
}
