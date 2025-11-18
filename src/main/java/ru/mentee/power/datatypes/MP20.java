package ru.mentee.power.datatypes;
public class MP20 {
    public static void main(String[] args) {
        int i = 3;
        byte b = 2;
        long l = 53;
        double dbl = 3.5;
        String str1 = "Привет";
        String str2 = "Пока";
        int[] intArray = {5, 7, 3, 4, 4};
        String[] strArray = {"Максим", "Игнат", "Алексей"};

        System.out.println("int(3) + byte(2) = " + (i + b));
        System.out.println("int(3) / byte(2) = " + (i / b));
        System.out.println("double(3.5) / byte(2) = " + (dbl / b));
        System.out.println("(Преобразование) int(3) * dbl(3.5) = " + (i * dbl));
    }
}