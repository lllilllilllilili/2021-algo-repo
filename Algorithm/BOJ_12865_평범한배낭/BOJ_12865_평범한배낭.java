public
package backjun;

import java.util.*;
import java.io.*;

public class BOJ_10816_숫자카드2 {

    static int[] card;

    static int uppercase(int number) {
        int left = 0;
        int right = card.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (card[mid] > number) {
                right = mid - 1;
            } else if (card[mid] == number) {
                index = mid;
                left = mid + 1;
                // System.out.println("upper "+ index);
            } else {
                left = mid + 1;
            }
        } // end of while loop
        return index;
    }

    static int lowercase(int number) {
        int left = 0;
        int right = card.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (card[mid] > number) {
                right = mid - 1;
            } else if (card[mid] == number) {
                index = mid;
                right = mid - 1;
                // System.out.println("lower "+index);
            } else {
                left = mid + 1;
            }
        } // end of while loop
        return index;
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        card = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        int m = Integer.parseInt(br.readLine());
        int[] sang = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sang[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sang.length; i++) {
            int upperCnt = uppercase(sang[i]);
            int lowerCnt = lowercase(sang[i]);
            if (lowerCnt == -1)
                sb.append("0 ");
            else
                sb.append((upperCnt - lowerCnt + 1) + " ");
        }
        System.out.println(sb.toString());
    }
}

class BOJ_12865_평범한배낭 {

}
