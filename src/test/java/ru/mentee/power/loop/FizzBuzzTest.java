package ru.mentee.power.loop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @Test
    public void testFizzBuzzForFirst15Numbers() {
        // Подготовка
        FizzBuzz fizzBuzz = new FizzBuzz();

        // Действие
        String[] result = fizzBuzz.generateFizzBuzz(15);

        // Проверка
        assertThat(result).isNotNull();
        assertThat(result).hasSize(15);

        // Проверяем конкретные значения
        assertThat(result[0]).isEqualTo("1");    // 1
        assertThat(result[1]).isEqualTo("2");    // 2
        assertThat(result[2]).isEqualTo("Fizz"); // 3
        assertThat(result[4]).isEqualTo("Buzz"); // 5
        assertThat(result[14]).isEqualTo("FizzBuzz"); // 15
    }

    @Test
    public void testFizzBuzzWithZeroInput() {
        // Подготовка
        FizzBuzz fizzBuzz = new FizzBuzz();

        // Действие
        String[] result = fizzBuzz.generateFizzBuzz(0);

        // Проверка
        assertThat(result).isNotNull();
        assertThat(result).isEmpty();
    }

    @Test
    public void testAllFizzValuesAreDivisibleBy3() {

        FizzBuzz fizzBuzz = new FizzBuzz();

        String[] result = fizzBuzz.generateFizzBuzz(15);

        for (int i = 1; i < result.length; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                assertThat(result[i - 1]).isEqualTo("Fizz");
            }
            // TODO: Дополнить тест, проверяющий, что все значения "Fizz"
            // соответствуют числам, делящимся на 3 (и не делящимся на 5)
        }
    }

    @Test
    public void testAllBuzzValuesAreDivisibleBy5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] result = fizzBuzz.generateFizzBuzz(15);

        for (int i = 1; i < result.length; i++) {
            if (i % 5 == 0 && i % 3 != 0) {
                assertThat(result[i - 1]).isEqualTo("Buzz");
            }
            // TODO: Дополнить тест, проверяющий, что все значения "Buzz"
            // соответствуют числам, делящимся на 5 (и не делящимся на 3)
        }
    }

    @Test
    public void testAllFizzBuzzValuesAreDivisibleBy3And5() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String[] result = fizzBuzz.generateFizzBuzz(15);

        for (int i = 1; i < result.length; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                assertThat(result[i - 1]).isEqualTo("FizzBuzz");
            }
        }
        // TODO: Дополнить тест, проверяющий, что все значения "FizzBuzz"
        // соответствуют числам, делящимся и на 3, и на 5
    }
}
