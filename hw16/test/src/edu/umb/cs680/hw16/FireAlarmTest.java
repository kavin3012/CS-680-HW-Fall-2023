package edu.umb.cs680.hw16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class FireAlarmTest {

    @Test
    public void testAddObserversMethod() {
        FireAlarm test = new FireAlarm();
        Observer<Alert> observer = (obs, alert) -> {
            if (alert.getSeverity() == Severity.WARN || alert.getSeverity() == Severity.HAZARD) {
                System.out.print(alert.getMessage());
            }};
        test.addObserver(observer);
        assertEquals(1, test.countObservers());
    }

    @Test
    public void testFireAlarmGetObserversMethod() {
        FireAlarm test = new FireAlarm();
        Observer<Alert>  speaker = (obs, alert) -> {
            if (alert.getSeverity() == Severity.WARN || alert.getSeverity() == Severity.HAZARD) {
                System.out.print(alert.getMessage());
            }
        };
        Observer<Alert> lightBulb = (obs, alert) -> {
            if (alert.getSeverity() == Severity.HAZARD) {
                System.out.println("Flash red light");
            } else if (alert.getSeverity() == Severity.WARN) {
                System.out.println("Flash orange light");
            }
        };

        test.addObserver(speaker);
        test.addObserver(lightBulb);

        List<Observer<Alert>> expected = List.of(speaker, lightBulb);
        assertIterableEquals(expected, test.getObservers());
    }

    @Test
    public void testFireAlarmCountObserversMethod() {
        FireAlarm test = new FireAlarm();
        test.addObserver((obs, alert) -> {
            if (alert.getSeverity() == Severity.WARN || alert.getSeverity() == Severity.HAZARD) {
                System.out.print(alert.getMessage());
            }
        });
        assertEquals(1, test.countObservers());
    }

    @Test
    public void testFireAlarmClearObserverMethod() {
        FireAlarm test = new FireAlarm();
        test.addObserver((obs, alert) -> {
            if (alert.getSeverity() == Severity.HAZARD) {
                System.out.println("Flash red light");
            } else if (alert.getSeverity() == Severity.WARN) {
                System.out.println("Flash orange light");
            }
        });
        test.clearObservers();
        List<Observer<Alert>> expected = List.of();
        assertEquals(0, test.countObservers());
        assertIterableEquals(expected, test.getObservers());
    }

}
