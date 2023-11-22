package org.example.analytics.db.metrics;


import org.example.analytics.db.AnalyticsDb;
import org.example.analytics.models.Analytics;
import org.example.exceptions.NotFoundException;

import java.util.HashMap;
import java.util.Map;

public class HashMapMetricsAnalyticsDb implements MetricsAnalyticsDb, AnalyticsDb {
    private Map<String, Analytics> metricsAnalyticsDb = new HashMap<>(0);

    @Override
    public void addAnalytics(Analytics analytics) {
        metricsAnalyticsDb.put(analytics.getId(), analytics);
    }

    @Override
    public void removeAnalytics(String id) {
        if (!metricsAnalyticsDb.containsKey(id))
            throw new NotFoundException("Unable to remove analytics from db since identifier is invalid or the value is not found!");
        metricsAnalyticsDb.remove(id);
    }

    @Override
    public void updateAnalytics(Analytics analytics) {
        metricsAnalyticsDb.put(analytics.getId(), analytics);
    }

    @Override
    public Analytics getAnalytics(String id) {
        if (!metricsAnalyticsDb.containsKey(id))
            throw new NotFoundException("Unable to get analytics from db since identifier is invalid or the value is not found!");
        return metricsAnalyticsDb.get(id);
    }
}
