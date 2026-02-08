package mediator;

// Aircraft не знає про Runway, тільки про CommandCentre
public class Aircraft {
    private String id;
    private CommandCentre commandCentre;

    public Aircraft(String id) {
        this.id = id;
    }

    public void setCommandCentre(CommandCentre commandCentre) {
        this.commandCentre = commandCentre;
    }

    public void requestLanding() {
        System.out.println("Літак " + id + " запитує дозвіл на посадку");
        if (commandCentre != null) {
            commandCentre.requestLanding(this);
        }
    }

    public void requestTakeoff() {
        System.out.println("Літак " + id + " запитує дозвіл на зліт");
        if (commandCentre != null) {
            commandCentre.requestTakeoff(this);
        }
    }

    public String getId() {
        return id;
    }

    public void land() {
        System.out.println("Літак " + id + " виконує посадку");
    }

    public void takeoff() {
        System.out.println("Літак " + id + " виконує зліт");
    }
}
