# Лабораторна робота №4
## Тема: Поведінкові шаблони проєктування

### Виконані завдання:

1. **Ланцюжок відповідальностей (Chain of Responsibility)**
   - Система підтримки користувачів з 4 рівнями
   - Пакет: `chain`
   - Запуск: `chain.ChainOfResponsibilityDemo`

2. **Посередник (Mediator)**
   - Рефакторинг системи управління повітряним рухом
   - Пакет: `mediator`
   - Запуск: `mediator.MediatorDemo`

5. **Мементо (Memento)**
   - Текстовий редактор з функцією undo/redo
   - Пакет: `memento`
   - Запуск: `memento.MementoDemo`

### Структура проекту:
```
src/
├── chain/          # Завдання 1
├── mediator/       # Завдання 2
└── memento/        # Завдання 5
```

### Компіляція та запуск:

1. **Спочатку скомпілюйте проект:**
```
chcp 65001 >nul

javac -d out -encoding UTF-8 -sourcepath src src\chain\*.java src\mediator\*.java src\memento\*. 

javac -d out -encoding UTF-8 -cp out Task*.java
```

2. **Запуск завдань:**
   ```bash
   # Варіант 1: З вказанням classpath
   java -cp out Task1  # Завдання 1 (Ланцюжок відповідальностей)
   java -cp out Task2  # Завдання 2 (Посередник)
   java -cp out Task5  # Завдання 5 (Мементо)
   
   ```



#### Вручну через командний рядок:
```bash
# Компіляція
javac -d out -encoding UTF-8 -sourcepath src src\chain\*.java src\mediator\*.java src\memento\*.java
javac -d out -encoding UTF-8 -cp out Task*.java

# Запуск (з папки проекту)
java -cp out Task1
java -cp out Task2
java -cp out Task5

# Або запуск оригінальних демо-класів
java -cp out chain.ChainOfResponsibilityDemo
java -cp out chain.InteractiveSupportDemo
java -cp out mediator.MediatorDemo
java -cp out memento.MementoDemo
```
