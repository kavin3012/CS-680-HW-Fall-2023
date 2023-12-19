package edu.umb.cs680.hw12;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car>{
    public int compare(Car carA , Car carB) {
        return carA.getMileage() - carB.getMileage();
    }
}
