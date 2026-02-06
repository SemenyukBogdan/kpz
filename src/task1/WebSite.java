package task1;

public class WebSite extends SubscriptionCreator {
    @Override
    public Subscription createSubscription() {
        System.out.println("Створення підписки через веб-сайт...");
        System.out.println("Виберіть тип підписки:");
        System.out.println("1. Domestic");
        System.out.println("2. Educational");
        System.out.println("3. Premium");
        
        // Симуляція вибору (в реальності був би ввід користувача)
        int choice = 2; // Приклад вибору Educational
        
        switch(choice) {
            case 1:
                return new DomesticSubscription();
            case 2:
                return new EducationalSubscription();
            case 3:
                return new PremiumSubscription();
            default:
                return new DomesticSubscription();
        }
    }
}
