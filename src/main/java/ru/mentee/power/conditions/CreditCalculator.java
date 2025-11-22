package ru.mentee.power.conditions;

import java.util.Scanner;

public class CreditCalculator {

    // TODO: Объявите константы для базовых процентных ставок по типам кредитов
    // TODO: Объявите константы для диапазонов кредитного рейтинга
    // TODO: Объявите константы для диапазонов суммы кредита и срока кредита
    final double mortgageCreditRate = 0.09;
    final double defaultCreditRate = 0.15;
    final double carCreditRate = 0.12;

    final double idealCreditScoreRate = -0.02;
    final double goodCreditScoreRate = -0.01;
    final double defaultCreditScoreRate = 0;
    final double badCreditScoreRate = 0.03;
    /**
     * Рассчитывает ежемесячный платеж по кредиту
     *
     * @param loanAmount сумма кредита (от 10,000 до 10,000,000 руб.)
     * @param loanTermMonths срок кредита в месяцах (от 1 до 360)
     * @param creditType тип кредита ("Ипотека", "Потребительский", "Автокредит")
     * @param creditScore кредитный рейтинг клиента (от 300 до 850)
     * @return ежемесячный платеж или -1 в случае некорректных входных данных
     */
    public double calculateMonthlyPayment(double loanAmount, int loanTermMonths, String creditType, int creditScore) {
        // TODO: Реализуйте метод согласно требованиям
        if (loanAmount > 10000000 || loanAmount < 10000)
            return -1;
        if (creditScore < 300 || creditScore > 850)
            return -1;
        if (loanTermMonths < 1 || loanTermMonths > 360)
            return -1;

        double creditTypeRate;
        double creditScoreRate = 0;

        switch (creditType) {
            case "Ипотека":
                creditTypeRate = mortgageCreditRate;
                break;
            case "Потребительский":
                creditTypeRate = defaultCreditRate;
                break;
            case "Автокредит":
                creditTypeRate = carCreditRate;
                break;
            default:
                return -1;
        }


        if (creditScore >= 300 && creditScore < 500) {
            creditScoreRate = badCreditScoreRate;
        } else if (creditScore >= 500 && creditScore < 650) {
            creditScoreRate = defaultCreditScoreRate;
        } else if ( creditScore >= 650 && creditScore < 750) {
            creditScoreRate = goodCreditScoreRate;
        } else if (creditScore >= 750) {
            creditScoreRate = idealCreditScoreRate;
        }
        System.out.println("Кредитная ставка = " + (creditTypeRate + creditScoreRate)*100 + "%");
        double monthlyRate = (creditTypeRate + creditScoreRate) / 12;

        double monthlyPayment = loanAmount * (monthlyRate * Math.pow(1 + monthlyRate, loanTermMonths)) / (Math.pow(1 + monthlyRate, loanTermMonths) -1);

        return monthlyPayment;
    }

    public static void main(String[] args) {
        CreditCalculator calculator = new CreditCalculator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите сумму кредита:");
        double loanAmount = sc.nextDouble();
        System.out.println("Введите срок кредита:");
        int loanTermMonths = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите тип кредита:");
        String creditType = sc.nextLine();
        System.out.println("Введите кредитный рейтинг:");
        int creditScore = sc.nextInt();

        System.out.println("Ежемесячный платёж равен:" + calculator.calculateMonthlyPayment(loanAmount,loanTermMonths,creditType,creditScore));
        // TODO: Запросите у пользователя необходимые данные
        // TODO: Вызовите метод calculateMonthlyPayment и выведите результат

        sc.close();
    }
}