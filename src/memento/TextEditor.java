package memento;

import java.util.Stack;

// зберігаємо стани для undo/redo
public class TextEditor {
    private TextDocument document;
    private Stack<DocumentMemento> history; // для undo
    private Stack<DocumentMemento> redoHistory; // для redo

    public TextEditor() {
        this.document = new TextDocument();
        this.history = new Stack<>();
        this.redoHistory = new Stack<>();
    }

    public TextEditor(TextDocument document) {
        this.document = document;
        this.history = new Stack<>();
        this.redoHistory = new Stack<>();
    }

    public void write(String text) {
        saveState();
        document.append(text);
        redoHistory.clear();
    }

    public void setText(String text) {
        saveState();
        document.setContent(text);
        redoHistory.clear();
    }

    public void clear() {
        saveState();
        document.clear();
        redoHistory.clear();
    }

    private void saveState() {
        history.push(new DocumentMemento(document.getContent()));
    }

    public void undo() {
        if (!history.isEmpty()) {
            // зберігаємо поточний стан для redo
            DocumentMemento currentState = new DocumentMemento(document.getContent());
            redoHistory.push(currentState);
            
            // відновлюємо попередній стан
            DocumentMemento previousState = history.pop();
            document.setContent(previousState.getContent());
            System.out.println("Відмінено зміни. Відновлено стан від " + 
                new java.util.Date(previousState.getTimestamp()));
        } else {
            System.out.println("Немає змін для відміни");
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            DocumentMemento currentState = new DocumentMemento(document.getContent());
            history.push(currentState);
            
            DocumentMemento nextState = redoHistory.pop();
            document.setContent(nextState.getContent());
            System.out.println("Повторено зміни. Відновлено стан від " + 
                new java.util.Date(nextState.getTimestamp()));
        } else {
            System.out.println("Немає змін для повторення");
        }
    }

    public String getContent() {
        return document.getContent();
    }

    public void showContent() {
        System.out.println("Поточний вміст документа:");
        System.out.println("---");
        System.out.println(document.getContent());
        System.out.println("---");
    }

    public int getHistorySize() {
        return history.size();
    }

    public int getRedoHistorySize() {
        return redoHistory.size();
    }
}
