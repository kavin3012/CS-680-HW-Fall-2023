package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car>{
    public int compare(Car carA , Car carB) {
        return carA.getDominationCount() - carB.getDominationCount();
    }
}

