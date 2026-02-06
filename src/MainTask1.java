import task1.*;

public class MainTask1 {
    public static void main(String[] args) {
        System.out.println("=== ЗАВДАННЯ 1: ФАБРИЧНИЙ МЕТОД ===\n");

        SubscriptionCreator website = new WebSite();
        Subscription sub1 = website.purchaseSubscription();
        sub1.displayInfo();
        System.out.println();

        SubscriptionCreator mobileApp = new MobileApp();
        Subscription sub2 = mobileApp.purchaseSubscription();
        sub2.displayInfo();
        System.out.println();

        SubscriptionCreator managerCall = new ManagerCall();
        Subscription sub3 = managerCall.purchaseSubscription();
        sub3.displayInfo();
        
    }
}
