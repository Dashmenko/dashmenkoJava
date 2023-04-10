package by.vsu;

import org.junit.Assert;
import org.junit.Test;


public class ExpressionTest {
    /*
     * каждый метод, начинающийся с аннотации @Test
     * представляет собой один тест, в котором, как
     * правило, представлен один набор тестовых данных
     */
    @Test
    public void testDividingBiggerNumberBySmaller() {
        Assert.assertEquals(
            -1.5, // ожидаемый результат
            Main.expression(1, 2, 3), // вызов тестируемого методы
            0.0000000001 // для вещественных чисел погрешность сравнения
        );
    }

    @Test
    public void testDividingSmallerNumberByBigger() {
        Assert.assertEquals(
            62.64,
            Main.expression(50.88, 30, 0),
            0.0000000001
        );
    }

    @Test
    public void testDividingPositiveNumberByZero() {
        Assert.assertEquals(
            Double.POSITIVE_INFINITY,
            Main.expression(10, 0, 2),
            0.0000000001
        );
    }

    @Test
    public void testDividingNegativeNumberByZero() {
        Assert.assertEquals(
            Double.NEGATIVE_INFINITY,
            Main.expression(10, 0, -2),
            0.0000000001
        );
    }
}