package memento;

public class MementoDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        System.out.println("=== Демонстрація роботи текстового редактора ===\n");

        System.out.println("1. Додаємо текст:");
        editor.write("Привіт, ");
        editor.showContent();
        System.out.println();

        System.out.println("2. Додаємо ще текст:");
        editor.write("це лабораторна робота ");
        editor.showContent();
        System.out.println();

        System.out.println("3. Додаємо фінальний текст:");
        editor.write("з патернів проєктування.");
        editor.showContent();
        System.out.println();

        System.out.println("4. Відміняємо останню зміну (undo):");
        editor.undo();
        editor.showContent();
        System.out.println();

        System.out.println("5. Відміняємо ще одну зміну:");
        editor.undo();
        editor.showContent();
        System.out.println();

        System.out.println("6. Повторюємо зміну (redo):");
        editor.redo();
        editor.showContent();
        System.out.println();

        System.out.println("7. Повторюємо ще одну зміну:");
        editor.redo();
        editor.showContent();
        System.out.println();

        System.out.println("8. Додаємо новий текст після redo:");
        editor.write(" з новим текстом!");
        editor.showContent();
        System.out.println("(Після нової зміни redo історія очищена)");
        System.out.println();

        System.out.println("9. Відміняємо зміну:");
        editor.undo();
        editor.showContent();
        System.out.println();

        System.out.println("10. Спробуємо відмінити, коли немає змін:");
        editor.undo();
        editor.undo();
        editor.undo();
        editor.showContent();
    }
}
