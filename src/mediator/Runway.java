package mediator;

public class Runway {
    private String id;
    private boolean isAvailable;
    private CommandCentre commandCentre;

    public Runway(String id) {
        this.id = id;
        this.isAvailable = true;
    }

    public void setCommandCentre(CommandCentre commandCentre) {
        this.commandCentre = commandCentre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getId() {
        return id;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
        if (available) {
            System.out.println("Злітно-посадкова смуга " + id + " тепер вільна");
        } else {
            System.out.println("Злітно-посадкова смуга " + id + " зайнята");
        }
    }
}
