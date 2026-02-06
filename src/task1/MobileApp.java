package task1;

public class MobileApp extends SubscriptionCreator {
    @Override
    public Subscription createSubscription() {
        System.out.println("Відкрито мобільний додаток...");
        System.out.println("Пропозиція найпопулярнішої підписки Premium");
        
        // Мобільний додаток завжди пропонує Premium
        return new PremiumSubscription();
    }
}
