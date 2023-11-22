package org.example.metrics.db;

import org.example.exceptions.InvalidOperationException;
import org.example.metrics.models.MetricForUser;

import java.util.HashMap;
import java.util.Map;

public class HashMapMetricsForUserDbServiceImpl implements MetricsForUserDbService {

    Map<String, MetricForUser> metricsForUserDb = new HashMap<>(0);
    Map<Map<String, String>, MetricForUser> metricsForUserDbMap = new HashMap<>(0);

    @Override
    public void addMetricForUser(String metricId, String userId, int metricValue) {
        MetricForUser metricForUser = new MetricForUser(metricId, userId);
        metricForUser.setLastCapturedValue(metricValue);
        metricsForUserDb.put(metricForUser.getId(), metricForUser);
        metricsForUserDbMap.put(Map.of(userId, metricId), metricForUser);
    }

    @Override
    public void disableMetricForUser(String metricId, String userId) {
        if (!metricsForUserDbMap.containsKey(Map.of(userId, metricId)))
            throw new InvalidOperationException("Cannot disable metric for user since metric was not enabled in the first place!");

        MetricForUser metricForUser = metricsForUserDbMap.get(Map.of(userId, metricId));
        metricForUser.setCaptureEnabled(false);
        metricsForUserDb.put(metricForUser.getId(), metricForUser);
        metricsForUserDbMap.put(Map.of(userId, metricId), metricForUser);
    }

    @Override
    public MetricForUser getMetricForUser(String userId, String metricId) {
        if (!metricsForUserDbMap.containsKey(Map.of(userId, metricId)))
            throw new InvalidOperationException("Cannot get metric for user since metric to user mapping not found!");

        return metricsForUserDbMap.get(Map.of(userId, metricId));
    }
}
