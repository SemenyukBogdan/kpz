package strategy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;

public class NetworkImageLoader implements ImageLoadingStrategy {
    @Override
    public String loadImage(String href) {
        try {
            URL url = new URL(href);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                byte[] imageBytes = inputStream.readAllBytes();
                inputStream.close();
                System.out.println("Зображення завантажено з мережі: " + href + " (" + imageBytes.length + " байт)");
                return href;
            } else {
                System.out.println("Не вдалося завантажити зображення з мережі. Код відповіді: " + connection.getResponseCode());
                return "";
            }
        } catch (Exception e) {
            System.out.println("Помилка завантаження з мережі: " + e.getMessage());
            return "";
        }
    }
}
