package strategy;

// використовує різні стратегії завантаження
public class ImageElement extends LightNode {
    private String href;
    private ImageLoadingStrategy loadingStrategy;

    public ImageElement(String href) {
        this.href = href;
        determineStrategy(); // вибираємо стратегію залежно від href
    }

    private void determineStrategy() {
        if (href.startsWith("http://") || href.startsWith("https://")) {
            this.loadingStrategy = new NetworkImageLoader();
        } else {
            this.loadingStrategy = new FileSystemImageLoader();
        }
    }

    public void setLoadingStrategy(ImageLoadingStrategy strategy) {
        this.loadingStrategy = strategy;
    }

    @Override
    public String render() {
        String imageSrc = loadingStrategy.loadImage(href);
        if (imageSrc.isEmpty()) {
            return "<img src=\"\" alt=\"Помилка завантаження зображення\" />";
        }
        return "<img src=\"" + imageSrc + "\" alt=\"Image\" />";
    }
}
