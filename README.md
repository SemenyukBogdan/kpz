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

3. **Спостерігач (Observer)**
   - Пакет: `observer`
   - Запуск: `observer.ObserverDemo`

4. **Стратегія (Strategy)**
   - Пакет: `strategy`
   - Запуск: `strategy.StrategyDemo`

5. **Мементо (Memento)**
   - Текстовий редактор з функцією undo/redo
   - Пакет: `memento`
   - Запуск: `memento.MementoDemo`

### Структура проекту:
```
src/
├── chain/          # Завдання 1
├── mediator/       # Завдання 2
├── observer/       # Завдання 3
├── strategy/       # Завдання 4
└── memento/        # Завдання 5
```

### Компіляція та запуск:

1. **Спочатку скомпілюйте проект:**

   ```
   javac -d out -encoding UTF-8 -sourcepath src src\chain\*.java src\mediator\*.java src\memento\*.java src\observer\*.java src\strategy\*.java
   javac -d out -encoding UTF-8 -cp out Task*.java
   ```

2. **Запуск завдань:**
   ```bash
   # З вказанням classpath
   java -cp out Task1  # Завдання 1 (Ланцюжок відповідальностей)
   java -cp out Task2  # Завдання 2 (Посередник)
   java -cp out Task3  # Завдання 3 (Спостерігач)
   java -cp out Task4  # Завдання 4 (Стратегія)
   java -cp out Task5  # Завдання 5 (Мементо)
   
   # Або перейти в папку out
   cd out
   java Task1
   java Task2
   # і т.д.
   ```

3. **Альтернативні способи:**
   - `run_all.bat` — запускає всі завдання по черзі
   - `run_task1_interactive.bat` — інтерактивний режим для завдання 1

#### Вручну через командний рядок:
```bash
# Компіляція
javac -d out -encoding UTF-8 -sourcepath src src\chain\*.java src\mediator\*.java src\memento\*.java src\observer\*.java src\strategy\*.java
javac -d out -encoding UTF-8 -cp out Task*.java

# Запуск (з папки проекту)
java -cp out Task1
java -cp out Task2
java -cp out Task3
java -cp out Task4
java -cp out Task5

# Оригінальні демо-класи
java -cp out chain.ChainOfResponsibilityDemo
java -cp out chain.InteractiveSupportDemo
java -cp out mediator.MediatorDemo
java -cp out observer.ObserverDemo
java -cp out strategy.StrategyDemo
java -cp out memento.MementoDemo
```
