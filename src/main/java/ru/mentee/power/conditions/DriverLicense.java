package ru.mentee.power.conditions;
import java.util.Scanner;

public class DriverLicense {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Сколько вам лет?");
        int age = sc.nextInt();
        System.out.println("Есть ли у вас водительские права?");
        sc.nextLine();
        String answer = sc.nextLine();
        boolean license = (answer.equals("да"));
        if (age >= 18 && license) {
            System.out.println("Вы можете водить.");
        } else {
            System.out.println("Вы не можете водить.");
        }
    }
}
