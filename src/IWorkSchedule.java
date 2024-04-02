import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;

public class IWorkSchedule {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int officialHolidaysQuantity = Integer.parseInt(input.nextLine());
        int yearNumber = Integer.parseInt(input.nextLine());
        int[][] holidaysDates = new int[officialHolidaysQuantity][2];
        int[] weekdaysQuantity = new int[7];
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (int i = 0; i < officialHolidaysQuantity; i++) {
            String[] part = input.nextLine().split(" ");
            //get day of month number
            holidaysDates[i][0] = Integer.parseInt(part[0]);
            //get month number
            holidaysDates[i][1] = Month.valueOf(part[1].toUpperCase()).getValue();
            //get number of day of week
            weekdaysQuantity[LocalDate.of(yearNumber, holidaysDates[i][1], holidaysDates[i][0]).getDayOfWeek().getValue() - 1]++;
        }
        input.close();
        int[] weekdaysInYear = new int[7];
        Arrays.fill(weekdaysInYear, 52);
        Year thisYear = Year.of(yearNumber);
        // Проверяем, является ли год високосным
        boolean isLeapYear = thisYear.isLeap();
        LocalDate firstDayOfYear = LocalDate.of(yearNumber, 1, 1);
        weekdaysInYear[firstDayOfYear.getDayOfWeek().getValue() - 1]++;
        if (isLeapYear) {
            if (firstDayOfYear.getDayOfWeek().getValue() == 7) {
                weekdaysInYear[0]++;
            } else {
                weekdaysInYear[firstDayOfYear.getDayOfWeek().getValue()]++;
            }
        }
        int[] result = weekdaysInYear.clone();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {

                if (i != j) {
                    result[i] += weekdaysQuantity[j];
                }
            }
        }
        int maxWeekends = 0;
        int minWeekends = 0;
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i + 1] > result[maxWeekends]) {
                maxWeekends = i + 1;
            }
            if (result[i + 1] < result[minWeekends]) {
                minWeekends = i + 1;
            }
        }
        System.out.println(daysOfWeek[maxWeekends] + " " + daysOfWeek[minWeekends]);
    }
}



//
//        System.out.println(Arrays.toString(weekdaysQuantity));
//        System.out.println(Arrays.toString(weekdaysInYear));
//        System.out.println();
//
//        System.out.println(Arrays.toString(result));
//        System.out.println(maxWeekends);
//        System.out.println(minWeekends);
