package edu.umb.cs680.hw12;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car>{
    public int compare(Car carA , Car carB) {
        return (int)carA.getPrice() - (int)carB.getPrice();
    }
}
