package org.example.metrics.db;

import org.example.metrics.models.Metric;

public interface MetricsDbService {
    void createMetric(Metric metric);

    void updateMetric(Metric metric);

    void removeMetric(String id);

    Metric getMetric(String id);
}
