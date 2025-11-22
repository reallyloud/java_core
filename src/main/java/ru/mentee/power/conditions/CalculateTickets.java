package ru.mentee.power.conditions;

public class CalculateTickets {

    public double calculateTicketDiscount (int age, boolean isWeekend, boolean isStudent) {
        double ticketPrice = 3000;
        double finalPrice = ticketPrice;
        double kidDiscount = 0.20;
        double weekendDiscount = 0.25;
        double studentDiscount = 0.30;

        if ( age < 14 )
            finalPrice = finalPrice - (ticketPrice * kidDiscount);
        if ( isWeekend )
            finalPrice = finalPrice - (ticketPrice * weekendDiscount);
        if ( isStudent )
            finalPrice = finalPrice - (ticketPrice * studentDiscount);

        double discount = ticketPrice - finalPrice;
        System.out.println("Cтоимость ,билета = " + ticketPrice);
        System.out.println("Скидка = " + (ticketPrice-finalPrice));
        System.out.println("Финальная стоимость = " + finalPrice);


        return discount;
    }

    public static void main(String[] args) {
        CalculateTickets calculateTickets = new CalculateTickets();
        calculateTickets.calculateTicketDiscount(13,true,true);
    }
}
