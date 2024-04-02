import java.util.Scanner;

public class bSoccerCommentator {
    public static void main(String[] args) {
        bSoccerCommentator main = new bSoccerCommentator();
        main.calculateGoalsNeededToWin();
    }

    public static int calculateGoalsNeededToWin() {
        Scanner input = new Scanner(System.in);

        // Read data from first string
        String[] firstMatchResult = input.nextLine().split(":");
        int gOneFirstMatch = Integer.parseInt(firstMatchResult[0]);
        int gTwoFirstMatch = Integer.parseInt(firstMatchResult[1]);

        // Read data from second string
        String[] secondMatchResult = input.nextLine().split(":");
        int gOneSecondMatch = Integer.parseInt(secondMatchResult[0]);
        int gTwoSecondMatch = Integer.parseInt(secondMatchResult[1]);

        // Read data from third string
        int numberOfHomeMatch = input.nextInt();

        input.close();

        int gOneTotalGoals = gOneFirstMatch + gOneSecondMatch;
        int gTwoTotalGoals = gTwoFirstMatch + gTwoSecondMatch;
        int pointsRequiredToLevelGameScore = gTwoTotalGoals - gOneTotalGoals;
        int result = 0;

        if (pointsRequiredToLevelGameScore >= 0) {
            switch (numberOfHomeMatch) {
                case 1:
                    if (pointsRequiredToLevelGameScore + gOneSecondMatch <= gTwoFirstMatch) {
                        result = pointsRequiredToLevelGameScore + 1;
                    } else if (pointsRequiredToLevelGameScore + gOneSecondMatch > gTwoFirstMatch) {
                        result = pointsRequiredToLevelGameScore;
                    }
                    break;
                case 2:
                    if (gOneFirstMatch <= gTwoSecondMatch) {
                        result = pointsRequiredToLevelGameScore + 1;
                    } else {
                        result = pointsRequiredToLevelGameScore;
                    }
                    break;
            }
        }

        System.out.println(result);
        return result;
    }
}
