import task3.*;

public class MainTask3 {
    public static void main(String[] args) {
        System.out.println("=== ЗАВДАННЯ 3: ОДИНАК ===\n");

        Authenticator auth1 = Authenticator.getInstance();
        auth1.login("user123");
        System.out.println("Поточний користувач: " + auth1.getCurrentUser());
        System.out.println("Автентифіковано: " + auth1.isAuthenticated());
        
        Authenticator auth2 = Authenticator.getInstance();
        System.out.println("\nСпроба отримати інший екземпляр...");
        System.out.println("Це той самий екземпляр? " + (auth1 == auth2));
        System.out.println("Поточний користувач через auth2: " + auth2.getCurrentUser());
        
        Authenticator auth3 = Authenticator.getInstance();
        System.out.println("Ще один екземпляр (auth3 == auth1)? " + (auth3 == auth1));
        
        auth1.logout();
        System.out.println("\nПісля виходу, автентифіковано: " + auth1.isAuthenticated());
        
    }
}
