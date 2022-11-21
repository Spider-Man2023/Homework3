import java.util.Scanner;

public class Problem1 {
    public static int multi(int[] a,int[] b){
        int multi = 0;
        for(int i = 0;i<a.length;i++){
            multi+=a[i]*b[i];
        }
        return multi;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                A[i][j] = input.nextInt();
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                B[i][j] = input.nextInt();
            }
        }

        int[][] A2 = new int[n/2][n/2];
        int[][] A3 = new int[n/2][n/2];
        for(int i = 0;i<n/2;i++){
            if (n - n / 2 >= 0) System.arraycopy(A[i], n / 2, A2[i], 0, n - n / 2);
        }
        for(int i = n/2;i<n;i++){
            System.arraycopy(A[i], 0, A3[i - n / 2], 0, n / 2);
        }

        int[][] B2 = new int[n/2][n/2];
        int[][] B3 = new int[n/2][n/2];
        for(int i = 0;i<n/2;i++){
            if (n - n / 2 >= 0) System.arraycopy(B[i], n / 2, B2[i], 0, n - n / 2);
        }
        for(int i = n/2;i<n;i++){
            System.arraycopy(B[i], 0, B3[i - n / 2], 0, n / 2);
        }

        int[][] r2 = new int[n/2][n/2];
        for(int i = 0;i<n/2;i++){
            for(int j = 0;j<n/2;j++){
                r2[i][j] = multi(A2[i],B2[j]);
            }
        }

        int[][] r3 = new int[n/2][n/2];
        for(int i = 0;i<n/2;i++){
            for(int j = 0;j<n/2;j++){
                r3[j][i] = multi(A3[i],B3[j]);
            }
        }

        for(int k = 0;k<n/2;k++){
            for(int i = 0;i<n/2;i++){
                System.out.printf("%d ",A[k][i]+B[k][i]);
            }
            for(int i = 0;i<n/2;i++){
                System.out.printf("%d ",r2[k][i]);
            }
            System.out.println();
        }

        for(int k = 0;k<n/2;k++){
            for(int i = 0;i<n/2;i++){
                System.out.printf("%d ",r3[k][i]);
            }
            for(int i = n/2;i<n;i++){
                System.out.printf("%d ",A[k+n/2][i]-B[k+n/2][i]);
            }
            System.out.println();
        }

    }
}
