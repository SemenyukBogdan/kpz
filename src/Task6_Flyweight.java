package lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Завдання 6: Легковаговик

class LightElementFlyweight {
    private static Map<String, LightElementFlyweight> cache = new HashMap<>();

    private String tagName;
    private DisplayType displayType;
    private ClosingType closingType;

    private LightElementFlyweight(String tagName, DisplayType displayType, ClosingType closingType) {
        this.tagName = tagName;
        this.displayType = displayType;
        this.closingType = closingType;
    }

    public static LightElementFlyweight getFlyweight(String tagName, DisplayType displayType, ClosingType closingType) {
        String key = tagName + "_" + displayType + "_" + closingType;
        
        if (!cache.containsKey(key)) {
            cache.put(key, new LightElementFlyweight(tagName, displayType, closingType));
        }

        return cache.get(key);
    }

    public String getTagName() {
        return tagName;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public ClosingType getClosingType() {
        return closingType;
    }
}

class LightTextNodeOptimized extends LightNode {
    private String text;

    public LightTextNodeOptimized(String text) {
        this.text = text;
    }

    @Override
    public String getOuterHTML() {
        return text;
    }

    @Override
    public String getInnerHTML() {
        return text;
    }
}

class LightElementNodeOptimized extends LightNode {
    private LightElementFlyweight flyweight;
    private List<String> cssClasses;
    private List<LightNode> children;

    public LightElementNodeOptimized(String tagName, DisplayType displayType, ClosingType closingType) {
        this.flyweight = LightElementFlyweight.getFlyweight(tagName, displayType, closingType);
        this.cssClasses = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addCssClass(String cssClass) {
        cssClasses.add(cssClass);
    }

    public void addChild(LightNode child) {
        children.add(child);
    }

    @Override
    public String getOuterHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(flyweight.getTagName());

        if (!cssClasses.isEmpty()) {
            sb.append(" class=\"").append(String.join(" ", cssClasses)).append("\"");
        }

        if (flyweight.getClosingType() == ClosingType.SELF_CLOSING) {
            sb.append(" />");
        } else {
            sb.append(">");
            sb.append(getInnerHTML());
            sb.append("</").append(flyweight.getTagName()).append(">");
        }

        return sb.toString();
    }

    @Override
    public String getInnerHTML() {
        StringBuilder sb = new StringBuilder();
        for (LightNode child : children) {
            sb.append(child.getOuterHTML());
        }
        return sb.toString();
    }
}

class Task6 {
    public static void demonstrate() {
        String bookText = "Заголовок книги\n" +
                         "Короткий рядок\n" +
                         "Це довгий рядок тексту який містить більше ніж двадцять символів\n" +
                         " Початок з пробілу\n" +
                         "Ще один довгий рядок тексту для демонстрації роботи системи\n" +
                         " Інший рядок з пробілу\n" +
                         "Фінальний рядок тексту";

        Runtime runtime = Runtime.getRuntime();
        System.gc();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        List<LightNode> nodesWithoutOptimization = convertToHTML(bookText, false);
        long memoryAfterWithout = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsedWithout = memoryAfterWithout - memoryBefore;

        System.gc();
        memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        List<LightNode> nodesWithOptimization = convertToHTML(bookText, true);
        long memoryAfterWith = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsedWith = memoryAfterWith - memoryBefore;

        System.out.println("HTML верстка книги:");
        for (LightNode node : nodesWithOptimization) {
            System.out.println(node.getOuterHTML());
        }

        System.out.println("\nПам'ять без оптимізації: ~" + memoryUsedWithout + " байт");
        System.out.println("Пам'ять з оптимізацією (легковаговик): ~" + memoryUsedWith + " байт");
        System.out.println("Економія пам'яті: ~" + (memoryUsedWithout - memoryUsedWith) + " байт");
    }

    private static List<LightNode> convertToHTML(String text, boolean useOptimization) {
        List<LightNode> nodes = new ArrayList<>();
        String[] lines = text.split("\n");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            LightNode node;

            if (i == 0) {
                if (useOptimization) {
                    LightElementNodeOptimized element = new LightElementNodeOptimized("h1", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
                    element.addChild(new LightTextNodeOptimized(line));
                    node = element;
                } else {
                    LightElementNode element = new LightElementNode("h1", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
                    element.addChild(new LightTextNode(line));
                    node = element;
                }
            } else if (line.length() < 20) {
                if (useOptimization) {
                    LightElementNodeOptimized element = new LightElementNodeOptimized("h2", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
                    element.addChild(new LightTextNodeOptimized(line));
                    node = element;
                } else {
                    LightElementNode element = new LightElementNode("h2", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
                    element.addChild(new LightTextNode(line));
                    node = element;
                }
            } else if (line.startsWith(" ")) {
                if (useOptimization) {
                    LightElementNodeOptimized element = new LightElementNodeOptimized("blockquote", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
                    element.addChild(new LightTextNodeOptimized(line.trim()));
                    node = element;
                } else {
                    LightElementNode element = new LightElementNode("blockquote", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
                    element.addChild(new LightTextNode(line.trim()));
                    node = element;
                }
            } else {
                if (useOptimization) {
                    LightElementNodeOptimized element = new LightElementNodeOptimized("p", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
                    element.addChild(new LightTextNodeOptimized(line));
                    node = element;
                } else {
                    LightElementNode element = new LightElementNode("p", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
                    element.addChild(new LightTextNode(line));
                    node = element;
                }
            }

            nodes.add(node);
        }

        return nodes;
    }
}
