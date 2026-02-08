package observer;

public interface EventListener {
    void handleEvent(String eventType, LightElement element);
}
