import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(CTaskFileFormattingTest.TestResultLogger.class)
public class CTaskFileFormattingTest {

    private List<Integer> failedTests;

    @BeforeEach
    public void setUp() {
        failedTests = new ArrayList<>();
    }

    @Test
    public void testNumberOfClicks() {
        CTaskFileFormatting clicksCounter = new CTaskFileFormatting();
        // Наборы входных данных для тестирования
        String[][] inputMatches = {
                {"5", "1", "4", "12", "9", "0"},
                {"1", "1"},
                {"1", "2"},
                {"1", "3"},
                {"1", "4"},
                {"1", "5"},
                {"1", "6"},
                {"1", "7"},
                {"1", "8"},
                {"1", "9"},
                {"1", "10"},
                {"1", "11"},
                {"1", "12"},
                {"1", "13"},
                {"1", "14"},
                {"1", "15"},
                {"1", "16"},
                {"1", "17"},
                {"1", "18"},
                {"1", "19"},
                {"1", "20"},
                {"1", "21"},
                {"21", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15","16", "17", "18", "19", "20", "21"},

                // Добавьте остальные наборы данных здесь
        };

        long[] expectedResults = {
                8,
                1,
                2,
                2,
                1,
                2,
                3,
                3,
                2,
                3,
                4,
                4,
                3,
                4,
                5,
                5,
                4,
                5,
                6,
                6,
                5,
                6,
                76,

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
            long actualResult = clicksCounter.fileFormatting();

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
