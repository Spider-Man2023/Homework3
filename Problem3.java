import java.util.ArrayList;
import java.util.Scanner;

public class Problem3 {
    public static int[][] distribute(int[] a) {
        int[][] p = new int[4][3];
        if (a[1] > 0 && a[2] > 0) {
            p[0] = new int[]{2, a[1], a[2]};
            p[1] = new int[]{1, a[1] + 1, a[2]};
            p[2] = new int[]{3, a[1] + 1, a[2] + 1};
            p[3] = new int[]{4, a[1], a[2] + 1};
        } else if (a[1] > 0 && a[2] < 0) {
            p[0] = new int[]{3, a[1], a[2]};
            p[1] = new int[]{4, a[1] + 1, a[2]};
            p[2] = new int[]{1, a[1] + 1, a[2] - 1};
            p[3] = new int[]{2, a[1], a[2] - 1};
        } else if (a[1] < 0 && a[2] > 0) {
            p[0] = new int[]{1, a[1], a[2]};
            p[1] = new int[]{2, a[1] - 1, a[2]};
            p[2] = new int[]{3, a[1] - 1, a[2] + 1};
            p[3] = new int[]{4, a[1], a[2] + 1};
        } else if (a[1] < 0 && a[2] < 0) {
            p[0] = new int[]{4, a[1], a[2]};
            p[1] = new int[]{3, a[1] - 1, a[2]};
            p[2] = new int[]{2, a[1] - 1, a[2] - 1};
            p[3] = new int[]{1, a[1], a[2] - 1};
        } else if (a[2] == 0 && a[1] > 0) {
            p[0] = new int[]{3, a[1], 1};
            p[1] = new int[]{4, a[1] + 1, 1};
            p[2] = new int[]{1, a[1] + 1, -1};
            p[3] = new int[]{2, a[1], -1};
        } else if (a[2] == 0 && a[1] < 0) {
            p[0] = new int[]{4, a[1], 1};
            p[1] = new int[]{3, a[1] - 1, 1};
            p[2] = new int[]{2, a[1] - 1, -1};
            p[3] = new int[]{1, a[1], -1};
        } else if (a[2] != 0) {
            p[0] = new int[]{3, -1, a[2] + 1};
            p[1] = new int[]{4, 1, a[2] + 1};
            p[2] = new int[]{1, 1, a[2]};
            p[3] = new int[]{2, -1, a[2]};
        } else {
            p[0] = new int[]{3, -1, 1};
            p[1] = new int[]{4, 1, 1};
            p[2] = new int[]{1, 1, -1};
            p[3] = new int[]{2, -1, -1};
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] inf = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                inf[i][j] = input.nextInt();
            }
            if (inf[i][0] == 2) {
                inf[i][0] = 3;
            }
        }
        ArrayList<int[]> p = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int z = 0; z < 4; z++) {
                p.add(new int[]{inf[i][0], distribute(inf[i])[z][0], distribute(inf[i])[z][1], distribute(inf[i])[z][2]});
            }
        }

        ArrayList<int[]> finalResult = new ArrayList<>();
        finalResult.add(p.get(0));
        for (int[] h : p) {
            boolean k = true;
            int count = -1;
            for (int[] g : finalResult) {
                count++;
                if (h[2] == g[2] && h[3] == g[3]) {
                    k = false;
                    if (g[0] == 3) {
                        break;
                    }
                    if (h[0] > g[0]) {
                        g[0] = h[0];
                        break;
                    }
                    if (h[0] == 1 && g[0] == 1) {
                        if (Math.abs(h[1] - g[1]) == 2) {
                            finalResult.set(count, new int[]{3, g[1], g[2], g[3]});
                            break;
                        } else if (Math.abs((h[1] - g[1]) % 2) == 1) {
                            finalResult.set(count, new int[]{2, g[1], g[2], g[3], h[1]});
                            break;
                        }
                    }
                    if (g.length == 5) {
                        if (h[0] == 1 && h[1] != g[4] && h[1] != g[1]) {
                            g[0] = 3;
                        }
                    }
                }
            }
            if (k) {
                finalResult.add(h);
            }
        }
        double sum = 0;
        for (int[] l : finalResult) {
            if (l[0] == 1) {
                sum += Math.PI / 4;
            } else if (l[0] == 2) {
                sum += Math.pow(3, 0.5) / 4 + Math.PI / 6;
            } else {
                sum += 1;
            }
        }
        System.out.printf("%.5f", sum);
    }
}
