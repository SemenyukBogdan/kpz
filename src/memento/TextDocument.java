package memento;

public class TextDocument {
    private String content;

    public TextDocument() {
        this.content = "";
    }

    public TextDocument(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void append(String text) {
        this.content += text;
    }

    public void clear() {
        this.content = "";
    }

    @Override
    public String toString() {
        return content;
    }
}
