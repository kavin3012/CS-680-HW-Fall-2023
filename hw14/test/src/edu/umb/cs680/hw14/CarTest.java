package edu.umb.cs680.hw14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CarTest {

    @Test
    public void carTest5WithPriceComparator() {
        Car A = new Car("qqwwq", "sss", 1000, 50, 12212 );
        Car B = new Car("qwwqw", "sss", 1222, 334, 2333);
        Car C = new Car("qwwqw", "sss", 1222, 334, 23);
        Car[] unsorted = {A, B, C};
        Car[] sorted = {C, B, A};

        Arrays.sort(unsorted, (c1, c2) -> (int)c1.getPrice() - (int)c2.getPrice() );

        assertArrayEquals(sorted, unsorted);
    }

    @Test
    public void carTest5WithMileageComparator() {
        Car A = new Car("qqwwq", "sss", 1000, 50, 12212 );
        Car B = new Car("qwwqw", "sss", 1222, 334, 2333);
        Car C = new Car("qwwqw", "sss", 1222, 334, 23);
        Car[] unsorted = {A, B, C};
        Car[] sorted = {A, B, C};

        Arrays.sort(unsorted, (c1, c2) -> c1.getMileage() - c2.getMileage());

        assertArrayEquals(sorted, unsorted);
    }

    @Test
    public void carTest5WithYearComparator() {
        Car A = new Car("qqwwq", "sss", 1000, 50, 12212 );
        Car B = new Car("qwwqw", "sss", 1222, 334, 2333);
        Car C = new Car("qwwqw", "sss", 1226, 334, 23);
        Car[] unsorted = {A, B, C};
        Car[] sorted = {C, B, A};

        Arrays.sort(unsorted, (c1, c2) -> c2.getYear() - c1.getYear());

        assertArrayEquals(sorted, unsorted);
    }

    @Test
    public void carTest5WithParetoComparator() {
        Car A = new Car("qqwwq", "sss", 1, 3, 3);
        Car B = new Car("qwwqw", "sss", 2, 2, 2);
        Car C = new Car("qwwqw", "sss", 3, 1, 1);
        Car[] unsorted = {A, B, C};
        Car[] sorted = {C, B, A};

        for (int iter1 = 0; iter1 < unsorted.length; iter1++) {
            for (int iter2 = 0; iter2 < unsorted.length; iter2++) {
                if (iter1 != iter2) {
                    if (unsorted[iter1].getPrice() <= unsorted[iter2].getPrice() && 
                        unsorted[iter1].getMileage() <= unsorted[iter2].getMileage() && 
                        unsorted[iter1].getYear() >= unsorted[iter2].getYear() ) {
                        
                        if (unsorted[iter1].getPrice() < unsorted[iter2].getPrice() || 
                            unsorted[iter1].getMileage() < unsorted[iter2].getMileage() || 
                            unsorted[iter1].getYear() > unsorted[iter2].getYear() ) {
                        
                            unsorted[iter2].setDominationCount(unsorted[iter2].getDominationCount() + 1);
                        }
                    }
                }
            }
        }

        Arrays.sort(unsorted, (c1, c2) -> c1.getDominationCount() - c2.getDominationCount());

        assertArrayEquals(sorted, unsorted);
    }
}
