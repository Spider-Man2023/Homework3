import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();

        int[][] sort = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(sort[i], -1);
        }


        for (int z = 0; z < Math.min((m + 1) / 2, (n + 1) / 2); z++) {
            boolean k = true;
            for (int i = z; i < m - 1 - z; i++) {
                k = false;

                sort[i][z] = input.nextInt();
            }
            for (int j = z; j < n - 1 - z; j++) {
                k = false;
                sort[m - 1 - z][j] = input.nextInt();
            }
            for (int i = 0; i < m - 1 - z * 2; i++) {
                if (sort[m - 1 - z - i][n - 1 - z] != -1) {
                    break;
                }
                sort[m - 1 - z - i][n - 1 - z] = input.nextInt();
            }
            for (int j = 0; j < n - 1 - z * 2; j++) {
                if (sort[z][n - 1 - z - j] != -1) {
                    break;
                }
                sort[z][n - 1 - z - j] = input.nextInt();
            }
            if (k) {
                sort[m / 2][n / 2] = input.nextInt();
            }
        }

        int count = 0;
        for (int[] ints : sort) {
            count++;
            System.out.printf("%d", ints[0]);
            for (int j = 1; j < n; j++) {
                System.out.printf(" %d", ints[j]);
            }
            if (count != m) {
                System.out.println();
            }
        }

    }
}
