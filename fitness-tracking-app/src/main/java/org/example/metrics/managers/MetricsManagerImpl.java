package org.example.metrics.managers;

import org.example.metrics.db.MetricsDbService;
import org.example.metrics.db.MetricsForUserDbService;
import org.example.metrics.models.Metric;
import org.example.metrics.models.MetricForUser;
import org.example.users.models.User;

public class MetricsManagerImpl implements MetricsManager {

    private final MetricsDbService metricsDbService;
    private final MetricsForUserDbService metricsForUserDbService;

    public MetricsManagerImpl(MetricsDbService metricsDbService, MetricsForUserDbService metricsForUserDbService) {
        this.metricsDbService = metricsDbService;
        this.metricsForUserDbService = metricsForUserDbService;
    }

    @Override
    public void enableMetricCaptureForUser(Metric metric, User user) {
        metricsForUserDbService.addMetricForUser(metric.getId(), user.getId(), 0);
    }

    @Override
    public void captureMetricForUser(Metric metric, User user, int metricValue) {
        // once the metric is captured, check if the goal is completed or not

        // if the goal is close to be completed, then notify user with motivation

        // if the goal is close to start value and the time left in the day is only 20% then give pickup notification
        metricsForUserDbService.addMetricForUser(metric.getId(), user.getId(), metricValue);
    }

    @Override
    public MetricForUser getMetricForUser(String userId, String metricId) {
        return metricsForUserDbService.getMetricForUser(userId, metricId);
    }

    @Override
    public void addNewMetric(Metric metric) {
        metricsDbService.createMetric(metric);
    }

    @Override
    public void updateMetric(Metric metric) {
        metricsDbService.updateMetric(metric);
    }

    @Override
    public void deleteMetric(String id) {
        metricsDbService.removeMetric(id);
    }

    @Override
    public Metric getMetric(String id) {
        return metricsDbService.getMetric(id);
    }
}
