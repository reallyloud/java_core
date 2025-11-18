package ru.mentee.power.variables;

public class TemperatureConverter {
    public static void main(String[] args) {
        // TODO: Определите константы для ключевых значений (например, абсолютный ноль в Кельвинах
        final double zeroCelsium = 0; // За основу беру цельсий
        final double zeroKelvin = -273.15; // если брать по цельсию
        final double zeroFahrenheit = 32; // если брать по цельсию
        // TODO: Создайте переменные с температурами в разных шкалах
        double tempCelsium = 54;
        double tempFahrenheit = 20;
        double tempKelvin = 35;
        // TODO: Напишите код для конвертации из одной шкалы в другую
        double celsiumFahrenheit = (tempCelsium* (9/5)) + 32;
        double fahrenheitCelsium = (tempFahrenheit - 32) * (5/9);
        double celsiumKelvin = (tempCelsium + 273.15);
        double kelvinCelsium = (tempKelvin - 273.15);
        // Формулы:
        // Цельсий в Фаренгейт: (C ? 9/5) + 32
        // Фаренгейт в Цельсий: (F ? 32) ? 5/9
        // Цельсий в Кельвин: C + 273.15
        // Кельвин в Цельсий: K ? 273.15
        System.out.println("Цельсий в Фаренгейт: 54 ->" + celsiumFahrenheit);
        System.out.println("Фаренгейт в Цельсий: 20 -> " + fahrenheitCelsium);
        System.out.println("Цельсий в Кельвин: 54 -> " + celsiumKelvin);
        System.out.println("Кельвин в Цельсий: 35 -> " + kelvinCelsium);
        // TODO: Выведите результаты конвертации
    }
}