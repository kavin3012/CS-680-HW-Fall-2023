package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class FireAlarmTest {

    @Test
    public void testFireAlarmNotifyObserversMethod() {
        FireAlarm test = new FireAlarm();
        test.addObserver(new Speaker());
        test.addObserver(new LightBulb());
        test.notifyObservers(new Alert(Severity.WARN, "Temperatue is increasing"));
        assert(true);
    }

    @Test
    public void testFireAlarmGetObserversMethod() {
        FireAlarm test = new FireAlarm();
        Speaker speaker = new Speaker();
        LightBulb lightBulb = new LightBulb();

        test.addObserver(speaker);
        test.addObserver(lightBulb);

        List<Observer<Alert>> expected = List.of(speaker, lightBulb);
        assertIterableEquals(expected, test.getObservers());
    }


    @Test
    public void testFireAlarmCountObserversMethod() {
        FireAlarm test = new FireAlarm();
        test.addObserver(new Speaker());
        assertEquals(1, test.countObservers());
    }

    @Test
    public void testFireAlarmAddObserverMethod() {
        FireAlarm test = new FireAlarm();
        Observer<Alert> speaker = new Speaker();
        test.addObserver(speaker);
        List<Observer<Alert>> expected = List.of(speaker);
        assertEquals(1, test.countObservers());
        assertIterableEquals(expected, test.getObservers());
    }

    @Test
    public void testFireAlarmClearObserverMethod() {
        FireAlarm test = new FireAlarm();
        Observer<Alert> speaker = new Speaker();
        test.addObserver(speaker);
        test.clearObservers();
        List<Observer<Alert>> expected = List.of();
        assertEquals(0, test.countObservers());
        assertIterableEquals(expected, test.getObservers());
    }


}
