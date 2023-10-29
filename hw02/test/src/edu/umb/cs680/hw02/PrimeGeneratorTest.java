package edu.umb.cs680.hw02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorTest {

    @Test
    public void testNotNull() {
        PrimeGenerator generatorInstance = PrimeGenerator.getInstance();
        assertNotNull(generatorInstance);
    }

    @Test
    public void testIdenticalInstance() {
        PrimeGenerator generatorInstance1 = PrimeGenerator.getInstance();
        PrimeGenerator generatorInstance2 = PrimeGenerator.getInstance();
        assertSame(generatorInstance1, generatorInstance2);
    }

    @Test
    public void testInvalidInputRange() {
        PrimeGenerator generatorInstance = PrimeGenerator.getInstance();
        try {
            generatorInstance.generatePrimes(100, 0);
            fail();
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Wrong input values: from=" + 100 + " to=" + 0);
        }
    }

    @Test
    public void testPrimes2to30() {
        PrimeGenerator gen = PrimeGenerator.getInstance();
        gen.generatePrimes(2, 30);
        LinkedList<Long> result = gen.getPrimes();

        List<Long> expected = List.of(2L, 3L,5L,  7L, 11L, 13L, 17L, 19L, 23L, 29L);
        assertIterableEquals(expected, result);
    }

}
