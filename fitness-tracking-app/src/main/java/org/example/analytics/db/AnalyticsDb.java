package org.example.analytics.db;

import org.example.analytics.models.Analytics;

public interface AnalyticsDb {
    void addAnalytics(Analytics analytics);

    void removeAnalytics(String id);

    void updateAnalytics(Analytics analytics);

    Analytics getAnalytics(String id);
}
