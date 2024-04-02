import java.util.Scanner;

public class FMishaAndMath {
    public static void main(String[] args) {
        FMishaAndMath newTask = new FMishaAndMath();
        System.out.println(newTask.operatorsSigns());
    }
    public static String operatorsSigns() {
        Scanner input = new Scanner(System.in);
        int numberOfOperands = input.nextInt();
        int[] operands = new int[numberOfOperands];
        for (int i = 0; i < numberOfOperands; i++) {
            operands[i] = input.nextInt();
        }
        StringBuilder result = new StringBuilder();
        boolean odd = true; // нечетное
        if (operands[0] % 2 == 0) {
            odd = false;
        }
        for (int i = 0; i < numberOfOperands - 1; i++) {
            if (!odd && operands[i + 1] % 2 == 0) {
                result.append("x");
                odd = false;
            } else if (odd && operands[i + 1] % 2 != 0) {
                result.append("x");
                odd = true;
            } else {
                result.append("+");
                odd = true;
            }
        }

        return result.toString();
    }
}