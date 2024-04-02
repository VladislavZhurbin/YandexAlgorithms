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

@ExtendWith(C2CuttingTheRopeTest.TestResultLogger.class)
public class C2CuttingTheRopeTest {

    private List<Integer> failedTests;

    @BeforeEach
    public void setUp() {
        failedTests = new ArrayList<>();
    }

    @Test
    public void testFindingTheRopeTakenAway() {
        File folder = new File("C:\\Users\\vladv\\IdeaProjects\\YandexAlgorithms\\tests\\C2CuttingTheRope"); // Specify the folder containing your input files
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
                        int actualResult = C2CuttingTheRope.findingMinRopeTakenAway();

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
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(C2CuttingTheRopeTest.TestResultLogger.class)
//public class C2CuttingTheRopeTest {
//
//    private List<Integer> failedTests;
//
//    @BeforeEach
//    public void setUp() {
//        failedTests = new ArrayList<>();
//    }
//
//    @Test
//    public void testFindingTheRopeTakenAway() {
//        C2CuttingTheRopeTest minRopeTakenAway = new C2CuttingTheRopeTest();
//        // Input data for testing
//        String[] inputs = {
//                "4\n1 5 2 1\n",
//                "4\n5 12 4 3\n",
//                "2\n1 1\n",     //Test 5
//                "3\n3 4 5\n",   //Test 6
//                "3\n1 3 5\n",   //Test 7
//                                //Test 10:
//                "1000\n1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000\n"
//                // Add more input data here
//        };
//
//        int[] expectedResults = {
//                1,
//                24,
//                2,              //Test 5
//                12,             //Test 6
//                1,              //Test 7
//                1000000,        //Test 10
//                // Add expected results for other input data here
//        };
//
//        // Test each input
//        for (int i = 0; i < inputs.length; i++) {
//            String input = inputs[i];
//
//            // Create a virtual input stream from the input string
//            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//
//            // Redirect System.in to the virtual input stream
//            System.setIn(inputStream);
//
//            // Call the method to be tested
//            int actualResult = C2CuttingTheRope.findingMinRopeTakenAway();
//
//            // Restore System.in
//            System.setIn(System.in);
//
//            // Check if the actual result matches the expected result
//            if (actualResult != expectedResults[i]) {
//                failedTests.add(i + 1);
//            }
//
//            assertEquals(expectedResults[i], actualResult);
//        }
//    }
//
//    @AfterEach
//    public void tearDown() {
//        if (!failedTests.isEmpty()) {
//            System.out.println("Failed tests: " + failedTests);
//        }
//    }
//
//    static class TestResultLogger implements TestWatcher {
//        @Override
//        public void testFailed(ExtensionContext context, Throwable cause) {
//            // Additional handling for failed tests
//        }
//    }
//}