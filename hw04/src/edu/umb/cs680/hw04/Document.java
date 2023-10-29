package edu.umb.cs680.hw04;

class Document {
    private DocumentState currentState;

    public Document() {
        this.currentState = new EditingState(this);
    }

    public DocumentState getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(DocumentState state) {
        this.currentState = state;
    }

    public void editDocument() {
        currentState.editDocument();
    }

    public void saveDocument() {
        currentState.saveDocument();
    }

    public void viewDocument() {
        currentState.viewDocument();
    }

    public void exitDocument() {
        currentState.exitDocument();
    }
}

