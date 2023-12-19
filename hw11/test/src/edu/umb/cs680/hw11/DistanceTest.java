package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class DistanceTest {

    private List<List<Double>> points = List.of(List.of(0.0,0.0), List.of(3.0, 4.0), List.of(6.0, 8.0));
    private static List<Car> cars = new ArrayList<>();
    private static Random rnd = new Random();

    @BeforeAll
    public static void setup() {
        for (int i = 0; i < 1300; i++) {
            cars.add(new Car("kmmknull", "kmkmnull", rnd.nextInt()*100, rnd.nextInt()*1000, rnd.nextFloat()*1000));
        }
    }

    public static List<List<Double>> zNormalize(List<Car> cars) {
        List<List<Double>> points = new ArrayList<>();
        for (Car c: cars) {
            points.add(List.of((double)c.getMileage(), (double)c.getPrice(), (double)c.getYear()));
        }
        double[] mean = new double[points.get(0).size()];
        double[] std = new double[points.get(0).size()];
        for (List<Double> p: points) {
            for (int i = 0; i < mean.length ; i++) {
                mean[i] += p.get(i);
            }
        }

        for (int i = 0; i < mean.length ; i++) {
            mean[i] = mean[i]/points.size();
        }

        for (List<Double> p: points) {
            for (int i = 0; i < std.length ; i++) {
                std[i] = std[i] + Math.pow(p.get(i)-mean[i],2);
            }
        }

        // standard deviation calculation
        for (int i = 0; i < std.length; i++) {
            std[i] = Math.sqrt(std[i] / points.size());
            if (std[i] == 0) {
                std[i] = 1; // Avoid division by zero, treat as no variation
            }
        }

        // normalization
        List<List<Double>> normalizedPoints = new ArrayList<>();
        for (List<Double> p: points) {
            List<Double> normalizedPoint = new ArrayList<>();
            for (int i = 0; i < p.size(); i++) {
                normalizedPoint.add((p.get(i) - mean[i]) / std[i]);
            }
            normalizedPoints.add(normalizedPoint);
        }
        return normalizedPoints;
    }

    @Test
    public void cosineDistancePoints() {
        List<List<Double>> points = List.of(List.of(3.0,4.0), List.of(3.0, 4.0), List.of(3.0, 4.0));
  


        List<List<Double>> matrix = Arrays.asList(
            Arrays.asList(0.0, 0.0, 0.0),
            Arrays.asList(0.0, 0.0, 0.0),
            Arrays.asList(0.0, 0.0, 0.0));
        assertIterableEquals(matrix, Distance.matrix(points, new Cosine()));
    }

    @Test
    public void manhattanDistancePoints() {
        List<List<Double>> matrix = Arrays.asList(
            Arrays.asList(0.0, 7.0, 14.0),
            Arrays.asList(7.0, 0.0, 7.0),
            Arrays.asList(14.0, 7.0, 0.0));
        assertIterableEquals(matrix, Distance.matrix(points, new Manhattan()));
    }


    @Test
    public void euclideanDistancePoints() {
        List<List<Double>> matrix = Arrays.asList(
            Arrays.asList(0.0, 5.0, 10.0),
            Arrays.asList(5.0, 0.0, 5.0),
            Arrays.asList(10.0, 5.0, 0.0));
        assertIterableEquals(matrix, Distance.matrix(points, new Euclidean()));
    }
    
    @Test
    public void euclideanDistanceP1andP2() {
        assertEquals(5.0, Distance.get(List.of(2.0,3.0), List.of(5.0, 7.0), new Euclidean()));
    }

    @Test
    public void manhattanDistanceP1andP2() {
        assertEquals(7.0, Distance.get(List.of(2.0,3.0), List.of(5.0, 7.0), new Manhattan()));
    }
    
    @Test
    public void cosineDistanceP1andP2() {
        assertEquals(5.198856603004787E-4, Distance.get(List.of(2.0,3.0), List.of(5.0, 7.0), new Cosine()));
    }


    @Test
    public void cosineDistanceOnCars() {
        List<List<Double>> normalized = zNormalize(cars);
        System.out.println(normalized);
        assertEquals(1300  ,Distance.matrix(normalized, new Cosine()).size());
        assertEquals(1300  ,Distance.matrix(normalized, new Cosine()).get(0).size());
    }

    @Test
    public void manhattanDistanceOnCars() {
        List<List<Double>> normalized = zNormalize(cars);
        System.out.println(normalized);
        assertEquals(1300  ,Distance.matrix(normalized, new Manhattan()).size());
        assertEquals(1300  ,Distance.matrix(normalized, new Manhattan()).get(0).size());
    }

    @Test
    public void euclideanDistanceOnCars() {
        List<List<Double>> normalized = zNormalize(cars);
        System.out.println(normalized);
        assertEquals(1300  ,Distance.matrix(normalized, new Euclidean()).size());
        assertEquals(1300  ,Distance.matrix(normalized, new Euclidean()).get(0).size());
    }



}


