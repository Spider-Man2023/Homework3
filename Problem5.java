import java.util.ArrayList;
import java.util.Scanner;

public class Problem5 {
    public static int count0(int[] line) {
        int count = 0;
        for (int i : line) {
            if (i == 0) {
                count++;
            }
        }
        return count;
    }

    public static ArrayList<int[]> row(int[][] board) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int i = 4; i < board.length; i++) {
                int[] line = new int[5];
                for(int h = 0;h<5;h++){
                    line[h] = board[r][i-h];
                }
                if(count0(line)==1){
                    for(int z = 0;z<5;z++){
                        if(board[r][i-z]==0){
                            result.add(new int[]{r+1,i-z+1});
                        }
                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<int[]> column(int[][] board) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int r = 4; r < board.length; r++) {
            for (int i = 0; i < board.length; i++) {
                int[] line = new int[5];
                for(int h = 0;h<5;h++){
                    line[h] = board[r-h][i];
                }
                if(count0(line)==1){
                    for(int z = 0;z<5;z++){
                        if(board[r-z][i]==0){
                            result.add(new int[]{r-z+1,i+1});
                        }
                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<int[]> diagonal1(int[][] board) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int r = 4; r < board.length; r++) {
            for (int i = 4; i < board.length; i++) {
                int[] line = new int[5];
                for(int h = 0;h<5;h++){
                    line[h] = board[r-h][i-h];
                }
                if(count0(line)==1){
                    for(int z = 0;z<5;z++){
                        if(board[r-z][i-z]==0){
                            result.add(new int[]{r-z+1,i-z+1});
                        }
                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<int[]> diagonal2(int[][] board) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int r = 4; r < board.length; r++) {
            for (int i = 0; i < board.length-4; i++) {
                int[] line = new int[5];
                for(int h = 0;h<5;h++){
                    line[h] = board[r-h][i+h];
                }
                if(count0(line)==1){
                    for(int z = 0;z<5;z++){
                        if(board[r-z][i+z]==0){
                            result.add(new int[]{r-z+1,i+z+1});
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = input.nextInt();
            }
        }
        ArrayList<int[]> result = new ArrayList<>();
        result.addAll(row(board));
        result.addAll(column(board));
        result.addAll(diagonal1(board));
        result.addAll(diagonal2(board));

        while (true) {
            for (int i = 0; i < result.size() - 1; i++) {
                if (result.get(i)[0] > result.get(i + 1)[0]) {
                    int[] alter = result.get(i);
                    result.set(i, result.get(i + 1));
                    result.set(i + 1, alter);
                } else if (result.get(i)[0] == result.get(i + 1)[0]) {
                    if (result.get(i)[1] > result.get(i + 1)[1]) {
                        int[] alter = result.get(i);
                        result.set(i, result.get(i + 1));
                        result.set(i + 1, alter);
                    } else if (result.get(i)[1] == result.get(i + 1)[1]) {
                        result.remove(i + 1);
                    }
                }
            }
            boolean k = true;
            for (int i = 0; i < result.size() - 1; i++) {
                if (result.get(i)[0] > result.get(i + 1)[0]) {
                    k = false;
                } else if (result.get(i)[0] == result.get(i + 1)[0]) {
                    if (result.get(i)[1] >= result.get(i + 1)[1]) {
                        k = false;
                    }
                }
            }
            if (k) {
                break;
            }
        }

        int count = 0;
        for (int[] u : result) {
            count++;
            System.out.printf("%d %d", u[0], u[1]);
            if (count != result.size()) {
                System.out.println();
            }
        }
        if(result.size()==0){
            System.out.println(-1);
        }
    }
}
