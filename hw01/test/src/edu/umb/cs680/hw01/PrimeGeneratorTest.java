package edu.umb.cs680.hw01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorTest {

    @Test
    public void testInvalidInputRange() {
        
        try {
            PrimeGenerator generatorInstance = new PrimeGenerator(100, 0);
            fail();
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Wrong input values: from=" + 100 + " to=" + 0);
        }
    }

    @Test
    public void testPrimes2to30() {
        PrimeGenerator gen = new PrimeGenerator(2, 30);
        gen.generatePrimes();
        LinkedList<Long> result = gen.getPrimes();

        List<Long> expected = List.of(2L, 3L,5L,  7L, 11L, 13L, 17L, 19L, 23L, 29L);
        assertIterableEquals(expected, result);
    }
}
