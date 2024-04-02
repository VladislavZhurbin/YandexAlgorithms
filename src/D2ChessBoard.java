import java.util.Scanner;

public class D2ChessBoard {
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        D2ChessBoard newTask = new D2ChessBoard();
        newTask.countPerimeter();
    }

    public static int countPerimeter() {
        Scanner input = new Scanner(System.in);
        int chessboardCageQuantity = input.nextInt();
        int[][] chessboard = new int[10][10];
        int firstX = -1;
        int firstY = -1;
        int perimeterCount = 0;
        for (int i = 0; i < chessboardCageQuantity; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            chessboard[x][y] = 1;
            if (i == 0) {
                firstX = x;
                firstY = y;
            }
        }
        input.close();

        switch (chessboardCageQuantity) {
            case 1:
                perimeterCount = 4;
                break;
            case 2:
                perimeterCount = 6;
                break;
            case 3:
                perimeterCount = 8;
                break;
            case 64:
                perimeterCount = 32;
                break;
            default:
                perimeterCount = searchNextPerimeterCage(chessboard, firstX, firstY, perimeterCount);
        }
        System.out.println(perimeterCount);
        return perimeterCount;
    }

    private static int searchNextPerimeterCage(int[][] chessboard, int abscissa, int ordinate, int perimeterCount) {
        chessboard[abscissa][ordinate] = -1;
        int newAbscissa = -2;
        int newOrdinate = -2;
        for (int[] dir : DIRECTIONS) {
            int newX = abscissa + dir[0];
            int newY = ordinate + dir[1];
            if (isValid(chessboard, newX, newY)) {
                if (chessboard[newX][newY] != 1) {
                    perimeterCount++;
                } else if (newAbscissa == -2 && newOrdinate == -2) {
                    newAbscissa = newX;
                    newOrdinate = newY;
                }
            } else {
                perimeterCount++; // Increment perimeter if neighboring cage is outside the chessboard
            }
        }
        if (newAbscissa >= 0 && newOrdinate >= 0) {
            perimeterCount = searchNextPerimeterCage(chessboard, newAbscissa, newOrdinate, perimeterCount);
        }
        return perimeterCount;
    }

    private static boolean isValid(int[][] chessboard, int x, int y) {
        return x >= 0 && x < chessboard.length && y >= 0 && y < chessboard[0].length;
    }
}










//import java.util.Scanner;
//
//public class D2ChessBoard {
//    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//
//    public static void main(String[] args) {
//        D2ChessBoard newTask = new D2ChessBoard();
//        newTask.countPerimeter();
//    }
//    public static int countPerimeter() {
//        Scanner input = new Scanner(System.in);
//        int chessboardCageQuantity = input.nextInt();
//        int[][] chessboard = new int[10][10];
//        int firstX = -1;
//        int firstY = -1;
//        int perimeterCount = 0;
//        for (int i = 0; i < chessboardCageQuantity; i++) {
//                int x = input.nextInt();
//                int y = input.nextInt();
//                chessboard[x][y] = 1;
//            if (i == 0) {
//                firstX = x;
//                firstY = y;
//            }
//        }
//        input.close();
//
//        switch (chessboardCageQuantity) {
//            case(1):
//                perimeterCount = 4;
//                break;
//            case(2):
//                perimeterCount = 6;
//                break;
//            case(3):
//                perimeterCount = 8;
//                break;
//            case(64):
//                perimeterCount = 32;
//                break;
//            default:
//                perimeterCount = searchNextPerimeterCage(chessboard, firstX, firstY, perimeterCount);
//        }
//        System.out.println(perimeterCount);
//        return perimeterCount;
//    }
//
//    private static int searchNextPerimeterCage (int[][] chessboard, int abscissa, int ordinate, int perimeterCount) {
//        chessboard[abscissa][ordinate] = -1;
//        int newAbscissa = -2;
//        int newOrdinate = -2;
//        for (int[] dir : DIRECTIONS) {
//            if (chessboard[abscissa + dir[0]][ordinate + dir[1]] != 1) {
//                perimeterCount++;
//            } else if (chessboard[abscissa + dir[0]][ordinate + dir[1]] == 1 && newAbscissa == -2 && newOrdinate == -2) {
//                newAbscissa = abscissa + dir[0];
//                newOrdinate = ordinate + dir[1];
//            }
//        }
//        if (newAbscissa > 0 && newOrdinate > 0) {
//            searchNextPerimeterCage(chessboard, newAbscissa, newOrdinate, perimeterCount);
//        }
//        return perimeterCount;
//    }
//
//
//}
//
//
//

//public class ChessboardPerimeter {
//    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//    public static int calculatePerimeter(int[][] chessboard, int x, int y) {
//        int perimeter = 0;
//        dfs(chessboard, x, y, perimeter);
//        return perimeter;
//    }
//
//    private static void dfs(int[][] chessboard, int x, int y, int perimeter) {
//        chessboard[x][y] = -1; // Mark as visited
//        for (int[] dir : DIRECTIONS) {
//            int newX = x + dir[0];
//            int newY = y + dir[1];
//            if (isValid(chessboard, newX, newY)) {
//                if (chessboard[newX][newY] == 0) {
//                    perimeter++;
//                } else if (chessboard[newX][newY] == 1) {
//                    dfs(chessboard, newX, newY, perimeter);
//                }
//            } else {
//                perimeter++; // If the neighboring cage is outside the chessboard, increment perimeter
//            }
//        }
//    }
//
//    private static boolean isValid(int[][] chessboard, int x, int y) {
//        return x >= 0 && x < chessboard.length && y >= 0 && y < chessboard[0].length;
//    }
//
//    public static void main(String[] args) {
//        int[][] chessboard = new int[10][10]; // Initialize chessboard with 10x10 size
//        // Set the initial cage with a value of 1
//        chessboard[3][3] = 1; // For example, start from cage (3, 3)
//        int perimeter = calculatePerimeter(chessboard, 3, 3);
//        System.out.println("Perimeter: " + perimeter);
//    }
//}
