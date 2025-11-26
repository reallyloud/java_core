package ru.mentee.power.conditions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    Scanner scanner = new Scanner(System.in);
    // TODO: Задайте константы для ходов и результатов игры
    public static final String ROCK = "Камень";
    public static final String PAPER = "Бумага";
    public static final String SCISSORS = "Ножницы";

    public static final String WIN = "Победа игрока";
    public static final String LOSE = "Победа компьютера";
    public static final String DRAW = "Ничья";
    public static final String ERROR = "Ошибка";

    // TODO: Создайте список допустимых ходов
    private static final List<String> VALID_MOVES = Arrays.asList(ROCK, PAPER, SCISSORS);

    private Random random = new Random(); // Генератор случайных чисел

    /**
     * Определяет исход игры на основе ходов игрока и компьютера
     *
     * @param playerMove   ход игрока
     * @param computerMove ход компьютера
     * @return результат игры (WIN, LOSE, DRAW или ERROR)
     */
    public String determineWinner(String playerMove, String computerMove) {
        // TODO: Реализуйте определение победителя
        if (!validateMove(playerMove) || !validateMove(computerMove))
            return ERROR;
        if (playerMove.equals(computerMove))
            return DRAW;
        switch (playerMove) {
            case ROCK:
                if (computerMove.equals(PAPER))
                    return LOSE;
                else return WIN;
            case PAPER:
                if (computerMove.equals(ROCK))
                    return WIN;
                else return LOSE;
            case SCISSORS:
                if (computerMove.equals(PAPER))
                    return WIN;
                else return LOSE;
        }

        // 1. Проверьте валидность ходов через validateMove
        // 2. Проверьте условия ничьей
        // 3. Используйте вложенные условия или switch для определения победителя
        // Правила:
        // - Камень бьет ножницы
        // - Ножницы бьют бумагу
        // - Бумага бьет камень

        return ERROR; // Временная заглушка - измените на правильную реализацию
    }

    /**
     * Проверяет, является ли ход допустимым
     *
     * @param move ход для проверки
     * @return true, если ход допустим, иначе false
     */
    private boolean validateMove(String move) {
        if (VALID_MOVES.contains(move))
            return true;
        else return false;
        // TODO: Реализуйте проверку допустимости хода
        // Проверьте, содержится ли ход в списке VALID_MOVES (с учетом регистра)
        // Временная заглушка - измените на правильную реализацию
    }

    /**
     * Генерирует случайный ход компьютера
     *
     * @return случайный ход из списка допустимых
     */
    public String generateComputerMove() {
        Random random = new Random();
        String move = VALID_MOVES.get(random.nextInt(VALID_MOVES.size()));
        // TODO: Реализуйте генерацию случайного хода компьютера
        // 1. Создайте объект Random
        // 2. Сгенерируйте случайный индекс в пределах размера списка VALID_MOVES
        // 3. Верните элемент списка по этому индексу

        return move; // Временная заглушка - измените на правильную реализацию
    }

    /**
     * Запускает одну игровую сессию
     */
    public String playOneGame(String playerChoice) {
        String computerMove = generateComputerMove();
        String winner = determineWinner(playerChoice, computerMove);
        String summary = ("Компьютер выбрал:" + computerMove + ". Результат: " + winner);
        System.out.println(summary);
        if (winner.equals(ERROR))
            return ERROR;
        else
            return summary;
        // TODO: Реализуйте одну игровую сессию
        // 1. Запросите ход у игрока через Scanner
        // 2. Сгенерируйте ход компьютера
        // 3. Определите результат
        // 4. Выведите результат игры
    }

    /**
     * Запускает игровой цикл
     */
    public void startGameLoop() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Привет, добро пожаловать в RockPaperScissors!");
        System.out.println("Бумага бьёт камень, камень бьет ножницы, ножницы бьют бумагу");
        while (true) {
            System.out.println("Выбери свой предмет (Камень, Ножницы, Бумага):");
            playOneGame(sc.nextLine());
            System.out.println("Хочешь ли сыграть ещё?");
            if (!sc.nextLine().equalsIgnoreCase("да"))
                break;
        }
        // TODO: Реализуйте игровой цикл
        // 1. Приветствие и объяснение правил
        // 2. Запуск бесконечного цикла с вызовом playOneGame
        // 3. После каждой игры спрашивайте, хочет ли игрок сыграть еще
        // 4. Если игрок решил закончить, выведите статистику и завершите программу
    }

    public static void main(String[] args) {
        RockPaperScissors game = new RockPaperScissors();
        game.startGameLoop();
        // TODO: Запустите игровой цикл
        // game.startGameLoop();
    }
}