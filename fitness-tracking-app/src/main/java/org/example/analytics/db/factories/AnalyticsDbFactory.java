package org.example.analytics.db.factories;

import org.example.analytics.db.AnalyticsDb;
import org.example.analytics.models.AnalyticsType;

public interface AnalyticsDbFactory {
    AnalyticsDb getAnalyticsDb(AnalyticsType analyticsType);
}
