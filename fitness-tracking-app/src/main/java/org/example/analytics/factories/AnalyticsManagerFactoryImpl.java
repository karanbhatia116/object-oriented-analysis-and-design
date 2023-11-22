package org.example.analytics.factories;

import org.example.analytics.AnalyticsManager;
import org.example.analytics.models.AnalyticsType;

public class AnalyticsManagerFactoryImpl implements AnalyticsManagerFactory {

    private final AnalyticsManager goalAnalyticsManager;
    private final AnalyticsManager metricAnalyticsManager;

    public AnalyticsManagerFactoryImpl(AnalyticsManager goalAnalyticsManager, AnalyticsManager metricAnalyticsManager) {
        this.goalAnalyticsManager = goalAnalyticsManager;
        this.metricAnalyticsManager = metricAnalyticsManager;
    }

    @Override
    public AnalyticsManager getAnalyticsManagerFactory(AnalyticsType analyticsType) {
        switch (analyticsType) {
            case GOAL:
                return goalAnalyticsManager;
            case METRIC:
                return metricAnalyticsManager;
            default:
                return null;
        }
    }
}
