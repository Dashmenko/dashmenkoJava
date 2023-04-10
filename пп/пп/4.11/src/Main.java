import java.util.Date;
import java.util.Random;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        //создаем новый генератор псевдослучайных чисел, и задаем
        //начальное значение для алгоритма генерации чисел
        //выводим десять случайных чисел

        public static void reshuffle{
            int[] pack;
            if (pack != null) {
                int length = pack.length;
                //создаем генератор случайных чисел, в качестве начального
                //значения передаем системное время
                Random generator = new Random(new Date().getTime());
                //тосуем колоду карт
                //перебираем все карты колоды
                for (int i = 0; i < length; i++) {
                    //генерируем случайное число, в диапазоне от нуля до
                    //конца колоды
                    int newPos = generator.nextInt(length);
                    //меняем местами текущую карту с картой, которая находится
                    //в pack[newPos]
                    int curCard = pack[i];
                    pack[i] = pack[newPos];
                    pack[newPos] = curCard;
                    //для увеличения эффекта "случайности" возникновения чисел,
                    //в течении перетасовки колоды, четыре раза устанавливаем
                    //новое начальное значение генератора случайных чисел
                    if (i % (length / 4) == 0) {
                        //генерируем случайный интервал времени (мс)
                        int pause = generator.nextInt(20);
                        try {
                            //останавливаем работу программы на полученный
                            //интервал времени (максимально возможная задержка
                            //восемдесят миллисекунд)
                            Thread.currentThread().sleep(pause);
                        } catch (InterruptedException ex) {
                        }
                        //уставливаем новое начальное значение генератора
                        generator.setSeed(new Date().getTime());
                    }
                }
            }
        }}}