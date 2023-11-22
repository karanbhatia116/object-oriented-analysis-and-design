package org.example.analytics;

import org.example.analytics.db.AnalyticsDb;
import org.example.analytics.db.factories.AnalyticsDbFactory;
import org.example.analytics.models.Analytics;
import org.example.analytics.models.AnalyticsMetric;
import org.example.analytics.models.AnalyticsType;
import org.example.goals.managers.GoalManager;

public class GoalAnalyticsManager implements AnalyticsManager {

    private final AnalyticsDbFactory analyticsDbFactory;

    private final AnalyticsDb analyticsDb;

    private final GoalManager goalManager;

    public GoalAnalyticsManager(AnalyticsDbFactory analyticsDbFactory, GoalManager goalManager) {
        this.analyticsDbFactory = analyticsDbFactory;
        this.analyticsDb = analyticsDbFactory.getAnalyticsDb(AnalyticsType.GOAL);
        this.goalManager = goalManager;
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
