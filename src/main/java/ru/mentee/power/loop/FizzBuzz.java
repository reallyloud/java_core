package ru.mentee.power.loop;

public class FizzBuzz {

    /**
     * Метод возвращает строковое представление чисел от 1 до n по правилам FizzBuzz
     *
     * @param n верхняя граница диапазона чисел
     * @return массив строк с результатами
     */
    public String[] generateFizzBuzz(int n) {

        String[] result = new String[n];
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                result[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                result[i - 1] = "Buzz";
            } else result[i - 1] = i + "";

        }
        // TODO: Реализовать метод
        return result;
    }

    /**
     * Метод выводит на экран числа от 1 до n по правилам FizzBuzz
     *
     * @param n верхняя граница диапазона чисел
     */
    public void printFizzBuzz(int n) {
        String[] fizzBuzz = generateFizzBuzz(n);
        for (String str : fizzBuzz) {
            System.out.println(str);
        }
        // TODO: Реализовать метод
    }

    public static void main(String[] args) {

        // Создаем экземпляр класса
        FizzBuzz fizzBuzz = new FizzBuzz();

        // Выводим результаты для n = 15
        System.out.println("FizzBuzz для чисел от 1 до 15:");
        fizzBuzz.printFizzBuzz(15);

    }
}