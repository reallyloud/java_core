package ru.mentee.power.conditions;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarEcoRating {

    // TODO: Задайте значения констант для кода ошибки, минимального и максимального рейтинга
    private static final int ERROR_CODE = -1;
    private static final int MIN_RATING = 1;
    private static final int MAX_RATING = 100;
    // TODO: Задайте год, с которого начинается штраф за возраст (например, 2020)
    private static final int EURO_STANDARD_YEAR_THRESHOLD = 2020; // Замените на корректное значение

    // TODO: Задайте значения констант для базовых рейтингов различных типов топлива
    private static final int BASE_RATING_ELECTRIC = 90; // Замените на корректное значение
    private static final int BASE_RATING_HYBRID = 70; // Замените на корректное значение
    private static final int BASE_RATING_DIESEL = 40; // Замените на корректное значение
    private static final int BASE_RATING_PETROL = 30; // Замените на корректное значение

    // TODO: Заполните список допустимых типов топлива
    private static final List<String> VALID_FUEL_TYPES = Arrays.asList(
            "Электро", "Гибрид", "Дизель", "Бензин"
    );

    /**
     * Рассчитывает экологический рейтинг автомобиля на основе его характеристик
     *
     * @param fuelType          тип топлива ("Бензин", "Дизель", "Гибрид", "Электро")
     * @param engineVolume      объем двигателя в литрах
     * @param fuelConsumption   расход топлива в л/100км или кВтч/100км
     * @param yearOfManufacture год выпуска автомобиля
     * @param isEuroCompliant   соответствует ли автомобиль стандарту Евро-6
     * @return эко-рейтинг автомобиля от MIN_RATING до MAX_RATING или ERROR_CODE в случае ошибки
     */
    public int calculateEcoRating(String fuelType, double engineVolume,
                                  double fuelConsumption, int yearOfManufacture,
                                  boolean isEuroCompliant) {
        if (!validateInput(fuelType, engineVolume, fuelConsumption, yearOfManufacture))
            return ERROR_CODE;
        int rating = getBaseFuelTypeRating(fuelType);
        rating = applyRatingModifiers(rating, fuelType, engineVolume, fuelConsumption, yearOfManufacture, isEuroCompliant);
        rating = clampRating(rating);
        // TODO: Реализуйте метод согласно требованиям
        // 1. Проверьте корректность входных данных через validateInput
        // 2. Определите базовый рейтинг через getBaseFuelTypeRating
        // 3. Примените модификаторы через applyRatingModifiers
        // 4. Ограничьте финальный рейтинг через clampRating

        return rating; // Временная заглушка - измените на правильную реализацию
    }

    /**
     * Проверяет корректность входных данных
     *
     * @param fuelType          тип топлива
     * @param engineVolume      объем двигателя
     * @param fuelConsumption   расход топлива
     * @param yearOfManufacture год выпуска
     * @return true, если все данные корректны, иначе false
     */
    private boolean validateInput(String fuelType, double engineVolume,
                                  double fuelConsumption, int yearOfManufacture) {
        if (!VALID_FUEL_TYPES.contains(fuelType))
            return false;
        if (engineVolume < 0 || fuelConsumption < 0)
            return false;
        if (yearOfManufacture > Year.now().getValue())
            return false;
        if (fuelType.equals("Электро") && engineVolume != 0)
            return false;
        else return true;
        // TODO: Реализуйте проверку входных данных
        // 1. Проверьте, содержится ли тип топлива в списке VALID_FUEL_TYPES
        // 2. Проверьте, что объем двигателя и расход топлива неотрицательны
        // 3. Проверьте, что год выпуска не превышает текущий год
        // 4. Дополнительно можно учесть, что для электромобилей объем должен быть 0
        // Временная заглушка - измените на правильную реализацию
    }

    /**
     * Определяет базовый рейтинг в зависимости от типа топлива
     *
     * @param fuelType тип топлива
     * @return базовый рейтинг или ERROR_CODE, если тип топлива неизвестен
     */
    private int getBaseFuelTypeRating(String fuelType) {
        // TODO: Реализуйте метод определения базового рейтинга с помощью switch
        if (fuelType.equals("Электро"))
            return 90;
        else if (fuelType.equals("Гибрид")) {
            return 70;
        } else if (fuelType.equals("Дизель")) {
            return 40;
        } else if (fuelType.equals("Бензин")) {
            return 30;
        } else return ERROR_CODE;
        // Для каждого типа топлива верните соответствующую константу

        // Временная заглушка - измените на правильную реализацию
    }

    /**
     * Применяет модификаторы рейтинга на основе характеристик автомобиля
     *
     * @param baseRating        базовый рейтинг
     * @param fuelType          тип топлива
     * @param engineVolume      объем двигателя
     * @param fuelConsumption   расход топлива
     * @param yearOfManufacture год выпуска
     * @param isEuroCompliant   соответствие стандарту Евро-6
     * @return итоговый рейтинг после применения модификаторов
     */
    private int applyRatingModifiers(int baseRating, String fuelType, double engineVolume,
                                     double fuelConsumption, int yearOfManufacture,
                                     boolean isEuroCompliant) {
        double rating = baseRating;

        if (!fuelType.equals("Электро")) {
            rating = rating - (engineVolume * 5);
            rating = rating - (fuelConsumption * 2);
        } else if (fuelType.equals("Электро")) {
            rating = rating - (fuelConsumption * 0.5);
        }
        if (yearOfManufacture < EURO_STANDARD_YEAR_THRESHOLD)
            rating = rating - (EURO_STANDARD_YEAR_THRESHOLD - yearOfManufacture);
        if (!fuelType.equals("Электро") & isEuroCompliant)
            rating = rating + 10;
        if (fuelType.equals("Гибрид") & fuelConsumption < 5)
            rating = rating + 15;
        rating = Math.round(rating);

        // TODO: Реализуйте метод применения модификаторов
        // 1. Начните с базового рейтинга
        // 2. Примените штрафы за объем двигателя в зависимости от типа топлива
        // 3. Примените штрафы за расход топлива в зависимости от типа топлива
        // 4. Примените штрафы за возраст автомобиля
        // 5. Примените бонусы за соответствие Евро-6 и экономичность гибрида
        // 6. Округлите результат до целого числа

        return (int) rating; // Временная заглушка - измените на правильную реализацию
    }

    /**
     * Ограничивает рейтинг в диапазоне от MIN_RATING до MAX_RATING
     *
     * @param rating рейтинг для ограничения
     * @return рейтинг в диапазоне от MIN_RATING до MAX_RATING
     */
    private int clampRating(int rating) {
        if (rating < MIN_RATING)
            return MIN_RATING;
        else if (rating > MAX_RATING) {
            return MAX_RATING;
        } else return rating;
        // TODO: Реализуйте метод ограничения рейтинга с помощью Math.max и Math.min
        // Используйте MIN_RATING и MAX_RATING для ограничения итогового значения
        // Временная заглушка - измените на правильную реализацию
    }

    public static void main(String[] args) {
        CarEcoRating ecoRating = new CarEcoRating();
        Scanner scanner = new Scanner(System.in);

        // TODO: Запросите у пользователя тип топлива, объем, расход, год, Евро-6
        // TODO: Вызовите метод calculateEcoRating и выведите результат
        // Пример:
        // System.out.println("Тип топлива (Бензин, Дизель, Гибрид, Электро):");
        // String type = scanner.next();
        // ... (остальные запросы)
        // int rating = ecoRating.calculateEcoRating(type, volume, consumption, year, isEuro);
        // if (rating == ERROR_CODE) { ... }

        scanner.close();
    }
}