package observer;

import java.util.*;

public class LightElement extends LightNode {
    private String tagName;
    private String displayType;
    private String closingType;
    private List<String> cssClasses;
    private List<LightNode> children;
    private Map<String, List<EventListener>> eventListeners; // обробники подій

    public LightElement(String tagName, String displayType, String closingType) {
        this.tagName = tagName;
        this.displayType = displayType;
        this.closingType = closingType;
        this.cssClasses = new ArrayList<>();
        this.children = new ArrayList<>();
        this.eventListeners = new HashMap<>();
    }

    public void addClass(String cssClass) {
        cssClasses.add(cssClass);
    }

    public void addChild(LightNode child) {
        children.add(child);
    }

    public void addEventListener(String eventType, EventListener listener) {
        eventListeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    public void removeEventListener(String eventType, EventListener listener) {
        List<EventListener> listeners = eventListeners.get(eventType);
        if (listeners != null) {
            listeners.remove(listener);
        }
    }

    public void triggerEvent(String eventType) {
        // викликаємо всіх обробників цієї події
        List<EventListener> listeners = eventListeners.get(eventType);
        if (listeners != null) {
            for (EventListener listener : listeners) {
                listener.handleEvent(eventType, this);
            }
        }
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

    public String getTagName() {
        return tagName;
    }
}
