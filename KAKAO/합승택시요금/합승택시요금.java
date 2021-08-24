import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int dist[][];
        dist = new int[n + 1][n + 1];

        int INF = 20000000;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < fares.length; i++) {
            int[] tmp = fares[i];
            int cityA = tmp[0];
            int cityB = tmp[1];
            int w = tmp[2];

            dist[cityA][cityB] = w;
            dist[cityB][cityA] = w;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        dist[i][j] = 0;
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        answer = INF;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        return answer;
    }
}