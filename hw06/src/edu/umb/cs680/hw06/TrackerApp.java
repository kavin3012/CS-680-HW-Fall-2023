package edu.umb.cs680.hw06;

import java.util.LinkedList;

public class TrackerApp implements LocationObserver, StepCountObserver {
    
    private LinkedList<Location> locationList = new LinkedList<Location>();
    private LinkedList<StepCount> steps = new LinkedList<StepCount>();

    public void updateLocation(Location location) {
        locationList.add(location);
    }
    
    public void updateStepCount(StepCount stepCount) {
        steps.add(stepCount);
    }

    public Location getLatestLocation() {
        return locationList.getLast();
    }

    public StepCount getLatestStepCount() {
        return steps.getLast();
    }

    public int getTotalSteps() {
        return steps.size();
    }

    public int getTotalLocation() {
        return locationList.size();
    }

    public void clearLocation() {
        locationList.clear();
    }

    public void clearStep() {
        steps.clear();
    }
}
