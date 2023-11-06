package edu.umb.cs680.hw04;

public class ViewingState implements DocumentState{
    
    private Document document;

    public ViewingState(Document document) {
        this.document = document;
    }

    @Override
    public void editDocument() {
        document.setCurrentState(new EditingState(document));
    }

    @Override
    public void saveDocument() {
        document.setCurrentState(new SavingState(document));
    }

    @Override
    public void viewDocument() {
        System.out.println("You are already in the Viewing state. Enjoy reading the document.");
    }


}
