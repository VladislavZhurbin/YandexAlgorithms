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


@ExtendWith(bSoccerCommentatorTest.TestResultLogger.class)
public class bSoccerCommentatorTest {

    private List<Integer> failedTests;

    @BeforeEach
    public void setUp() {
        failedTests = new ArrayList<>();
    }

    @Test
    public void testGoalsNeededToWin() {
        // Наборы входных данных для тестирования
        String[][] inputMatches = {
                {"0:0", "0:0", "1"},
                {"0:2", "0:3", "1"},
                {"0:2", "0:3", "2"},
                {"2:2", "1:1", "1"},
                {"2:1", "3:3", "1"},
                {"0:0", "1:2", "2"},
                {"4:2", "0:3", "2"},
                {"3:2", "0:4", "2"},
                {"3:2", "0:3", "2"},
                {"5:2", "0:5", "1"},
                {"5:2", "0:5", "2"},
                // Добавьте остальные наборы данных здесь
        };

        int[] expectedResults = {
                1,
                5,
                6,
                1,
                0,
                2,
                1,
                4,
                3,
                3,
                3,
                // Добавьте ожидаемые результаты для остальных наборов данных здесь
        };

        // Проверка для каждого набора данных
        for (int i = 0; i < inputMatches.length; i++) {
            String[] inputMatch = inputMatches[i];
            int expectedResult = expectedResults[i];

            // Создаем виртуальный поток ввода из строки
            String input = String.join("\n", inputMatch) + "\n";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());

            // Перенаправляем стандартный поток ввода на созданный поток
            System.setIn(inputStream);

            // Вызываем метод, который мы хотим протестировать
            int actualResult = bSoccerCommentator.calculateGoalsNeededToWin();

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
