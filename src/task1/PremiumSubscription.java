package task1;

import java.util.Arrays;
import java.util.List;

public class PremiumSubscription extends Subscription {
    public PremiumSubscription() {
        super(299.0, 1,
            Arrays.asList("Всі канали", "Преміум контент", "Спорт", "Кіно", "Серіали"),
            Arrays.asList("4K якість", "Доступ до архіву 90 днів", "Без реклами", "Офлайн перегляд", "Мультиплікація"));
    }
}
