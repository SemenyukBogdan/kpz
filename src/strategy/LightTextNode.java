package strategy;

public class LightTextNode extends LightNode {
    private String text;

    public LightTextNode(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}
