package ru.mentee.power.loop;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private final Random random;
    private final Scanner scanner = new Scanner(System.in);

    // Статистика
    private int gamesPlayed = 0;
    private int minAttempts = Integer.MAX_VALUE;
    private int maxAttempts = 0;
    private int totalAttempts = 0;

    /**
     * Конструктор по умолчанию
     */
    public NumberGuessingGame() {
        this.random = createRandom();
    }

    /**
     * Создает объект Random для генерации случайных чисел
     * Метод выделен для возможности тестирования
     *
     * @return новый объект Random
     */
    boolean wantQuit(String quit) {
        if (quit.equals("q") || quit.equals("quit"))
            return true;
        else return false;
    }

    protected Random createRandom() {
        return new Random();
    }

    /**
     * Запускает игру "Угадай число"
     */
    public void startGame() {
        int playRound;
        do {
            playRound = playRound();
        } while (playRound != -1 && askPlayAgain());
        showStatistics();
        // TODO: Реализовать метод запуска игры
    }

    /**
     * Запускает один раунд игры
     *
     * @return количество попыток, потребовавшихся для угадывания
     */
    public int playRound() {
        // Загадываем число от 1 до 100
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean guessed = false;

        System.out.println("Я загадал число от 1 до 100. Попробуйте угадать!");
        do {
            System.out.print("Введите ваше предположение: ");
            String answer = scanner.nextLine();

            if (wantQuit(answer))
                return -1;
            int number = Integer.parseInt(answer);

            if (number == secretNumber)
                guessed = true;
            else if (number < secretNumber)
                System.out.println("Загаданное число больше!");
            else if (number > secretNumber)
                System.out.println("Загаданное число меньше!");
            attempts++;
        } while (guessed == false);
        System.out.println("Поздравляю! Вы угадали число " + secretNumber + " за " + attempts + " попыток.");
        // TODO: Реализовать игровой цикл с использованием do-while
        updateStatistics(attempts);
        return attempts;
    }

    /**
     * Обновляет статистику игр
     *
     * @param attempts количество попыток в текущей игре
     */
    private void updateStatistics(int attempts) {
        gamesPlayed++;
        if (attempts < minAttempts)
            minAttempts = attempts;
        if (attempts > maxAttempts)
            maxAttempts = attempts;
        totalAttempts = totalAttempts + attempts;
        // TODO: Реализовать обновление статистики
    }

    /**
     * Выводит текущую статистику игр
     */
    public void showStatistics() {
        System.out.println("=============== СТАТИСТИКА ===============");
        System.out.println("Сыграно игр: " + gamesPlayed);
        if (minAttempts == Integer.MAX_VALUE)
            minAttempts = 0;
        System.out.println("Минимальное количество попыток: " + minAttempts);
        System.out.println("Максимальное количество попыток: " + maxAttempts);
        double averageAttempts = 0;
        if (gamesPlayed > 0)
            averageAttempts = totalAttempts / gamesPlayed;
        System.out.println("Среднее количество попыток: " + averageAttempts);
        // TODO: Реализовать вывод статистики
    }

    /**
     * Спрашивает пользователя, хочет ли он сыграть еще раз
     *
     * @return true, если пользователь хочет продолжить, иначе false
     */
    private boolean askPlayAgain() {
        System.out.print("Хотите сыграть еще раз? (да/нет): ");
        String answer = scanner.next().toLowerCase();
        scanner.nextLine();
        return answer.equals("да") || answer.equals("yes") || answer.equals("y");
    }

    /**
     * Закрывает ресурсы
     */
    public void close() {
        scanner.close();
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();

        try {
            game.startGame();
        } finally {
            game.close();
        }
    }
}