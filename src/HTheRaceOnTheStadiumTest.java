//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.TestWatcher;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;
//
//
//@ExtendWith(GDestroyTheBarracksTest.TestResultLogger.class)
//public class HTheRaceOnTheStadiumTest {
//
//    private List<Integer> failedTests;
//
//    @BeforeEach
//    public void setUp() {
//        failedTests = new ArrayList<>();
//    }
//
//    @Test
//    public void testTimeAtEqualRange() {
//        HTheRaceOnTheStadium whenRunnersMeet = new HTheRaceOnTheStadium();
//        // Наборы входных данных для тестирования
//        String[][] inputMatches = {
//                {"6", "3", "1", "1", "1"},
//                {"12", "8", "10", "5", "20"},
//                {"5", "0", "0", "1", "2"},
//                {"10", "7", "-3", "1", "4"},
//
//
//                // Добавьте остальные наборы данных здесь
//        };
//
//        String[][] expectedResults = {
//                {"YES", "1.0000000000"},
//                {"YES", "0.3000000000"},
//                {"YES", "2.0000000000"},
//                {"YES", "0.8571428571"},
//
//
//
//                // Добавьте ожидаемые результаты для остальных наборов данных здесь
//        };
//
//        // Проверка для каждого набора данных
//        for (int i = 0; i < inputMatches.length; i++) {
//            String[] inputMatch = inputMatches[i];
//            String[] expectedResult = expectedResults[i];
//
//            // Создаем виртуальный поток ввода из строки
//            String input = String.join("\n", inputMatch) + "\n";
//            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//
//            // Перенаправляем стандартный поток ввода на созданный поток
//            System.setIn(inputStream);
//
//            // Вызываем метод, который мы хотим протестировать
//            String[] actualResult = whenRunnersMeet.whenRunnersMeet();
//
//            // Возвращаем стандартный поток ввода обратно на System.in
//            System.setIn(System.in);
//
//            if (!Arrays.equals(actualResult != expectedResult)) {
//                failedTests.add(i + 1);
//            }
//
//            assertArrayEquals(expectedResult, actualResult);
//        }
//    }
//
//    @AfterEach
//    public void tearDown() {
//        if (!failedTests.isEmpty()) {
//            System.out.println("Не пройденные тесты: " + failedTests);
//        }
//    }
//
//    static class TestResultLogger implements TestWatcher {
//        @Override
//        public void testFailed(ExtensionContext context, Throwable cause) {
//            // Дополнительная обработка при неудачном тесте
//        }
//    }
//}


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(HTheRaceOnTheStadiumTest.TestResultLogger.class)
public class HTheRaceOnTheStadiumTest {

    private List<Integer> failedTests;

    @BeforeEach
    public void setUp() {
        failedTests = new ArrayList<>();
    }

    @Test
    public void testTimeAtEqualRange() {
        HTheRaceOnTheStadium whenRunnersMeet = new HTheRaceOnTheStadium();
        // Наборы входных данных для тестирования
        String[][] inputMatches = {
                {"6", "3", "1", "1", "1"},
                {"12", "8", "10", "5", "20"},
                {"5", "0", "0", "1", "2"},
                {"10", "7", "-3", "1", "4"},
                {"762899414", "556082848", "-539099316", "556082848", "-582799403"},
                {"938712409", "11003268", "0", "278188417", "0"},
                {"72", "20", "-38121735", "66", "288888467"},
                {"94", "76", "0", "76", "0"},
                {"82", "42", "-354891707", "42", "-354891707"},
//                {"956390104", "549514100", "7", "315097830", "-7"},

                // Добавьте остальные наборы данных здесь
        };

        String[][] expectedResults = {
                {"YES", "1.0000000000"},
                {"YES", "0.3000000000"},
                {"YES", "2.0000000000"},
                {"YES", "0.8571428571"},
                {"YES", "0.0000000000"},
                {"NO"},
                {"YES", "0.0000000795"},
                {"YES", "0.0000000000"},
                {"YES", "0.0000000000"},
//                {"YES", "51569559.5714285714"},

                // Добавьте ожидаемые результаты для остальных наборов данных здесь
        };

        // Проверка для каждого набора данных
        for (int i = 0; i < inputMatches.length; i++) {
            String[] inputMatch = inputMatches[i];
            String[] expectedResult = expectedResults[i];

            // Создаем виртуальный поток ввода из строки
            String input = String.join("\n", inputMatch) + "\n";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());

            // Перенаправляем стандартный поток ввода на созданный поток
            System.setIn(inputStream);

            // Вызываем метод, который мы хотим протестировать
            String[] actualResult = whenRunnersMeet.whenRunnersMeet();

            // Возвращаем стандартный поток ввода обратно на System.in
            System.setIn(System.in);

            if (!Arrays.equals(actualResult, expectedResult)) {
                failedTests.add(i + 1);
            }

            assertArrayEquals(expectedResult, actualResult);
        }
    }

    @AfterEach
    public void tearDown() {
        if (!failedTests.isEmpty()) {
            Logger.getLogger(getClass().getName()).warning("Не пройденные тесты: " + failedTests);
        }
    }

    static class TestResultLogger implements TestWatcher {
        // Можете удалить метод testFailed
    }
}
