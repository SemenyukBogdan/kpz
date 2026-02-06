package task1;

import java.util.Arrays;
import java.util.List;

public class DomesticSubscription extends Subscription {
    public DomesticSubscription() {
        super(99.0, 1, 
            Arrays.asList("Новий канал", "1+1", "Інтер", "Україна 24"),
            Arrays.asList("HD якість", "Доступ до архіву 7 днів"));
    }
}
