package strategy;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSystemImageLoader implements ImageLoadingStrategy {
    @Override
    public String loadImage(String href) {
        try {
            File file = new File(href);
            if (file.exists() && file.isFile()) {
                byte[] imageBytes = Files.readAllBytes(Paths.get(href));
                System.out.println("Зображення завантажено з файлової системи: " + href + " (" + imageBytes.length + " байт)");
                return "data:image/" + getFileExtension(href) + ";base64," + java.util.Base64.getEncoder().encodeToString(imageBytes);
            } else {
                System.out.println("Файл не знайдено: " + href);
                return "";
            }
        } catch (Exception e) {
            System.out.println("Помилка завантаження з файлової системи: " + e.getMessage());
            return "";
        }
    }

    private String getFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        if (lastDot > 0) {
            return filename.substring(lastDot + 1);
        }
        return "png";
    }
}
