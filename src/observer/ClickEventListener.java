package observer;

public class ClickEventListener implements EventListener {
    private String name;

    public ClickEventListener(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(String eventType, LightElement element) {
        System.out.println("[" + name + "] Оброблено подію '" + eventType + "' на елементі <" + element.getTagName() + ">");
    }
}
