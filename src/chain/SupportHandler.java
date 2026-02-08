package chain;

// Базовий клас для ланцюжка обробників
public abstract class SupportHandler {
    protected SupportHandler nextHandler; // наступний обробник
    protected String levelName;

    public SupportHandler(String levelName) {
        this.levelName = levelName;
    }

    public void setNext(SupportHandler handler) {
        this.nextHandler = handler;
    }

    public abstract boolean handleRequest(String userInput);
}
