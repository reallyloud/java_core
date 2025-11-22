package ru.mentee.power.conditions;

public class TaxCalculator {
    public double calculateTax(int income) {
        if (income < 0)
            return -1;
        double taxPercent;
        if (income <= 10000)
            taxPercent = 0.10;
        else if (income <= 50000) {
            taxPercent = 0.15;
        } else taxPercent = 0.20;
        System.out.println("Доход: " + income);
        System.out.println("Налог в " + taxPercent*100+"%" + " равен: " + income*taxPercent);
        System.out.println("Чистая прибыль: " + (income - (income*taxPercent)));
        return (income - (income*taxPercent));
    }

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        taxCalculator.calculateTax(10000);
    }
}