import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(D2ChessBoardTest.TestResultLogger.class)
public class D2ChessBoardTest {

    private List<Integer> failedTests;

    @BeforeEach
    public void setUp() {
        failedTests = new ArrayList<>();
    }

    @Test
    public void testCountPerimeter() {
        File folder = new File("C:\\Users\\vladv\\IdeaProjects\\YandexAlgorithms\\tests\\D2ChessBoard"); // Specify the folder containing your input files
        File[] inputFiles = folder.listFiles((dir, name) -> name.matches("\\d+")); // Filter for files matching pattern "001", "002", etc.

        if (inputFiles != null) {
            for (File inputFile : inputFiles) {
                String inputFileName = inputFile.getName();
                String expectedFileName = inputFileName + ".a";
                File expectedFile = new File(folder, expectedFileName);

                if (expectedFile.exists()) {
                    try {
                        // Read input from file
                        String input = Files.readString(inputFile.toPath());
                        // Read expected result from file
                        String expectedResultString = Files.readString(expectedFile.toPath());
                        int expectedResult = Integer.parseInt(expectedResultString.trim());

                        // Create a virtual input stream from the input string
                        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
                        // Redirect System.in to the virtual input stream
                        System.setIn(inputStream);

                        // Call the method to be tested
                        int actualResult = D2ChessBoard.countPerimeter();

                        // Restore System.in
                        System.setIn(System.in);

                        // Check if the actual result matches the expected result
                        assertEquals(expectedResult, actualResult);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Expected result file not found for input file: " + inputFileName);
                }
            }
        } else {
            System.out.println("No input files found in the specified folder.");
        }
    }

    @AfterEach
    public void tearDown() {
        if (!failedTests.isEmpty()) {
            System.out.println("Failed tests: " + failedTests);
        }
    }

    static class TestResultLogger implements TestWatcher {
        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            // Additional handling for failed tests
        }
    }
}
