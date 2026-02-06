package task3;

public class Authenticator {
    private static Authenticator instance;
    private String currentUser;

    private Authenticator() {
        // Приватний конструктор для запобігання створення екземплярів
        currentUser = null;
    }

    public static Authenticator getInstance() {
        if (instance == null) {
            instance = new Authenticator();
        }
        return instance;
    }

    public void login(String username) {
        this.currentUser = username;
        System.out.println("Користувач " + username + " увійшов в систему");
    }

    public void logout() {
        System.out.println("Користувач " + currentUser + " вийшов з системи");
        this.currentUser = null;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public boolean isAuthenticated() {
        return currentUser != null;
    }
}
