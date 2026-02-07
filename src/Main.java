package lab3;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            // Запуск конкретного завдання
            try {
                int taskNumber = Integer.parseInt(args[0]);
                switch (taskNumber) {
                    case 1:
                        System.out.println("--- Завдання 1: Адаптер ---");
                        Task1.demonstrate();
                        break;
                    case 2:
                        System.out.println("--- Завдання 2: Декоратор ---");
                        Task2.demonstrate();
                        break;
                    case 3:
                        System.out.println("--- Завдання 3: Міст ---");
                        Task3.demonstrate();
                        break;
                    case 4:
                        System.out.println("--- Завдання 4: Проксі ---");
                        Task4.demonstrate();
                        break;
                    case 5:
                        System.out.println("--- Завдання 5: Компонувальник ---");
                        Task5.demonstrate();
                        break;
                    case 6:
                        System.out.println("--- Завдання 6: Легковаговик ---");
                        Task6.demonstrate();
                        break;
                    default:
                        System.out.println("Невірний номер завдання. Використовуйте 1-6");
                        printUsage();
                }
            } catch (NumberFormatException e) {
                System.out.println("Помилка: номер завдання має бути числом від 1 до 6");
                printUsage();
            }
        } else {
            // Запуск всіх завдань
            System.out.println("=== Лабораторна робота №3: Структурні шаблони ===\n");

            System.out.println("--- Завдання 1: Адаптер ---");
            Task1.demonstrate();
            System.out.println();

            System.out.println("--- Завдання 2: Декоратор ---");
            Task2.demonstrate();
            System.out.println();

            System.out.println("--- Завдання 3: Міст ---");
            Task3.demonstrate();
            System.out.println();

            System.out.println("--- Завдання 4: Проксі ---");
            Task4.demonstrate();
            System.out.println();

            System.out.println("--- Завдання 5: Компонувальник ---");
            Task5.demonstrate();
            System.out.println();

            System.out.println("--- Завдання 6: Легковаговик ---");
            Task6.demonstrate();
            System.out.println();

            System.out.println("Всі завдання виконано!");
        }
    }

    private static void printUsage() {
        System.out.println("\nВикористання:");
        System.out.println("  java lab3.Main          - запустити всі завдання");
        System.out.println("  java lab3.Main 1        - запустити тільки завдання 1");
        System.out.println("  java lab3.Main 2        - запустити тільки завдання 2");
        System.out.println("  ... і так далі до 6");
    }
}
