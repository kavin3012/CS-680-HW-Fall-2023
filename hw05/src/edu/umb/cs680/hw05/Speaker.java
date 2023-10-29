package edu.umb.cs680.hw05;

public class Speaker implements Observer<Alert>{
    
    public void update(Observable<Alert> observer ,Alert alert) {
        if (alert.getSeverity() == Severity.WARN || alert.getSeverity() == Severity.HAZARD) {
            annouce(alert.getMessage());
        }
    }

    public void annouce(String message) {
        System.out.println(message);
    }
}
