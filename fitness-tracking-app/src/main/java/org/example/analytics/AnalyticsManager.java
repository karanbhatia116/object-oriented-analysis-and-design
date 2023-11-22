package org.example.analytics;

import org.example.analytics.models.Analytics;
import org.example.analytics.models.AnalyticsMetric;

public interface AnalyticsManager {
    Analytics calculateWeeklyMetricsForUser(String userId, AnalyticsMetric analyticsMetric);

    Analytics calculateMonthlyMetricsForUser(String userId, AnalyticsMetric analyticsMetric);

    Analytics calculateDailyTrendForUser(String userId, AnalyticsMetric analyticsMetric);
}
