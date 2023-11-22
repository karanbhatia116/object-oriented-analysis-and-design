package org.example.analytics.db.factories;

import org.example.analytics.db.AnalyticsDb;
import org.example.analytics.models.AnalyticsType;

public class AnalyticsDbFactoryImpl implements AnalyticsDbFactory {

    private final AnalyticsDb metricsAnalyticsDb;
    private final AnalyticsDb goalsAnalyticsDb;

    public AnalyticsDbFactoryImpl(AnalyticsDb metricsAnalyticsDb, AnalyticsDb goalsAnalyticsDb) {
        this.metricsAnalyticsDb = metricsAnalyticsDb;
        this.goalsAnalyticsDb = goalsAnalyticsDb;
    }

    @Override
    public AnalyticsDb getAnalyticsDb(AnalyticsType analyticsType) {
        switch (analyticsType) {
            case METRIC:
                return metricsAnalyticsDb;
            case GOAL:
                return goalsAnalyticsDb;
            default:
                return null;
        }
    }
}
