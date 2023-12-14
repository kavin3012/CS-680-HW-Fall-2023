package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class TrackerAppTest {
    
    @Test
    public void locationObserverNotifyTest() {
        LocationSensor ob1 = new LocationSensor();
        StepCounter ob2 = new StepCounter();
        TrackerApp trackerApp = new TrackerApp();
        ob1.addObserver(trackerApp);
        ob2.addObserver(trackerApp);

        ob1.notifyObservers(new Location());
        assertEquals(1, trackerApp.getTotalLocation());
    }

    @Test
    public void stepCountObserverNotifyTest() {
        LocationSensor ob1 = new LocationSensor();
        StepCounter ob2 = new StepCounter();
        TrackerApp trackerApp = new TrackerApp();
        ob1.addObserver(trackerApp);
        ob2.addObserver(trackerApp);

        ob2.notifyObservers(new StepCount());
        assertEquals(1, trackerApp.getTotalSteps());
    }

    @Test
    public void locationSensorSize() {
        LocationSensor ob1 = new LocationSensor();
        StepCounter ob2 = new StepCounter();
        TrackerApp trackerApp = new TrackerApp();
        ob1.addObserver(trackerApp);
        ob2.addObserver(trackerApp);

        assertEquals(1, ob1.countObservers());
    }

    @Test
    public void stepCounterSize() {
        LocationSensor ob1 = new LocationSensor();
        StepCounter ob2 = new StepCounter();
        TrackerApp trackerApp = new TrackerApp();
        ob1.addObserver(trackerApp);
        ob2.addObserver(trackerApp);

        assertEquals(1, ob2.countObservers());
    }

    @Test
    public void getObserversSteps() {
        LocationSensor ob1 = new LocationSensor();
        StepCounter ob2 = new StepCounter();
        TrackerApp trackerApp = new TrackerApp();
        ob1.addObserver(trackerApp);
        ob2.addObserver(trackerApp);

        List<StepCountObserver> expected = Arrays.asList(trackerApp);

        assertIterableEquals(expected, ob2.getObservers());
    }

    @Test
    public void getObserversLocation() {
        LocationSensor ob1 = new LocationSensor();
        StepCounter ob2 = new StepCounter();
        TrackerApp trackerApp = new TrackerApp();
        ob1.addObserver(trackerApp);
        ob2.addObserver(trackerApp);

        List<LocationObserver> expected = Arrays.asList(trackerApp);

        assertIterableEquals(expected, ob1.getObservers());
    }

}
