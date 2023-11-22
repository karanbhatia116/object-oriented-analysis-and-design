package org.example.analytics;


import org.example.analytics.db.AnalyticsDb;
import org.example.analytics.db.factories.AnalyticsDbFactory;
import org.example.analytics.models.Analytics;
import org.example.analytics.models.AnalyticsMetric;
import org.example.analytics.models.AnalyticsType;

public class MetricsAnalyticsManager implements AnalyticsManager {

    private final AnalyticsDbFactory analyticsDbFactory;
    private final AnalyticsDb analyticsDb;

    public MetricsAnalyticsManager(AnalyticsDbFactory analyticsDbFactory) {
        this.analyticsDbFactory = analyticsDbFactory;
        this.analyticsDb = analyticsDbFactory.getAnalyticsDb(AnalyticsType.METRIC);
    }

    @Override
    public Analytics calculateWeeklyMetricsForUser(String userId, AnalyticsMetric analyticsMetric) {
        return null;
    }

    @Override
    public Analytics calculateMonthlyMetricsForUser(String userId, AnalyticsMetric analyticsMetric) {
        return null;
    }

    @Override
    public Analytics calculateDailyTrendForUser(String userId, AnalyticsMetric analyticsMetric) {
        return null;
    }
}
