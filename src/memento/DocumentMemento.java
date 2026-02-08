package memento;

// зберігає стан документа
public class DocumentMemento {
    private final String content;
    private final long timestamp;

    public DocumentMemento(String content) {
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
