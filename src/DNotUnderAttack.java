import java.util.Scanner;

public class DNotUnderAttack {
    public static void main(String[] args) {
        DNotUnderAttack newTask = new DNotUnderAttack();
        newTask.countFiledsNotUnderAttack();
    }
    public int countFiledsNotUnderAttack() {
        Scanner input = new Scanner(System.in);
        char[][] chessBoard = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String row = input.nextLine().replaceAll("\\s+", "");
            for (int j = 0; j < 8; j++) {
                chessBoard[i][j] = row.charAt(j);
            }
        }
        input.close();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard[i][j] == 'R') {
                    handleRook(chessBoard, i, j);
                } else if (chessBoard[i][j] == 'B') {
                    handleBishop(chessBoard, i, j);
                }
            }
        }

        int result = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard[i][j] == '*') {
                    result++;
                }
            }
        }
        System.out.println(result);

        return (result);

    }
    private static void handleRook(char[][] chessBoard, int i, int j) {
        for (int x = i + 1; x < 8; x++) {
            if (chessBoard[x][j] == 'R' || chessBoard[x][j] == 'B') break;
            chessBoard[x][j] = '0';
        }
        for (int x = i - 1; x >= 0; x--) {
            if (chessBoard[x][j] == 'R' || chessBoard[x][j] == 'B') break;
            chessBoard[x][j] = '0';
        }
        for (int y = j + 1; y < 8; y++) {
            if (chessBoard[i][y] == 'R' || chessBoard[i][y] == 'B') break;
            chessBoard[i][y] = '0';
        }
        for (int y = j - 1; y >= 0; y--) {
            if (chessBoard[i][y] == 'R' || chessBoard[i][y] == 'B') break;
            chessBoard[i][y] = '0';
        }
    }

    private static void handleBishop(char[][] chessBoard, int i, int j) {
        handleDiagonal(chessBoard, i, j, 1, 1);
        handleDiagonal(chessBoard, i, j, -1, 1);
        handleDiagonal(chessBoard, i, j, 1, -1);
        handleDiagonal(chessBoard, i, j, -1, -1);
    }

    private static void handleDiagonal(char[][] chessBoard, int i, int j, int iIncrement, int jIncrement) {
        int x = i + iIncrement;
        int y = j + jIncrement;

        while (x >= 0 && x < 8 && y >= 0 && y < 8) {
            if (chessBoard[x][y] == 'R' || chessBoard[x][y] == 'B') break;
            chessBoard[x][y] = '0';
            x += iIncrement;
            y += jIncrement;
        }
    }
}
