package ru.mentee.power.conditions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeekdayDeterminerTest {
        WeekdayDeterminer weekdayDeterminer = new WeekdayDeterminer();
        @Test
        public void testDayOfWeek () {
            assertEquals("Понедельник",weekdayDeterminer.getDayOfWeek(1),"День неверный");
            assertEquals("Вторник",weekdayDeterminer.getDayOfWeek(2),"День неверный");
            assertEquals("Среда",weekdayDeterminer.getDayOfWeek(3),"День неверный");
            assertEquals("Четверг",weekdayDeterminer.getDayOfWeek(4),"День неверный");
            assertEquals("Пятница",weekdayDeterminer.getDayOfWeek(5),"День неверный");
            assertEquals("Суббота",weekdayDeterminer.getDayOfWeek(6),"День неверный");
            assertEquals("Воскресенье",weekdayDeterminer.getDayOfWeek(7),"День неверный");
        }

        @Test
    public void testIsWeekend() {
                assertEquals(false, weekdayDeterminer.isWeekend(1), "Должен быть рабочий день");
                assertEquals(false, weekdayDeterminer.isWeekend(2), "Должен быть рабочий день");
                assertEquals(false, weekdayDeterminer.isWeekend(3), "Должен быть рабочий день");
                assertEquals(false, weekdayDeterminer.isWeekend(4), "Должен быть рабочий день");
                assertEquals(false, weekdayDeterminer.isWeekend(5), "Должен быть рабочий день");
                assertEquals(true, weekdayDeterminer.isWeekend(6), "Должен быть выходной");
                assertEquals(true, weekdayDeterminer.isWeekend(7), "Должен быть выходной");
                assertEquals(false, weekdayDeterminer.isWeekend(10), "Должен быть false");

            }
}