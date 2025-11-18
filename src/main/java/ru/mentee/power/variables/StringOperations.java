package ru.mentee.power.variables;

public class StringOperations {
    public static void main(String[] args) {
        // TODO: Создайте несколько строковых переменных и символьных переменных
        String str1 = "Аб";
        String str2 = "Ба";
        String str3 = "ВГ";
        char ch1 = 'л';
        char ch2 = 'о';
        // TODO: Выполните различные операции:
        // 1. Конкатенация строк
        String concat = str1 + str2;
        // 2. Преобразование символа в строку
        String character = "" + ch1;
        // 3. Преобразование числа в строку и обратно
        String intParsing = 34 + "";
        int parsedInt = Integer.parseInt(intParsing);
        // 4. Извлечение символа из строки
        char[] charArray = str3.toCharArray();
        char parsedChar = charArray[1];
        // Выведите результаты всех операций
        System.out.println("Конкатенация: " + "\"Аб\" + \"Ба\" = " + concat);
        System.out.println("Символ в строку: " + "\'л\' -> " + "\"" + character + "\"");
        System.out.println("Число в строку: " + intParsing + " -> \"" + parsedInt + "\"");
        System.out.println("Строка в число: " + "\"" + parsedInt + "\"" + " -> " + intParsing);
        System.out.println("Символ из строки \"ВГ\": индекс 1 -> " + parsedChar );
    }
}