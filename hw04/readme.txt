Document State Pattern

This Java program demonstrates the State design pattern applied to a simple document editor. The program uses different states to represent the behavior of a document and transitions between states when certain actions are performed.

Document Class

The Document class is the context class representing a document in different states. It maintains a reference to the current state and delegates actions to the state object. The available actions are editDocument(), saveDocument(), viewDocument(), and exitDocument(). The document starts in the "Editing" state.

DocumentState Interface

The DocumentState interface defines methods for the different actions or behaviors the document can have, including editing, saving, viewing, and exiting the document.

EditingState Class

The EditingState class implements the DocumentState interface and represents the state when the user is editing the document. It allows editing, saving, and prevents viewing.

SavingState Class

The SavingState class represents the state when the document is being saved. It allows viewing and prevents editing or saving again while saving is in progress.

ViewingState Class

The ViewingState class represents the state when the user is viewing the document. It allows viewing and prevents editing or saving.