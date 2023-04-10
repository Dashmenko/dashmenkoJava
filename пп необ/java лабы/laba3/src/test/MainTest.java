//import org.junit.jupiter.api.Test;
//import task1.FirstComparator;
//import task1.SecondComparator;
//import task4.sorts.BubbleSort;
//import task4.sorts.GnomeSort;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class MainTest {
//
//    @Test
//    void firstComparatorTest() {
//        String[] actual = {"string", "test", "first", "кто тут?"};
//        String[] expected = {"string", "test", "first", "кто тут?"};
//        Arrays.sort(actual, new FirstComparator("t"));
//        assertArrayEquals(
//                expected,
//                actual
//        );
//    }
//
//    @Test
//    void secondCompareTest() {
//        String[] actual = {"favail", "sssss", "agufadodolas", "lasfa"};
//        String[] expected = {"agufadodolas", "favail", "sssss", "lasfa"};
//        Arrays.sort(actual, new SecondComparator("fa", "l"));
//        assertArrayEquals(
//                expected,
//                actual
//        );
//    }
//
//    @Test
//    void parseStringTest() {
//        String string = "1 2 3, 4 a5a 6 789 0";
//        assertEquals(
//                "one two three, four a5a six 789 zero",
//                task2.Main.parseString(string)
//        );
//    }
//
//    @Test
//    void bubbleSortTest() {
//        String[] actual = {"string", "test", "first", "кто тут?"};
//        String[] expected = {"string", "test", "first", "кто тут?"};
//        new BubbleSort<String>(actual).sort(new FirstComparator("t"));
//        assertArrayEquals(
//                expected,
//                actual
//        );
//    }
//
//    @Test
//    void gnomeSortTest() {
//        String[] actual = {"favail", "sssss", "agufadodolas", "lasfa"};
//        String[] expected = {"agufadodolas", "favail", "lasfa", "sssss"};
//        new GnomeSort<String>(actual).sort(new SecondComparator("fa", "l"));
//        assertArrayEquals(
//                expected,
//                actual
//        );
//    }
//}