import java.util.Scanner;

public class GDestroyTheBarracks {

    public static void main(String[] args) {
        GDestroyTheBarracks newTask = new GDestroyTheBarracks();
        System.out.println(newTask.countRounds());
    }

    public static int countRounds() {
        Scanner input = new Scanner(System.in);

        int mySoldiersQuantity = input.nextInt();
        int barracksHealth = input.nextInt();
        int enemySoldiersCreatedPerRound = input.nextInt();
        input.close();

        int enemySoldiersCount = 0;
        int roundsCounter = 0;
        int result = 0;
        if (enemySoldiersCreatedPerRound >= mySoldiersQuantity && barracksHealth > 0) {
            result = -1;
        }


        barracksHealth = attackBarrackFirstly(barracksHealth, mySoldiersQuantity);
        enemySoldiersCount = attackOnSoldiers(barracksHealth, enemySoldiersCount, mySoldiersQuantity);
        barracksHealth = zeroingBarracksHealth (barracksHealth);
        enemySoldiersCount = roundEnding(barracksHealth, enemySoldiersCount, enemySoldiersCreatedPerRound);
        roundsCounter++;


        while ((barracksHealth > 0 || enemySoldiersCount > 0) && mySoldiersQuantity > 0) {
            if (((mySoldiersQuantity - (enemySoldiersCount - (mySoldiersQuantity - barracksHealth))) * 1599 / 1000 >= (enemySoldiersCount - (mySoldiersQuantity - barracksHealth))) && mySoldiersQuantity >= barracksHealth) {

                    barracksHealth = attackBarrackFirstly(barracksHealth, mySoldiersQuantity);
                enemySoldiersCount = attackOnSoldiers(barracksHealth, enemySoldiersCount, mySoldiersQuantity);
                barracksHealth = zeroingBarracksHealth (barracksHealth);
            } else if (mySoldiersQuantity > enemySoldiersCount) {
                if (enemySoldiersCount > 0) {
                    enemySoldiersCount -= mySoldiersQuantity;
                    barracksHealth += enemySoldiersCount;
                    enemySoldiersCount = 0;

                } else {
                    barracksHealth -= mySoldiersQuantity;
                }
            }
            mySoldiersQuantity = enemyAttack(mySoldiersQuantity, enemySoldiersCount);
            enemySoldiersCount = roundEnding(barracksHealth, enemySoldiersCount, enemySoldiersCreatedPerRound);
            roundsCounter++;
        }
        if (mySoldiersQuantity > 0) {
            result = roundsCounter;
        }
        return (result);
    }


    public static int attackBarrackFirstly(int barracksHealth, int mySoldiersQuantity) {
        return barracksHealth -= mySoldiersQuantity;
    }
    public static int attackOnSoldiers(int barracksHealth, int enemySoldiersCount, int mySoldiersQuantity) {
        if (barracksHealth < 0) {
            enemySoldiersCount += barracksHealth;
        }
        return (enemySoldiersCount);
    }

    public static int zeroingBarracksHealth (int barracksHealth) {
        if (barracksHealth < 0) {
            barracksHealth = 0;
        }
        return barracksHealth;
    }

    public static int enemyAttack(int mySoldiersQuantity, int enemySoldiersCount) {
        if (enemySoldiersCount > 0) {
            mySoldiersQuantity -= enemySoldiersCount;
        }
        return (mySoldiersQuantity);
    }
    public static int roundEnding(int barracksHealth, int enemySoldiersCount, int enemySoldiersCreatedPerRound) {
        if (barracksHealth > 0) {
            enemySoldiersCount += enemySoldiersCreatedPerRound;
        }
        return (enemySoldiersCount);
    }
}

