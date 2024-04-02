import java.util.Scanner;

public class B2FishTrader {
    public static void main(String[] args) {
        B2FishTrader newTask = new B2FishTrader();
        newTask.findProfit();
    }
    public static int findProfit() {
        Scanner input = new Scanner(System.in);
        int tradingDaysQuantity = input.nextInt();
        int shelfLifeOfFish = input.nextInt();
        int[] fishPriceByDays = new int[tradingDaysQuantity];
        for (int i = 0; i < tradingDaysQuantity; i++) {
            fishPriceByDays[i] = input.nextInt();
        }
        input.close();
        int maxProfit = 0;
        for (int i = 0; i < tradingDaysQuantity; i++) {
            for (int j = 1; j <= Math.min(shelfLifeOfFish, tradingDaysQuantity - i - 1); j++) {
                if ((fishPriceByDays[i + j] - fishPriceByDays[i]) > maxProfit) {
                    maxProfit = fishPriceByDays[i + j] - fishPriceByDays[i];
                }
            }
        }

        System.out.println(maxProfit);
        return(maxProfit);
    }
}
