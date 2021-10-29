package backjun;

import java.util.*;
import java.io.*;

public class BOJ_22055_컨베이어벨트위의로봇 {

    static int[] belt;
    static int cnt, start, end, n, k;
    static boolean[] visit;
    static Queue<Integer> robot = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        belt = new int[2 * n + 1];
        visit = new boolean[2 * n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2 * n; i++)
            belt[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        start = 1;
        end = n;
        while (cnt < k) {
            answer++;
            move_belt();
            move_robot();
            make_robot();
        }
        System.out.println(answer);
    }

    static void move_belt() {
        start--;
        end--;
        if (start < 1)
            start = 2 * n;
        if (end < 1)
            end = 2 * n;

    }

    static void move_robot() {
        int size = robot.size();
        // 자바는 영향을 받는구나 python은 영향을 안받았는데...
        for (int i = 0; i < size; i++) {
            int pos = robot.peek();

            visit[pos] = false;
            robot.poll();
            if (pos == end)
                continue;
            int next = pos + 1;
            if (next > 2 * n)
                next = 1;

            if (belt[next] >= 1 && visit[next] == false) {
                belt[next]--;
                if (belt[next] == 0)
                    cnt += 1;
                if (next == end)
                    continue;
                visit[next] = true;
                robot.add(next);
            } else {
                visit[pos] = true;
                robot.add(pos);
            }

        }
    }

    static void make_robot() {
        if (visit[start] == false && belt[start] >= 1) {
            visit[start] = true;
            belt[start] -= 1;
            robot.add(start);
            if (belt[start] == 0)
                cnt += 1;
        }
    }
}
