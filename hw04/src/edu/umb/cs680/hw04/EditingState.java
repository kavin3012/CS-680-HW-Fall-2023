package edu.umb.cs680.hw04;

class EditingState implements DocumentState {

    private Document document;

    public EditingState(Document document) {
        this.document = document;
    }

    @Override
    public void editDocument() {
        System.out.println("You are already in the Editing state. Keep editing the document.");
    }

    @Override
    public void saveDocument() {
        System.out.println("Saving the document...");
        // Transition to the Saving state
        document.setCurrentState(new SavingState(document));
    }

    @Override
    public void viewDocument() {
        System.out.println("You cannot view the document in Editing state. Save it first.");
    }

    @Override
    public void exitDocument() {
        System.out.println("You cannot exit the document, you need to close the application completely, make sure the document is saved");
    }
}