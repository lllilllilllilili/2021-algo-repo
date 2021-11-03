package backjun;

import java.util.*;
import java.io.*;
public class BOJ_19237_어른상어 {

	static int[][] map;
	static int[][] smellOwner = new int[21][21];
	static int[][] leftTime = new int[21][21];
	static Map<Integer, Shark> sharks = new HashMap<>();
	static int time = 0;
	static int n,m,k;
	static ArrayList<Integer> [][] sharkDirectionOrder ;
	static class Shark {
		int id, x, y, dir;
		//우선순위 방향
		int[][] priority = new int[5][5];
		Shark() { }
		int findNextDir(Set<Integer> candidates) {
			for(int i=1; i<5; i++) {
				if(candidates.contains(priority[dir][i])) {
					return priority[dir][i];
				}
			}
			return 0;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//n = 격자 크기, m = 상어 개수, k = 상어가 k번 이동하면 삭제
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
				
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>0) {
					Shark s = new Shark();
					s.id = map[i][j];
					s.x = i;
					s.y = j;
					sharks.put(s.id, s);
					smellOwner[i][j] = s.id;
					leftTime[i][j] = k;
				}
			}
		}//end of for loop
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			Shark s = sharks.get(i+1);
			s.dir = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<m; i++) {
			Shark s = sharks.get(i+1);
			for(int j=0; j<4; j++) {
				st = new StringTokenizer(br.readLine());
				//i번째 상어의 우선순위 방향을 인덱스 1부터 ... 5까지 저장 (=4)
				for(int z=0; z<4; z++) {
					s.priority[j+1][z+1] = Integer.parseInt(st.nextToken());
				}
			}
		}
		///출력/// 
		while(time++<1000) {
			moveShark();
			decreaseSmellTime();
			createSmell();
			if(sharks.size() == 1) {
				System.out.println(time);
				return ;
			}
		}
		System.out.println(-1);
		
		
		
		
		
	}
	static void decreaseSmellTime() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(leftTime[i][j] == 0) continue;
				leftTime[i][j]--;
				if(leftTime[i][j] == 0) {
					smellOwner[i][j] = 0;
				}
			}
		}
	}
	static void createSmell() {
		for(Integer id : sharks.keySet()) {
			Shark s = sharks.get(id);
			smellOwner[s.x][s.y]= s.id;
			leftTime[s.x][s.y] = k;
		}
	}
	static void moveShark() {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		Queue<Integer> willRemove = new LinkedList<Integer>();
		for(Integer id : sharks.keySet()) {
			Set<Integer> noSmellSet = new HashSet<>();
			Set<Integer> mySmellSet = new HashSet<>();
			Shark s = sharks.get(id);
			for(int i=0; i<4; i++) {
				int nx = s.x + dx[i];
				int ny = s.y + dy[i];
				if(nx < 0 || nx>=n || ny<0 || ny>=n) continue;
				if(smellOwner[nx][ny] == 0) {
					noSmellSet.add(i+1);
				}else if(smellOwner[nx][ny] == s.id) {
					mySmellSet.add(i+1);
				}
			}
				
				//냄새 없는 곳부터 스캔
				int nextDir = s.findNextDir(noSmellSet);
				if(nextDir == 0) {
					nextDir = s.findNextDir(mySmellSet);
				}
				//상어 이동 
				map[s.x][s.y] = 0; 
				if(nextDir == 1) {
					s.x -=1;
				}else if(nextDir == 2) {
					s.x +=1;
				}else if(nextDir == 3) {
					s.y -=1; 
				}else if(nextDir == 4) {
					s.y +=1;
				}
				//System.out.println(s.x+" "+s.y);
				if(map[s.x][s.y]== 0 || s.id <map[s.x][s.y]){
					map[s.x][s.y] = s.id;
					s.dir = nextDir;
				}else {
					willRemove.add(s.id);
				}
			}
			while(!willRemove.isEmpty()) {
				sharks.remove(willRemove.poll());
			}
		}
	}

public class BOJ_어른상어 {
    
}
