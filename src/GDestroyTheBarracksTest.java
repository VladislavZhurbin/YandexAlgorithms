import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(GDestroyTheBarracksTest.TestResultLogger.class)
public class GDestroyTheBarracksTest {

    private List<Integer> failedTests;

    @BeforeEach
    public void setUp() {
        failedTests = new ArrayList<>();
    }

    @Test
    public void testNumberOfRounds() {
        GDestroyTheBarracks roundsCounter = new GDestroyTheBarracks();
        // Наборы входных данных для тестирования
        String[][] inputMatches = {
                {"10", "11", "15"},
                {"1", "2", "1"},
                {"1", "1", "1"},
                {"25", "200", "10"},
                {"250", "500", "187"},
                {"250", "500", "230"},
                {"250", "500", "249"},
                {"30", "496", "15"},
                {"499", "500", "499"},
                {"13", "81", "10"},
                {"300", "301", "484"},    //142
                {"1956", "4418", "1955"}, //160
                {"2500", "5000", "2334"}, //200

                // Добавьте остальные наборы данных здесь
        };

        long[] expectedResults = {
                4,
                -1,
                1,
                13,
                4,
                8,
                101,
                33,
                3,
                23,
                6,
                1259,
                10,



                // Добавьте ожидаемые результаты для остальных наборов данных здесь
        };

        // Проверка для каждого набора данных
        for (int i = 0; i < inputMatches.length; i++) {
            String[] inputMatch = inputMatches[i];
            long expectedResult = expectedResults[i];

            // Создаем виртуальный поток ввода из строки
            String input = String.join("\n", inputMatch) + "\n";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());

            // Перенаправляем стандартный поток ввода на созданный поток
            System.setIn(inputStream);

            // Вызываем метод, который мы хотим протестировать
            long actualResult = roundsCounter.countRounds();

            // Возвращаем стандартный поток ввода обратно на System.in
            System.setIn(System.in);

            if (actualResult != expectedResult) {
                failedTests.add(i + 1);
            }

            assertEquals(expectedResult, actualResult);
        }
    }

    @AfterEach
    public void tearDown() {
        if (!failedTests.isEmpty()) {
            System.out.println("Не пройденные тесты: " + failedTests);
        }
    }

    static class TestResultLogger implements TestWatcher {
        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            // Дополнительная обработка при неудачном тесте
        }
    }
}
