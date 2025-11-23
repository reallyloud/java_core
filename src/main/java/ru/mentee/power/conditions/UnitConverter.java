package ru.mentee.power.conditions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UnitConverter {

    // TODO: Задайте значение константы для кода ошибки
    private static final double ERROR_CODE = -1.0;

    // TODO: Заполните списки поддерживаемых единиц измерения для каждой категории
    private static final List<String> LENGTH_UNITS = Arrays.asList(
            "Сантиметр", "Метр", "Фут", "Дюйм"
    );
    private static final List<String> WEIGHT_UNITS = Arrays.asList(
            "Грамм", "Килограмм", "Унция", "Фунт"
    );
    private static final List<String> TEMP_UNITS = Arrays.asList(
            "Цельсий", "Фаренгейт", "Кельвин"
    );

    /**
     * Конвертирует значение из одной единицы измерения в другую
     *
     * @param value    значение для конвертации
     * @param fromUnit исходная единица измерения
     * @param toUnit   целевая единица измерения
     * @return конвертированное значение или ERROR_CODE в случае ошибки
     */
    public double convert(double value, String fromUnit, String toUnit) {
        // TODO: Реализуйте метод согласно требованиям
        // 1. Проверьте, поддерживаются ли обе единицы
        if (getCategory(fromUnit).equals("error") || getCategory(toUnit).equals("error"))
            return ERROR_CODE;
        if (!areSameCategory(fromUnit, toUnit))
            return ERROR_CODE;
        // 2. Проверьте, относятся ли единицы к одной категории
        String category = getCategory(fromUnit);
        switch (category) {
            case "length":
                return convertLength(value, fromUnit, toUnit);
            case "weight":
                return convertWeight(value, fromUnit, toUnit);
            case "temp":
                return convertTemperature(value, fromUnit, toUnit);
            default:
                return ERROR_CODE;
        }
        // 3. Вызовите соответствующий метод конвертации (convertLength, convertWeight, convertTemperature)
        // Временная заглушка - измените на правильную реализацию
    }

    /**
     * Проверяет, относятся ли единицы измерения к одной категории
     *
     * @param unit1 первая единица измерения
     * @param unit2 вторая единица измерения
     * @return true, если единицы относятся к одной категории, иначе false
     */
    private boolean areSameCategory(String unit1, String unit2) {
        // TODO: Реализуйте метод проверки категорий
        if (getCategory(unit1).equals(getCategory(unit2)))
            return true;
        else
            return false;
    }

    /**
     * Определяет к какой категории относится единица измерения
     *
     * @param unit единица измерения
     * @return название категории ("Длина", "Вес", "Температура") или null, если единица не поддерживается
     */
    private String getCategory(String unit) {
        // TODO: Реализуйте метод определения категории
        if (LENGTH_UNITS.contains(unit))
            return "length";
        else if (WEIGHT_UNITS.contains(unit)) {
            return "weight";
        } else if (TEMP_UNITS.contains(unit)) {
            return "temp";
        } else return "error";
        // Проверьте, содержится ли единица в соответствующих списках
        // Временная заглушка - измените на правильную реализацию
    }

    /**
     * Конвертирует длину
     * Сначала конвертируем в базовую единицу (Метр), затем в целевую
     *
     * @param value    значение для конвертации
     * @param fromUnit исходная единица измерения
     * @param toUnit   целевая единица измерения
     * @return конвертированное значение
     */
    private double convertLength(double value, String fromUnit, String toUnit) {
        // TODO: Реализуйте метод конвертации длины
        if (fromUnit.equals("Сантиметр"))
            value = value / 100;
        else if (fromUnit.equals("Фут")) {
            value = value / 3.28;
        } else if (fromUnit.equals("Дюйм")) {
            value = value / 39.37;
        }

        if (toUnit.equals("Сантиметр"))
            value = value * 100;
        else if (toUnit.equals("Фут")) {
            value = value * 3.28;
        } else if (toUnit.equals("Дюйм")) {
            value = value * 39.37;
        }
        // 1. Сначала переведите значение из fromUnit в метры
        // 2. Затем переведите из метров в toUnit

        return value; // Временная заглушка - измените на правильную реализацию
    }

    /**
     * Конвертирует вес
     * Сначала конвертируем в базовую единицу (Килограмм), затем в целевую
     *
     * @param value    значение для конвертации
     * @param fromUnit исходная единица измерения
     * @param toUnit   целевая единица измерения
     * @return конвертированное значение
     */
    private double convertWeight(double value, String fromUnit, String toUnit) {
        // TODO: Реализуйте метод конвертации веса
        if (fromUnit.equals("Грамм"))
            value = value / 1000;
        else if (fromUnit.equals("Фунт"))
            value = value / 2.2046;
        else if (fromUnit.equals("Унция")) {
            value = value / 35.274;
        }

        if (toUnit.equals("Грамм"))
            value = value * 1000;
        if (toUnit.equals("Фунт"))
            value = value * 2.2046;
        else if (toUnit.equals("Унция")) {
            value = value * 35.274;
        }
        // 1. Сначала переведите значение из fromUnit в килограммы
        // 2. Затем переведите из килограммов в toUnit

        return value; // Временная заглушка - измените на правильную реализацию
    }

    /**
     * Конвертирует температуру
     * Используем прямые формулы конвертации
     *
     * @param value    значение для конвертации
     * @param fromUnit исходная единица измерения
     * @param toUnit   целевая единица измерения
     * @return конвертированное значение
     */
    private double convertTemperature(double value, String fromUnit, String toUnit) {
        // TODO: Реализуйте метод конвертации температуры
        if (fromUnit.equals("Фаренгейт"))
            value = (value - 32) / 1.8;
        else if (fromUnit.equals("Кельвин")) {
            value = value - 273.15;
        }

        if (toUnit.equals("Фаренгейт"))
            value = (value * 1.8) + 32;
        else if (toUnit.equals("Кельвин")) {
            value = value + 273.15;
        }
        // Используйте соответствующие формулы для каждой пары единиц
        // Для одинаковых единиц просто верните исходное значение

        return value; // Временная заглушка - измените на правильную реализацию
    }

    public static void main(String[] args) {
        UnitConverter converter = new UnitConverter();
        Scanner scanner = new Scanner(System.in);
        // TODO: Запросите у пользователя значение, исходную и целевую единицы
        // TODO: Вызовите метод convert и выведите результат
        // Пример:
        System.out.println("Введите значение:");
        double val = scanner.nextDouble();
        System.out.println("Введите исходную единицу:");
        String from = scanner.next();
        System.out.println("Введите целевую единицу:");
        String to = scanner.next();
        double result = converter.convert(val, from, to);
        if (result == ERROR_CODE) {
            System.out.println("Ошибка конвертации!");
        } else {
            System.out.println("Результат: " + result);
        }

        scanner.close();
    }
}