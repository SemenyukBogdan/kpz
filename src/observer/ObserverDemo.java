package observer;

public class ObserverDemo {
    public static void main(String[] args) {
        LightElement div = new LightElement("div", "block", "double");
        div.addClass("container");
        
        LightElement h1 = new LightElement("h1", "block", "double");
        h1.addChild(new LightTextNode("Заголовок сторінки"));
        div.addChild(h1);
        
        LightElement button = new LightElement("button", "inline", "double");
        button.addClass("btn");
        button.addClass("btn-primary");
        button.addChild(new LightTextNode("Натисни мене"));
        
        ClickEventListener clickHandler1 = new ClickEventListener("Обробник кліків 1");
        ClickEventListener clickHandler2 = new ClickEventListener("Обробник кліків 2");
        MouseOverEventListener mouseOverHandler = new MouseOverEventListener("Обробник наведення");
        
        button.addEventListener("click", clickHandler1);
        button.addEventListener("click", clickHandler2);
        button.addEventListener("mouseover", mouseOverHandler);
        
        div.addChild(button);
        
        System.out.println("=== HTML структура ===");
        System.out.println(div.render());
        
        System.out.println("\n=== Симуляція подій ===");
        System.out.println("Симуляція кліку на кнопку:");
        button.triggerEvent("click");
        
        System.out.println("\nСимуляція наведення миші на кнопку:");
        button.triggerEvent("mouseover");
        
        System.out.println("\nВидалення одного обробника кліків:");
        button.removeEventListener("click", clickHandler1);
        
        System.out.println("Симуляція кліку після видалення обробника:");
        button.triggerEvent("click");
    }
}
