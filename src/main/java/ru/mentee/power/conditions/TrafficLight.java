package ru.mentee.power.conditions;

import java.util.Scanner;

public class TrafficLight {

            public String getRecommendation(String color){
                color = color.toLowerCase();
                            switch (color) {
                                case "зелёный","зеленый":
                                    System.out.println("Переходите дорогу");
                                    return "Переходите дорогу";
                                case "желтый":
                                    System.out.println("Приготовьтесь идти");
                                    return "Приготовьтесь идти";
                                case "красный":
                                    System.out.println("Стойте!");
                                    return "Стойте";
                                default:
                                    System.out.println("Цвет неверный");
                                    return "Цвет неверный";
                            }
            }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Напишите цвет светофора");
        String answer = sc.nextLine();
    }
}
