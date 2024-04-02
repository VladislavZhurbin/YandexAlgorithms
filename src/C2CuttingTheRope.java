import java.util.Scanner;

public class C2CuttingTheRope {
    public static void main(String[] args) {
        C2CuttingTheRope newTest = new C2CuttingTheRope();
        System.out.println(newTest.findingMinRopeTakenAway());
    }
    public static int findingMinRopeTakenAway() {
        Scanner input = new Scanner(System.in);
        int cutRopeSegments = input.nextInt();
        int[] remainingSegments = new int[cutRopeSegments];
        for (int i = 0; i < cutRopeSegments; i++) {
            remainingSegments[i] = input.nextInt();
        }
        int maxRemainingSegment = remainingSegments[0];
        int minRemainingSegment = remainingSegments[0];
        int sumOfRemainingSegments = remainingSegments[remainingSegments.length - 1];
        for (int i = 0; i < cutRopeSegments - 1; i++) {
            sumOfRemainingSegments += remainingSegments[i];
            if (remainingSegments[i + 1] > maxRemainingSegment) {
                maxRemainingSegment = remainingSegments[i + 1];
            }
            if (remainingSegments[i + 1] < minRemainingSegment) {
                minRemainingSegment = remainingSegments[i + 1];
            }
        }
        int smallerRemainingSegments = sumOfRemainingSegments - maxRemainingSegment;
        int minRopeTakenAway = 0;
        if (minRemainingSegment == maxRemainingSegment || maxRemainingSegment <= smallerRemainingSegments) {
            minRopeTakenAway = sumOfRemainingSegments;
        } else {
            minRopeTakenAway = maxRemainingSegment - smallerRemainingSegments;
        }
        return minRopeTakenAway;
    }
}
