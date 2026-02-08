package mediator;

import java.util.ArrayList;
import java.util.List;

// Посередник - Aircraft і Runway спілкуються через нього
public class CommandCentre {
    private List<Runway> runways;
    private List<Aircraft> aircrafts;

    public CommandCentre() {
        this.runways = new ArrayList<>();
        this.aircrafts = new ArrayList<>();
    }

    public void addRunway(Runway runway) {
        runways.add(runway);
        runway.setCommandCentre(this);
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
        aircraft.setCommandCentre(this);
    }

    public void requestLanding(Aircraft aircraft) {
        System.out.println("Командно-диспетчерський пункт обробляє запит на посадку від " + aircraft.getId());
        
        for (Runway runway : runways) {
            if (runway.isAvailable()) {
                runway.setAvailable(false);
                System.out.println("Дозвіл на посадку надано. Використовується смуга " + runway.getId());
                aircraft.land();
                runway.setAvailable(true);
                return;
            }
        }
        
        System.out.println("Всі злітно-посадкові смуги зайняті. Посадка неможлива.");
    }

    public void requestTakeoff(Aircraft aircraft) {
        System.out.println("Командно-диспетчерський пункт обробляє запит на зліт від " + aircraft.getId());
        
        for (Runway runway : runways) {
            if (runway.isAvailable()) {
                runway.setAvailable(false);
                System.out.println("Дозвіл на зліт надано. Використовується смуга " + runway.getId());
                aircraft.takeoff();
                runway.setAvailable(true);
                return;
            }
        }
        
        System.out.println("Всі злітно-посадкові смуги зайняті. Зліт неможливий.");
    }
}
