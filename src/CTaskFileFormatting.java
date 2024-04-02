import java.util.Scanner;

public class CTaskFileFormatting {
    public static void main(String[] args) {
        CTaskFileFormatting newTask = new CTaskFileFormatting();
        newTask.fileFormatting();
    }

    public long fileFormatting() {
        //get
        Scanner input = new Scanner(System.in);
        int numberOfStrings = input.nextInt();
        int[] file = new int[numberOfStrings];
        for (int i = 0; i < numberOfStrings; i++) {
            file[i] = input.nextInt();
        }
        input.close();
        long result = 0;
        for (int i = 0; i < numberOfStrings; i++) {
            result += buttonsPressingForTypingSpacebars(file[i]);
        }
        System.out.println(result);
        return(result);
    }

    public static long buttonsPressingForTypingSpacebars(int spacebarsQuantity) {
        long result = 0;
        int tab = 4;
            result += spacebarsQuantity / tab;
            if (spacebarsQuantity % tab == 3) {
                result += 2;
            } else {
                result += spacebarsQuantity % tab;
            }
        return (result);
    }
}
