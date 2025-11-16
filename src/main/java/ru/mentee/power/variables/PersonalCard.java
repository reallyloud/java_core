package ru.mentee.power.variables;

public class PersonalCard {
    public static void main(String[] args) {
        // TODO: Создайте переменные разных типов и выведите информацию о себе
        // 1. Строковые переменные для имени, фамилии, города
        String name = "Максим";
        String surname = "Барк";
        String city = "Москва";
        // 2. Числовые переменные для возраста, роста, веса
        int age = 23;
        int height = 180;
        int weight = 75;
        // 3. Логическую переменную (например, является ли студентом)
        boolean isStudent = false;
        // 4. Символьную переменную (например, первая буква имени)
        char firstCharName = 'М';
        // После определения переменных, выведите всю информацию в консоль
        System.out.println("===== ЛИЧНАЯ КАРТОЧКА =====");
        System.out.println("Имя: " + name);
        System.out.println("Фамилия: " + surname);
        System.out.println("Возраст: " + age + " года");
        System.out.println("Город: " + city);
        System.out.println("Рост: " + height + " см");
        System.out.println("Вес " + weight + " кг");
        System.out.println("Студент: " + isStudent);
        System.out.println("Первая буква имени: " + firstCharName);
        System.out.println("==========================");
    }
}