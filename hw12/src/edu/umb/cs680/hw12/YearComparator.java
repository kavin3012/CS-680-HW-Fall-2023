package edu.umb.cs680.hw12;

import java.util.Comparator;

public class YearComparator implements Comparator<Car>{
    public int compare(Car carA , Car carB) {
        return carB.getYear() - carA.getYear();
    }
}
