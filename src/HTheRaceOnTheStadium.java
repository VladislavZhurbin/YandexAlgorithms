import java.util.Scanner;

public class HTheRaceOnTheStadium {
    public static void main(String[] args) {
        HTheRaceOnTheStadium newTask = new HTheRaceOnTheStadium();

        String[] result = newTask.whenRunnersMeet();
        if (result.length == 1) {
            System.out.println(result[0]);
        } else {
            System.out.println(result[0]);
            System.out.println(result[1]);
        }
    }
    public static String[] whenRunnersMeet() {
        Scanner input = new Scanner (System.in);
        int stadiumLength = input.nextInt();
        int firstRunnerStartPoint = input.nextInt();
        int firstRunnerVelocity = input.nextInt();
        int secondRunnerStartPoint = input.nextInt();
        int secondRunnerVelocity = input.nextInt();
        input.close();

        String[] result = new String[2];

        if (firstRunnerStartPoint == secondRunnerStartPoint) {
            result[0] = "YES";
            result[1] = "0.000000000";
            return (result);
        } else if (firstRunnerVelocity == 0 && secondRunnerVelocity == 0 && firstRunnerStartPoint != secondRunnerStartPoint) {
            result = null;
            result = new String[1];
            result[0] = "NO";
            return (result);
        }
        double a = (double) (stadiumLength - firstRunnerStartPoint - secondRunnerStartPoint) / (secondRunnerVelocity + firstRunnerVelocity);
        double b = (double) (-1 * stadiumLength + firstRunnerStartPoint - secondRunnerStartPoint) / (secondRunnerVelocity - firstRunnerVelocity);
        double c = (double) (firstRunnerStartPoint - secondRunnerStartPoint) / (secondRunnerVelocity - firstRunnerVelocity);
        double d = (double) (-1 * firstRunnerStartPoint - secondRunnerStartPoint) / (secondRunnerVelocity + firstRunnerVelocity);
        double e = (double) (2 * stadiumLength - firstRunnerStartPoint - secondRunnerStartPoint) / (secondRunnerVelocity + firstRunnerVelocity);
        double f = (double) (stadiumLength + firstRunnerStartPoint - secondRunnerStartPoint) / (secondRunnerVelocity - firstRunnerVelocity);


        double minPositiveTime = Double.MAX_VALUE;

        if (a > 0) minPositiveTime = Math.min(minPositiveTime, a);
        if (b > 0) minPositiveTime = Math.min(minPositiveTime, b);
        if (c > 0) minPositiveTime = Math.min(minPositiveTime, c);
        if (d > 0) minPositiveTime = Math.min(minPositiveTime, d);
        if (e > 0) minPositiveTime = Math.min(minPositiveTime, e);
        if (f > 0) minPositiveTime = Math.min(minPositiveTime, f);

        result[0] = "YES";
        result[1] = String.valueOf(minPositiveTime);
        return result;
    }
}