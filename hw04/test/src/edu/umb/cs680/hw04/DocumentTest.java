package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DocumentTest {

    @Test
    public void testInitialDocumentState() {
        Document document = new Document();
        assertTrue(document.getCurrentState() instanceof EditingState);
    }

    @Test
    public void testEditDocumentEdit() {
        Document document = new Document();
        document.editDocument();
        assertTrue(document.getCurrentState() instanceof EditingState);
    }

    @Test
    public void testEditDocumentSave() {
        Document document = new Document();
        document.saveDocument();
        assertTrue(document.getCurrentState() instanceof SavingState);
    }

    @Test
    public void testEditDocumentView() {
        Document document = new Document();
        document.viewDocument();
        assertTrue(document.getCurrentState() instanceof ViewingState);
    }


    @Test
    public void testSaveDocumentEdit() {
        Document document = new Document();
        document.saveDocument();
        document.editDocument();
        assertTrue(document.getCurrentState() instanceof EditingState);
    }

    @Test
    public void testSaveDocumentView() {
        Document document = new Document();
        document.saveDocument();
        document.viewDocument();
        assertTrue(document.getCurrentState() instanceof ViewingState);
    }



    @Test
    public void testSaveDocumentSave() {
        Document document = new Document();
        document.saveDocument();
        document.saveDocument();
        assertTrue(document.getCurrentState() instanceof SavingState);
    }





    @Test
    public void testViewDocumentEdit() {
        Document document = new Document();
        document.viewDocument();
        document.editDocument();
        assertTrue(document.getCurrentState() instanceof EditingState);
    }

    @Test
    public void testViewDocumentSave() {
        Document document = new Document();
        document.viewDocument();
        document.saveDocument();
        assertTrue(document.getCurrentState() instanceof SavingState);
    }

    @Test
    public void testViewDocumentView() {
        Document document = new Document();
        document.viewDocument();
        document.viewDocument();
        assertTrue(document.getCurrentState() instanceof ViewingState);
    }



}
