package lab3;

import java.util.ArrayList;
import java.util.List;

// Завдання 5: Компонувальник

abstract class LightNode {
    public abstract String getOuterHTML();
    public abstract String getInnerHTML();
}

class LightTextNode extends LightNode {
    private String text;

    public LightTextNode(String text) {
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

class LightElementNode extends LightNode {
    private String tagName;
    private DisplayType displayType;
    private ClosingType closingType;
    private List<String> cssClasses;
    private List<LightNode> children;

    public LightElementNode(String tagName, DisplayType displayType, ClosingType closingType) {
        this.tagName = tagName;
        this.displayType = displayType;
        this.closingType = closingType;
        this.cssClasses = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addCssClass(String cssClass) {
        cssClasses.add(cssClass);
    }

    public void addChild(LightNode child) {
        children.add(child);
    }

    public int getChildCount() {
        return children.size();
    }

    @Override
    public String getOuterHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(tagName);

        if (!cssClasses.isEmpty()) {
            sb.append(" class=\"").append(String.join(" ", cssClasses)).append("\"");
        }

        if (closingType == ClosingType.SELF_CLOSING) {
            sb.append(" />");
        } else {
            sb.append(">");
            sb.append(getInnerHTML());
            sb.append("</").append(tagName).append(">");
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

enum DisplayType {
    BLOCK,
    INLINE
}

enum ClosingType {
    SELF_CLOSING,
    WITH_CLOSING_TAG
}

class Task5 {
    public static void demonstrate() {
        LightElementNode table = new LightElementNode("table", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        table.addCssClass("students-table");

        LightElementNode thead = new LightElementNode("thead", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        LightElementNode headerRow = new LightElementNode("tr", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        
        LightElementNode th1 = new LightElementNode("th", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        th1.addChild(new LightTextNode("Ім'я"));
        LightElementNode th2 = new LightElementNode("th", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        th2.addChild(new LightTextNode("Вік"));
        LightElementNode th3 = new LightElementNode("th", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        th3.addChild(new LightTextNode("Оцінка"));

        headerRow.addChild(th1);
        headerRow.addChild(th2);
        headerRow.addChild(th3);
        thead.addChild(headerRow);
        table.addChild(thead);

        LightElementNode tbody = new LightElementNode("tbody", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);

        LightElementNode row1 = new LightElementNode("tr", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        LightElementNode td1_1 = new LightElementNode("td", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        td1_1.addChild(new LightTextNode("Іван"));
        LightElementNode td1_2 = new LightElementNode("td", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        td1_2.addChild(new LightTextNode("20"));
        LightElementNode td1_3 = new LightElementNode("td", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        td1_3.addChild(new LightTextNode("95"));
        row1.addChild(td1_1);
        row1.addChild(td1_2);
        row1.addChild(td1_3);
        tbody.addChild(row1);

        LightElementNode row2 = new LightElementNode("tr", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        LightElementNode td2_1 = new LightElementNode("td", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        td2_1.addChild(new LightTextNode("Марія"));
        LightElementNode td2_2 = new LightElementNode("td", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        td2_2.addChild(new LightTextNode("19"));
        LightElementNode td2_3 = new LightElementNode("td", DisplayType.BLOCK, ClosingType.WITH_CLOSING_TAG);
        td2_3.addChild(new LightTextNode("88"));
        row2.addChild(td2_1);
        row2.addChild(td2_2);
        row2.addChild(td2_3);
        tbody.addChild(row2);

        table.addChild(tbody);

        System.out.println("Згенерований HTML:");
        System.out.println(table.getOuterHTML());
        System.out.println("\nКількість дочірніх елементів у таблиці: " + table.getChildCount());
    }
}
