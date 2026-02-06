package task1;

public abstract class SubscriptionCreator {
    public abstract Subscription createSubscription();

    public Subscription purchaseSubscription() {
        Subscription subscription = createSubscription();
        System.out.println("Підписка створена через " + this.getClass().getSimpleName());
        return subscription;
    }
}
