package edu.umb.cs680.hw05;

public class LightBulb implements Observer<Alert>{

    public void update(Observable<Alert> observer, Alert alert) {
        if (alert.getSeverity() == Severity.HAZARD) {
            flashRed();
        } else if (alert.getSeverity() == Severity.WARN) {
            flashOrange();
        }

    }

    public void flashRed() {
        System.out.println("Flash Red Light");
    }

    public void flashOrange() {
        System.out.println("Flash Orange Light");
    }
}
