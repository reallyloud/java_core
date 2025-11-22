package ru.mentee.power.conditions;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;

class CalculateTicketsTest {
        CalculateTickets calculateTickets = new CalculateTickets();
        final Offset DELTA = offset(0.01);

        @Test
    public void testTicketsStudent () {
            assertThat(calculateTickets.calculateTicketDiscount(19,false,true)).isCloseTo(900,DELTA);
        }

    public void testTicketsWeekend () {
            assertThat(calculateTickets.calculateTicketDiscount(20,true,false)).isCloseTo(750,DELTA);
    }

    public void testMaxDiscount () {
            assertThat(calculateTickets.calculateTicketDiscount(13,true,true)).isCloseTo(2250,DELTA);
    }

    public void testWithoutDiscount () {
            assertThat(calculateTickets.calculateTicketDiscount(25,false,false)).isCloseTo(0,DELTA);
    }
}