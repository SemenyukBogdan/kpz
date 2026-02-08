package strategy;

// інтерфейс для різних способів завантаження
public interface ImageLoadingStrategy {
    String loadImage(String href);
}
