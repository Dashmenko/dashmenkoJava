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
    public void testFactorialSmallNumber() {
        Assert.assertEquals(
            2, // ожидаемый результат
            Main.factorial(2), // вызов тестируемого методы
            0.0000000001 // для вещественных чисел погрешность сравнения
        );
    }

    @Test
    public void testFactorialBigNumber() {
        Assert.assertEquals(
            720,
            Main.factorial(6),
            0.0000000001
        );
    }

    @Test
    public void testSeries() {
        Assert.assertEquals(
            Math.cos(0.75),
            Main.expression(0.75, 0.0001),
            0.0001
        );
    }

    @Test
    public void testWithHighEpsilon() {
        Assert.assertEquals(
            Math.cos(2),
            Main.expression(2, 0.0001),
            0.0001
        );
    }

    @Test
    public void testWithLowEpsilon() {
        Assert.assertEquals(
            Math.cos(-2),
            Main.expression(-2, 0.1),
            0.1
        );
    }
}