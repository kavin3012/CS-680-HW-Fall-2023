package edu.umb.cs680.hw04;

public class SavingState implements DocumentState{

    private Document document;

    public SavingState(Document document) {
        this.document = document;
    }

    @Override
    public void editDocument() {
        System.out.println("You cannot edit the document while it's being saved. Please wait.");
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
    
    @Override
    public void exitDocument() {
        System.out.println("You are exiting the Saving state. Enjoy editing the document......");
        document.setCurrentState(new EditingState(document));
    }

}
