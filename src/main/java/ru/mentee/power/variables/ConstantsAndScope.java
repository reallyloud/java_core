package ru.mentee.power.variables;

public class ConstantsAndScope {
    // TODO: Объявите константы класса (static final)

    public static void main(String[] args) {
        // TODO: Объявите локальные переменные и локальные константы
        int intMain = 2;
        final int CONSTANT_INT = 3;
        // TODO: Создайте блок кода {} и объявите переменные внутри этого блока
        {
            int intBlock = 4;
            final int CONSTANT_INT_BLOCK = 5;
            // Переменные, видимые только внутри этого блока
        }

        System.out.println(intMain);
        System.out.println(CONSTANT_INT);
        // НЕ СРАБОТАЕТ System.out.println(intBlock); внутри блока кода
        // НЕ СРАБОТАЕТ System.out.println(CONSTAINT_INT_BLOCK); внутри блока кода
        // НЕ СРАБОТАЕТ System.out.println(localMethodStr); внутри метода локальная
        // TODO: Попробуйте обратиться к переменным из разных областей видимости
        // и прокомментируйте, что работает, а что вызывает ошибку и почему
    }

    // TODO: Создайте метод, который объявляет свои локальные переменные
    public static void someMethod() {
        String localMethodStr = "str";
        // Локальные переменные метода
    }
}