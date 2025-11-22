package ru.mentee.power.conditions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {
    TaxCalculator taxCalculator = new TaxCalculator();
    double delta = 0.001;

        @Test
        public void testNegativeNumber () {
            assertThat(taxCalculator.calculateTax(-50)).isEqualTo(-1);
            assertThat(taxCalculator.calculateTax(-30)).isEqualTo(-1);
        }

        @Test
    public void testCalculateTaxMinimal () {
            assertThat(taxCalculator.calculateTax(10000)).isCloseTo(9000, offset(delta));
            assertThat(taxCalculator.calculateTax(8000)).isCloseTo(7200, offset(delta));
        }

        @Test
        public void testCalculateTaxMedium () {
            assertThat(taxCalculator.calculateTax(15000)).isCloseTo(12750, offset(delta));
            assertThat(taxCalculator.calculateTax(30000)).isCloseTo(25500,offset(delta));
        }

        @Test
        public void testCalculateTaxMax () {
            assertThat(taxCalculator.calculateTax(100000)).isCloseTo(80000,offset(delta));
            assertThat(taxCalculator.calculateTax(150000)).isCloseTo(120000,offset(delta));
        }



}