import java.math.BigInteger;
import java.util.Scanner;

public class EProfitableStartup {
    public static void main(String[] args) {
        EProfitableStartup newTask = new EProfitableStartup();
        newTask.selectionOfMultiples();
    }
    public static BigInteger selectionOfMultiples() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int d = input.nextInt();
        input.close();
        BigInteger result = BigInteger.valueOf(-1);
        if (d != 0) {
            for (int i = 0; i <= 9; i++) {
                int temp = n * 10 + i;
                if (temp % k == 0) {
                    result = BigInteger.valueOf(temp).multiply(BigInteger.TEN.pow(d - 1));
                }
            }
        }
        System.out.println(result);
        return (result);
    }
}
