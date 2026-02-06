package task1;

import java.util.Arrays;
import java.util.List;

public class EducationalSubscription extends Subscription {
    public EducationalSubscription() {
        super(149.0, 3,
            Arrays.asList("Освіта", "Наука", "Історія", "Документалістика"),
            Arrays.asList("HD якість", "Доступ до архіву 30 днів", "Без реклами", "Освітні матеріали"));
    }
}
