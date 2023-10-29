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
    public void testEditDocument() {
        Document document = new Document();
        document.editDocument();
        assertTrue(document.getCurrentState() instanceof EditingState);
    }

    @Test
    public void testSaveDocument() {
        Document document = new Document();
        document.saveDocument();
        assertTrue(document.getCurrentState() instanceof SavingState);
    }

    @Test
    public void testViewDocument() {
        Document document = new Document();
        document.saveDocument();
        document.viewDocument();
        assertTrue(document.getCurrentState() instanceof ViewingState);
    }

    @Test
    public void testExitDocument() {
        Document document = new Document();
        document.exitDocument();
        assertTrue(document.getCurrentState() instanceof EditingState);
    }
}