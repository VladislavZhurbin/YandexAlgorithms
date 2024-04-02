import java.util.*;

public class APaintingTrees {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int p = input.nextInt();
        int v = input.nextInt();
        int q = input.nextInt();
        int m = input.nextInt();
        input.close();

        int treesQuantity = 0;

        int[] values = {p - v, p + v, q - m, q + m};

        Arrays.sort(values);

        Set<Integer> uniqueValues = new HashSet<>();
        for (int value : values) {
            uniqueValues.add(value);
        }
        int[] uniqueArray = uniqueValues.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(uniqueArray);

        switch (uniqueValues.size()) {
            case 2:
                treesQuantity = uniqueArray[2] - uniqueArray[0] + 1;
                break;
            case 3:
                treesQuantity = uniqueArray[2] - uniqueArray[0] + 1;
                break;
            case 4:
                if (uniqueArray[1] == (p + v) || uniqueArray[1] == (q + m)) {
                    treesQuantity = uniqueArray[1] - uniqueArray[0] + 2 + uniqueArray[3] - uniqueArray[2];
                } else if (uniqueArray[1] == (p - v) || uniqueArray[1] == (q - m)) {
                    treesQuantity = uniqueArray[3] - uniqueArray[0] + 1;
                } else {
                    treesQuantity = 2 * uniqueArray[1] - uniqueArray[0] + 1 + uniqueArray[3] - 2 * uniqueArray[2];
                }
                break;
        }

        System.out.println(treesQuantity);
    }
}
