import java.util.Scanner;

public class A2RectangleCover {
    public static void main(String[] args) {
        A2RectangleCover newTask = new A2RectangleCover();
        newTask.findingXY();
    }
    public static String findingXY() {
        Scanner input = new Scanner(System.in);
        int coloredPointsQuantity = input.nextInt();
        int[] xCoordinates = new int[coloredPointsQuantity];
        int[] yCoordinates = new int[coloredPointsQuantity];
        for (int i = 0; i < coloredPointsQuantity; i++) {
            xCoordinates[i] = input.nextInt();
            yCoordinates[i] = input.nextInt();
        }
        input.close();

        int[] xXCoordinates = minMaxPoint(xCoordinates);
        int[] yYCoordinates = minMaxPoint(yCoordinates);
        String result = xXCoordinates[0] + " " + yYCoordinates[0] + " " + xXCoordinates[1] + " " + yYCoordinates[1];

        System.out.println(result);
        return(result);
    }
    public static int[] minMaxPoint(int[] coordinates) {
        int min = coordinates[0];
        int max = coordinates[0];
        for (int i = 0; i < coordinates.length - 1; i++) {
            if (coordinates[i + 1] > max) {
                max = coordinates[i + 1];
            }
            if (coordinates[i + 1] < min) {
                min = coordinates[i + 1];
            }
        }
        int[] result = {min, max};
        return(result);
    }
}
