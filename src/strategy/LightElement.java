package strategy;

import java.util.ArrayList;
import java.util.List;

public class LightElement extends LightNode {
    private String tagName;
    private String displayType;
    private String closingType;
    private List<String> cssClasses;
    private List<LightNode> children;

    public LightElement(String tagName, String displayType, String closingType) {
        this.tagName = tagName;
        this.displayType = displayType;
        this.closingType = closingType;
        this.cssClasses = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addClass(String cssClass) {
        cssClasses.add(cssClass);
    }

    public void addChild(LightNode child) {
        children.add(child);
    }

    @Override
    public String render() {
        StringBuilder html = new StringBuilder();
        html.append("<").append(tagName);
        
        if (!cssClasses.isEmpty()) {
            html.append(" class=\"").append(String.join(" ", cssClasses)).append("\"");
        }
        
        html.append(">");
        
        if (closingType.equals("double")) {
            html.append("\n");
            for (LightNode child : children) {
                html.append("  ").append(child.render().replace("\n", "\n  ")).append("\n");
            }
            html.append("</").append(tagName).append(">");
        } else {
            html.append("\n");
            for (LightNode child : children) {
                html.append("  ").append(child.render().replace("\n", "\n  ")).append("\n");
            }
        }
        
        return html.toString();
    }
}
