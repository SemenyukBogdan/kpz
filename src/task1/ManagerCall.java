package task1;

public class ManagerCall extends SubscriptionCreator {
    @Override
    public Subscription createSubscription() {
        System.out.println("Менеджер обробляє ваш запит...");
        System.out.println("Рекомендована підписка: Educational (знижка для студентів)");
        
        // Менеджер завжди рекомендує Educational
        return new EducationalSubscription();
    }
}
