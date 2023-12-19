package edu.umb.cs680.hw11;

import java.util.List;

public class Cosine implements DistanceMetric {

    public double distance(List<Double> p1, List<Double> p2) {
        
        //cosine distance = 1 - cosine similarity
        //cosine similarity = |A||B|cos(theta)

        double cosineSimi = 0.0;
        double[] dimensions = new double[p1.size()];
        for (int i = 0; i < dimensions.length; i++) {
            dimensions[i] = p1.get(i)*p2.get(i);
        }
        for (double d: dimensions) {
            cosineSimi += d;
        }

        double p1Value = 0.0;
        double p2Value = 0.0;
        for (int i = 0; i < dimensions.length; i++) {
            p1Value += p1.get(i)*p1.get(i);
            p2Value += p2.get(i)*p2.get(i);
        }
        cosineSimi = cosineSimi/Math.sqrt(p1Value*p2Value);

        return 1 - cosineSimi;
    }
}
