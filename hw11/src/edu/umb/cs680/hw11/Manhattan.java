package edu.umb.cs680.hw11;

import java.util.List;

public class Manhattan implements DistanceMetric{
	public double distance(List<Double> p1, List<Double> p2) {
		double[] dimensions = new double[p1.size()];

		for(int i=0; i < p1.size(); i++) {
			dimensions[i] = Math.abs(p1.get(i)-p2.get(i));
		}
		double total = 0.0;
		for (double d: dimensions) {
			total += d;
		}
		return total;		
	}
}
