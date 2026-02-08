package mediator;

public class MediatorDemo {
    public static void main(String[] args) {
        CommandCentre commandCentre = new CommandCentre();

        Runway runway1 = new Runway("RWY-01");
        Runway runway2 = new Runway("RWY-02");
        
        Aircraft aircraft1 = new Aircraft("AC-001");
        Aircraft aircraft2 = new Aircraft("AC-002");
        Aircraft aircraft3 = new Aircraft("AC-003");

        commandCentre.addRunway(runway1);
        commandCentre.addRunway(runway2);
        
        commandCentre.addAircraft(aircraft1);
        commandCentre.addAircraft(aircraft2);
        commandCentre.addAircraft(aircraft3);

        System.out.println("=== Демонстрація роботи системи ===\n");

        aircraft1.requestLanding();
        System.out.println();
        
        aircraft2.requestLanding();
        System.out.println();
        
        aircraft3.requestTakeoff();
        System.out.println();
        
        aircraft1.requestTakeoff();
        System.out.println();
        
        aircraft2.requestTakeoff();
    }
}
