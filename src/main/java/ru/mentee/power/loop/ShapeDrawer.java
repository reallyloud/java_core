package ru.mentee.power.loop;

public class ShapeDrawer {
    public final String ERROR = "ERROR";

    /**
     * Метод рисует заполненный квадрат заданного размера
     *
     * @param size размер стороны квадрата
     * @return строка с изображением квадрата
     */
    public String drawSquare(int size) {
        if (!isValidSize(size))
            return ERROR;

        String square = "";
        for (int i = 0; i < size; i++) {
            if (i != 0)
                square = square + "\n";
            for (int n = 0; n < size; n++) {
                square = square + "*";
            }

        }
        // TODO: Реализовать метод
        return square;
    }

    /**
     * Метод рисует пустой квадрат (только границы) заданного размера
     *
     * @param size размер стороны квадрата
     * @return строка с изображением пустого квадрата
     */
    public String drawEmptySquare(int size) {
        if (!isValidSize(size))
            return ERROR;

        String square = "";
        for (int line = 0; line < size; line++) {
            if (line != 0)
                square = square + "\n";
            for (int column = 0; column < size; column++) {
                if (line == 0 || line == size - 1 || column == 0 || column == size - 1)
                    square = square + "*";
                else {
                    square = square + " ";
                }
            }

        }
        // TODO: Реализовать метод
        return square;
    }

    /**
     * Метод рисует прямоугольный треугольник заданной высоты
     *
     * @param height высота треугольника
     * @return строка с изображением треугольника
     */
    public String drawTriangle(int height) {
        if (!isValidSize(height))
            return ERROR;

        String triangle = "";
        for (int line = 0; line < height; line++) {
            if (line != 0) {
                triangle = triangle + "\n";
            }
            for (int column = 0; column <= line; column++) {
                triangle = triangle + "*";
            }
        }


        // TODO: Реализовать метод
        return triangle;
    }

    /**
     * Метод рисует ромб заданного размера
     *
     * @param size размер ромба (должен быть нечетным числом)
     * @return строка с изображением ромба
     */
    public String drawRhombus(int size) {
        if (!isValidSize(size))
            return ERROR;

        if (size % 2 == 0)
            size++;
        String rhombus = "";

        for (int line = 1; line <= size; line++) {
            if (line != 1) {
                rhombus = rhombus + "\n";
            }
            int spaces = Math.abs(size / 2 + 1 - line);
            for (int column = 0; column < spaces; column++) {
                rhombus = rhombus + " ";
            }
            for (int column = 0; column < size - (spaces * 2); column++) {
                rhombus = rhombus + "*";
            }
            for (int column = 0; column < spaces; column++) {
                rhombus = rhombus + " ";
            }
        }
        // TODO: Реализовать метод
        return rhombus;
    }

    public boolean isValidSize(int size) {
        if (size <= 0)
            return false;
        else
            return true;
    }

    /**
     * Метод выводит фигуру в консоль
     *
     * @param shape строка с изображением фигуры
     */
    public void printShape(String shape) {
        System.out.println(shape);
    }

    /**
     * Главный метод для демонстрации работы программы
     */
    public static void main(String[] args) {
        ShapeDrawer drawer = new ShapeDrawer();

        System.out.println("Квадрат 5x5:");
        drawer.printShape(drawer.drawSquare(5));

        System.out.println("\nПустой квадрат 5x5:");
        drawer.printShape(drawer.drawEmptySquare(5));

        System.out.println("\nТреугольник высотой 5:");
        drawer.printShape(drawer.drawTriangle(5));

        System.out.println("\nРомб размером 5:");
        drawer.printShape(drawer.drawRhombus(10));
    }
}