package edu.umb.cs680.hw04;

public class ViewingState implements DocumentState{
    
    private Document document;

    public ViewingState(Document document) {
        this.document = document;
    }

    @Override
    public void editDocument() {
        System.out.println("You cannot edit the document while it's in Viewing state. Please make a copy if you want to edit.");
    }

    @Override
    public void saveDocument() {
        System.out.println("You cannot save the document while it's being viewed. Please exit the Viewing mode.");
    }

    @Override
    public void viewDocument() {
        System.out.println("You are already in the Viewing state. Enjoy reading the document.");
    }

    @Override
    public void exitDocument() {
        System.out.println("You are exiting the Viewing state. Enjoy editing the document......");
        document.setCurrentState(new EditingState(document));
    }

}
