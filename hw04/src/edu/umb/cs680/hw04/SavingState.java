package edu.umb.cs680.hw04;

public class SavingState implements DocumentState{

    private Document document;

    public SavingState(Document document) {
        this.document = document;
    }

    @Override
    public void editDocument() {
        document.setCurrentState(new EditingState(document));
    }

    @Override
    public void saveDocument() {
        System.out.println("The document is already being saved. Please wait.");
    }

    @Override
    public void viewDocument() {
        System.out.println("Viewing the document...");
        // Transition to the Viewing state
        document.setCurrentState(new ViewingState(document));
    }
    
}
