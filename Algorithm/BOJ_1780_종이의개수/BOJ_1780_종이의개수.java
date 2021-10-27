package backjun;

import java.util.*;
import java.io.*;

public class BOJ_1780_종이의개수 {

    static int[][] map;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // end of for loop
        int[] cnt = new int[3];
        solved(cnt, 0, 0, n);
        for (int i = 0; i < cnt.length; i++) {
            System.out.println(cnt[i]);
        }
    }

    static void solved(int[] cnt, int x, int y, int n) {

        if (same(cnt, x, y, n)) {
            cnt[map[x][y] + 1] += 1;
            return;
        }
        int m = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solved(cnt, x + i * m, y + j * m, m);
            }
        }
    }

    static boolean same(int[] cnt, int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (map[x][y] != map[i][j])
                    return false;
            }
        }
        return true;
    }
}
