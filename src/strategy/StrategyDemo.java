package strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        LightElement div = new LightElement("div", "block", "double");
        div.addClass("container");
        
        LightElement h1 = new LightElement("h1", "block", "double");
        h1.addChild(new LightTextNode("Приклад використання Image елемента"));
        div.addChild(h1);
        
        System.out.println("=== Завантаження зображення з мережі ===");
        ImageElement networkImage = new ImageElement("https://via.placeholder.com/150");
        div.addChild(networkImage);
        
        System.out.println("\n=== Завантаження зображення з файлової системи ===");
        ImageElement fileSystemImage = new ImageElement("C:\\Users\\Bogdan\\Pictures\\test.png");
        div.addChild(fileSystemImage);
        
        System.out.println("\n=== Завантаження з файлової системи (відносний шлях) ===");
        ImageElement relativePathImage = new ImageElement("./images/photo.jpg");
        div.addChild(relativePathImage);
        
        System.out.println("\n=== HTML структура ===");
        System.out.println(div.render());
        
        System.out.println("\n=== Зміна стратегії вручну ===");
        ImageElement customImage = new ImageElement("https://example.com/image.png");
        System.out.println("Початкова стратегія (мережа):");
        customImage.render();
        
        System.out.println("\nЗміна на файлову систему:");
        customImage.setLoadingStrategy(new FileSystemImageLoader());
        customImage.render();
    }
}
