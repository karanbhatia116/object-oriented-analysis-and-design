package org.example.analytics.factories;

import org.example.analytics.AnalyticsManager;
import org.example.analytics.models.AnalyticsType;

public interface AnalyticsManagerFactory {
    AnalyticsManager getAnalyticsManagerFactory(AnalyticsType analyticsType);
}
