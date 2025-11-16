package ru.mentee.power;

public class TypeCalculator {
    public static void main(String[] args) {
        // TODO: Объявите переменные различных числовых типов
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 4;
        float fl = 5;
        double dbl = 6;
        // 1. byte, short, int, long
        // 2. float, double

        // TODO: Выполните операции между переменными разных типов
        System.out.println("int(3) + long(4) = " + (i + l));
        System.out.println("float(5) + byte(1) = " + (fl + b));
        System.out.println("double(6) + int (3) = " + (dbl + i));
        System.out.println("short(2) + float(5) = " + (s + fl));
        // Пример: int + byte, double + int, и т.д.

        // TODO: Выведите результаты операций и тип результата (для этого можно использовать комментарии)
    }
}