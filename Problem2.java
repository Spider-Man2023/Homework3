
import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] arr = new int[n][n];
        ArrayList<int[]> black = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.nextInt();
                if (arr[i][j] == 1) {
                    black.add(new int[]{i, j});
                }
            }
        }

        int c = 0;
        for (int[] cc : black) {
            for (int[] dd : black) {
                if ((cc[0] == dd[0] && Math.abs(cc[1] - dd[1]) == 1)
                        || (cc[1] == dd[1] && Math.abs(cc[0] - dd[0]) == 1)) {
                    c++;
                }
            }
        }

        int p = 4 * black.size() - c;
        System.out.print(p);
    }
}
