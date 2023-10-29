package edu.umb.cs680.hw05;

class Alert {

    private Severity severity;
    private String message;

    public Alert(Severity severity, String message) {
        this.severity = severity;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public Severity getSeverity() {
        return this.severity;
    }
}

enum Severity {
    WARN, ERROR, HAZARD
}