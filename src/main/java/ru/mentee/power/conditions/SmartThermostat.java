package ru.mentee.power.conditions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SmartThermostat {

    // TODO: Задайте значение константы для кода ошибки температуры
    private static final double ERROR_TEMP_CODE = -100.0; // Значение можно изменить
    private static final int SAFETY_MAX = 25;
    private static final int SAFETY_MIN = 0;

    // TODO: Заполните списки для рабочих дней и выходных
    private static final List<String> WEEKDAYS = Arrays.asList(
            "Понедельник", "Вторник", "Среда", "Четверг", "Пятница"
    );
    private static final List<String> WEEKENDS = Arrays.asList(
            "Суббота", "Воскресенье"
    );

    /**
     * Определяет целевую температуру для термостата
     *
     * @param timeOfDay                 время суток в часах (0-23)
     * @param dayOfWeek                 день недели ("Понедельник", "Вторник", ..., "Воскресенье")
     * @param isOccupied                есть ли кто-то дома
     * @param currentOutsideTemperature текущая температура на улице (в градусах Цельсия)
     * @return целевую температуру для установки или ERROR_TEMP_CODE в случае некорректных входных данных
     */
    public double getTargetTemperature(int timeOfDay, String dayOfWeek, boolean isOccupied,
                                       double currentOutsideTemperature) {
        if (timeOfDay < 0 || timeOfDay > 23)
            return -100;
        if (!WEEKENDS.contains(dayOfWeek) && !WEEKDAYS.contains(dayOfWeek))
            return -100;

        int basicTargetTemp = 0;
        if (WEEKDAYS.contains(dayOfWeek) && isOccupied) {
            if (timeOfDay >= 6 && timeOfDay <= 8)
                basicTargetTemp = 22;
            else if (timeOfDay >= 9 && timeOfDay <= 17) {
                basicTargetTemp = 20;
            } else if (timeOfDay >= 18 && timeOfDay <= 22) {
                basicTargetTemp = 22;
            } else if (timeOfDay >= 23 || timeOfDay <= 5) {
                basicTargetTemp = 19;
            }
        }

        if (WEEKDAYS.contains(dayOfWeek) && !isOccupied) {
            if (timeOfDay >= 6 && timeOfDay <= 8)
                basicTargetTemp = 18;
            else if (timeOfDay >= 9 && timeOfDay <= 17) {
                basicTargetTemp = 16;
            } else if (timeOfDay >= 18 && timeOfDay <= 22) {
                basicTargetTemp = 17;
            } else if (timeOfDay >= 23 || timeOfDay <= 5) {
                basicTargetTemp = 16;
            }
        }

        if (WEEKENDS.contains(dayOfWeek) && isOccupied) {
            if (timeOfDay >= 7 && timeOfDay <= 9)
                basicTargetTemp = 23;
            else if (timeOfDay >= 10 && timeOfDay <= 17) {
                basicTargetTemp = 22;
            } else if (timeOfDay >= 18 && timeOfDay <= 23) {
                basicTargetTemp = 22;
            } else if (timeOfDay >= 0 && timeOfDay <= 6) {
                basicTargetTemp = 20;
            }
        }

        if (WEEKENDS.contains(dayOfWeek) && !isOccupied) {
            if (timeOfDay >= 7 && timeOfDay <= 9)
                basicTargetTemp = 18;
            else if (timeOfDay >= 10 && timeOfDay <= 17) {
                basicTargetTemp = 17;
            } else if (timeOfDay >= 18 && timeOfDay <= 23) {
                basicTargetTemp = 17;
            } else if (timeOfDay >= 0 && timeOfDay <= 6) {
                basicTargetTemp = 16;
            }
        }

        if (currentOutsideTemperature > SAFETY_MAX)
            basicTargetTemp++;
        else if (currentOutsideTemperature < SAFETY_MIN)
            basicTargetTemp--;


        // TODO: Реализуйте метод согласно требованиям
        // 1. Проверьте корректность входных данных (время, день недели)
        // 2. Определите базовую температуру в зависимости от дня недели, времени и присутствия
        // 3. Примените энергосберегающие правила

        return basicTargetTemp; // Временная заглушка - измените на правильную реализацию
    }

    public static void main(String[] args) {
        SmartThermostat thermostat = new SmartThermostat();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Напишите время: ");
        int timeOfDay = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Напишите день: ");
        String dayOfWeek = scanner.nextLine();
        System.out.println("Напишите занятость: ");
        boolean isOccupied = scanner.nextBoolean();
        System.out.println("Напишите темп. снаружи: ");
        int outsideTemp = scanner.nextInt();

        double targetTemp = thermostat.getTargetTemperature(timeOfDay, dayOfWeek, isOccupied, outsideTemp);
        if (targetTemp == ERROR_TEMP_CODE)
            System.out.println("Некорректные входные данные");
        else
            System.out.println("Целевая температура = " + targetTemp);

        // TODO: Запросите у пользователя необходимые данные (время, день, занятость, темп. снаружи)
        // TODO: Вызовите метод getTargetTemperature и выведите результат
        // Пример:
        // System.out.println("Введите время суток (0-23):");
        // int time = scanner.nextInt();
        // ... (остальные запросы)
        // double targetTemp = thermostat.getTargetTemperature(time, day, occupied, outsideTemp);
        // if (targetTemp == ERROR_TEMP_CODE) {
        //     System.out.println("Ошибка: Некорректные входные данные.");
        // } else {
        //     System.out.println("Рекомендуемая температура: " + targetTemp + "°C");
        // }

        scanner.close();
    }
}