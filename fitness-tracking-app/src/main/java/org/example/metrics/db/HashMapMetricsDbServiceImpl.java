package org.example.metrics.db;

import org.example.exceptions.InvalidOperationException;
import org.example.exceptions.NotFoundException;
import org.example.metrics.models.Metric;

import java.util.HashMap;
import java.util.Map;

public class HashMapMetricsDbServiceImpl implements MetricsDbService {

    Map<String, Metric> metricsDb = new HashMap<>(0);

    @Override
    public void createMetric(Metric metric) {
        metricsDb.put(metric.getId(), metric);
    }

    @Override
    public void updateMetric(Metric metric) {
        metricsDb.put(metric.getId(), metric);
    }

    @Override
    public void removeMetric(String id) {
        if (!metricsDb.containsKey(id))
            throw new InvalidOperationException("Failed to remove metric since metric with id not found!");
        metricsDb.remove(id);
    }

    @Override
    public Metric getMetric(String id) {
        if (!metricsDb.containsKey(id))
            throw new NotFoundException("Metric with id not found!");
        return metricsDb.get(id);
    }
}
