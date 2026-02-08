package observer;

public class MouseOverEventListener implements EventListener {
    private String name;

    public MouseOverEventListener(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(String eventType, LightElement element) {
        System.out.println("[" + name + "] Миша наведена на елемент <" + element.getTagName() + ">");
    }
}
