package ru.mentee.power.conditions;
import java.util.Scanner;

public class WeekdayDeterminer {
    public String getDayOfWeek (int day) {
    switch (day) {
        case 1:
            return "Понедельник";
        case 2:
            return "Вторник";
        case 3:
            return "Среда";
        case 4:
            return "Четверг";
        case 5:
            return "Пятница";
        case 6:
            return "Суббота";
        case 7:
            return "Воскресенье";
        default:
            return "Неверное число";
    }
    }
    public boolean isWeekend (int day) {
        switch (day) {
            case 1,2,3,4,5:
                return false;
            case 6,7:
                return true;
            default:
                System.out.println("Некорректный день");
                return false;
        }
    }

    public static void main(String[] args) {
        WeekdayDeterminer weekdayDeterminer = new WeekdayDeterminer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите день недели");
        int day = sc.nextInt();
        System.out.print(weekdayDeterminer.getDayOfWeek(day) + ", ");
        if (weekdayDeterminer.isWeekend(day) == true)
            System.out.println("выходной");
        else
            System.out.println("рабочий день");
    }
    }


