class Solution {
    
    int INF = 99999999;
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        int[][] road = new int[n+1][n+1];
        for(int i=0; i<edge_list.length; i++){
            //양방향
            int s = edge_list[i][0];
            int e = edge_list[i][1];
            road[s][e] = 1;
            road[e][s] = 1; 
        }
        
        //최솟값을 구해야 하므로 모든 값 INF 초기화 
        int[][] dp = new int[k][n+1];
        for(int i=0; i<k; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = INF;
            }
        }
        
        //맨 첫번째 값은 정해진 값이기 때문에 0번째 인덱스에는 gps_log[0]의 값이 들어가야 한다. 
        dp[0][gps_log[0]] = 0;
        for(int i=1; i<k; i++){
            for(int j=1; j<n+1; j++){
                //이동하지 않았을 경우
                //dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                
                for(int node=1; node<n+1; node++){
                    if(road[j][node]==1){
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][node]);
                    }
                }//end of for loop
                //j노드와 gps_log[i]와 다르다면 gps_log를 수정해 줘야 하기 때문에 값을 더해줌
                if(j!=gps_log[i])
                    dp[i][j]++;
                
                
            }
        }
        if(dp[k-1][gps_log[k-1]]<INF){
            return dp[k-1][gps_log[k-1]];
        }else
            return -1;
    }
}