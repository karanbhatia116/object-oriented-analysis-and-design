package org.example.analytics.db.goals;

import org.example.analytics.db.AnalyticsDb;
import org.example.analytics.models.Analytics;
import org.example.exceptions.NotFoundException;

import java.util.HashMap;
import java.util.Map;

public class HashMapGoalsAnalyticsDb implements AnalyticsDb, GoalsAnalyticsDb {

    private Map<String, Analytics> goalsAnalyticsDb = new HashMap<>(0);

    @Override
    public void addAnalytics(Analytics analytics) {
        goalsAnalyticsDb.put(analytics.getId(), analytics);
    }

    @Override
    public void removeAnalytics(String id) {
        if (!goalsAnalyticsDb.containsKey(id))
            throw new NotFoundException("Unable to remove analytics from db since identifier is invalid or the value is not found!");
        goalsAnalyticsDb.remove(id);
    }

    @Override
    public void updateAnalytics(Analytics analytics) {
        goalsAnalyticsDb.put(analytics.getId(), analytics);
    }

    @Override
    public Analytics getAnalytics(String id) {
        if (!goalsAnalyticsDb.containsKey(id))
            throw new NotFoundException("Unable to get analytics from db since identifier is invalid or the value is not found!");
        return goalsAnalyticsDb.get(id);
    }
}
