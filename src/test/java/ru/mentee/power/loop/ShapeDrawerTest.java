package ru.mentee.power.loop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShapeDrawerTest {

    private final ShapeDrawer drawer = new ShapeDrawer();
    private final String ERROR = "ERROR";

    @Test
    void testDrawSquare() {
        // Подготовка ожидаемого результата для квадрата 3x3
        String expected = "***\n***\n***";

        // Вызов тестируемого метода
        String result = drawer.drawSquare(3);

        // Проверка результата
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testDrawEmptySquare() {
        // Подготовка ожидаемого результата для пустого квадрата 3x3
        String expected = "***\n* *\n***";

        // Вызов тестируемого метода
        String result = drawer.drawEmptySquare(3);

        // Проверка результата
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testDrawTriangle() {
        // Подготовка ожидаемого результата для треугольника высотой 3
        String expected = "*\n**\n***";

        // Вызов тестируемого метода
        String result = drawer.drawTriangle(3);

        // Проверка результата
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testDrawRhombus() {
        // Подготовка ожидаемого результата для ромба размером 3
        String expected = " * \n***\n * ";

        // Вызов тестируемого метода
        String result = drawer.drawRhombus(3);

        // Проверка результата
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testWithZeroOrNegativeSize() {
        assertThat(drawer.drawSquare(0)).isEqualTo(ERROR);
        assertThat(drawer.drawSquare(-4)).isEqualTo(ERROR);

        assertThat(drawer.drawTriangle(0)).isEqualTo(ERROR);
        assertThat(drawer.drawTriangle(-1)).isEqualTo(ERROR);

        assertThat(drawer.drawRhombus(0)).isEqualTo(ERROR);
        assertThat(drawer.drawRhombus(-1)).isEqualTo(ERROR);

        assertThat(drawer.drawEmptySquare(0)).isEqualTo(ERROR);
        assertThat(drawer.drawEmptySquare(-1)).isEqualTo(ERROR);

        // TODO: Дополнить тест для проверки поведения методов при передаче нулевого или отрицательного размера
    }

    @Test
    void testWithLargeSize() {
        assertThat(drawer.drawSquare(10)).isEqualTo(
                "**********\n" +
                        "**********\n" +
                        "**********\n" +
                        "**********\n" +
                        "**********\n" +
                        "**********\n" +
                        "**********\n" +
                        "**********\n" +
                        "**********\n" +
                        "**********"
        );

        assertThat(drawer.drawEmptySquare(10)).isEqualTo(
                "**********\n" +
                        "*        *\n" +
                        "*        *\n" +
                        "*        *\n" +
                        "*        *\n" +
                        "*        *\n" +
                        "*        *\n" +
                        "*        *\n" +
                        "*        *\n" +
                        "**********"
        );

        assertThat(drawer.drawTriangle(10)).isEqualTo(
                "*\n" +
                        "**\n" +
                        "***\n" +
                        "****\n" +
                        "*****\n" +
                        "******\n" +
                        "*******\n" +
                        "********\n" +
                        "*********\n" +
                        "**********"
        );
        assertThat(drawer.drawRhombus(10)).isEqualTo(
                "     *     \n" +
                        "    ***    \n" +
                        "   *****   \n" +
                        "  *******  \n" +
                        " ********* \n" +
                        "***********\n" +
                        " ********* \n" +
                        "  *******  \n" +
                        "   *****   \n" +
                        "    ***    \n" +
                        "     *     "
        );
        // TODO: Дополнить тест для проверки работы методов с большим размером фигур (например, 10)
    }

    @Test
    void testRhombusWithEvenSize() {
        // TODO: Дополнить тест для проверки поведения метода drawRhombus при передаче четного размера
    }
}