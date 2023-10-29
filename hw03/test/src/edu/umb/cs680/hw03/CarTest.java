package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private static String[] carToStringArray(Car c) {
        String[] carInfo = new String[3];
        carInfo[0] = c.getMake();
        carInfo[1] = c.getModel();
        carInfo[2] = String.valueOf(c.getYear());
        return carInfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        Car toyota = new Car("Toyota", "RAV4", 2018, 0, 25000f);

        String[] expected = { "Toyota", "RAV4", "2018" };

        assertArrayEquals(expected, carToStringArray(toyota));
    }

    @Test
    public void testGetter1() {
        Car toyota = new Car("Toyota", "RAV4", 2018, 0, 25000f);
        assertEquals("Toyota", toyota.getMake());
    }

    @Test
    public void testGetter2() {
        Car toyota = new Car("Toyota", "RAV4", 2018, 0, 25000f);
        assertEquals("RAV4", toyota.getModel());
    }

    @Test
    public void testGetter3() {
        Car toyota = new Car("Toyota", "RAV4", 2018, 0, 25000f);
        assertEquals("2018", Integer.toString(toyota.getYear()));
    }

    @Test
    public void testGetter4() {
        Car toyota = new Car("Toyota", "RAV4", 2018, 0, 25000f);
        assertEquals("0", Integer.toString(toyota.getMileage()));
    }

    @Test
    public void testGetter5() {
        Car toyota = new Car("Toyota", "RAV4", 2018, 0, 25000f);
        assertEquals("25000.0", Float.toString(toyota.getPrice()));
    }
}
