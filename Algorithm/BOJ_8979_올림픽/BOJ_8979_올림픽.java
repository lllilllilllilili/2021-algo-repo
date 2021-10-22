import java.util.*;
import java.io.*;
public class Main {

	static class Info implements Comparable<Info>{
		int country;
		int gold;
		int silver;
		int bronze;
		int rate;
		Info(int country, int gold, int silver, int bronze, int rate){
			this.country = country;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.rate = rate;
		}
		@Override
		public int compareTo(Info info) {
			if(this.gold == info.gold) {
				if(this.silver == info.silver) {
					
					return info.bronze - this.bronze;
				}
				return info.silver - this.silver;
			}
			return info.gold - this.gold;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Info> al = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int countryNumber = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			al.add(new Info(countryNumber, gold, silver, bronze, Integer.MAX_VALUE));
		}//end of for loop
		Collections.sort(al);
		int answer = 0;
		al.get(0).rate = 1;
		for(int i=1; i<al.size(); i++) {
			int tempCn = al.get(i-1).country;
			int tempGl = al.get(i-1).gold;
			int tempSlv = al.get(i-1).silver;
			int tempBon = al.get(i-1).bronze;
			Info now = al.get(i);
			if(al.get(i).country == K) {
				answer = i;
			}
			if(now.gold == tempGl &&
			   now.silver == tempSlv &&
			   now.bronze == tempBon
					) {
				al.get(i).rate = al.get(i-1).rate;
			}else {
				al.get(i).rate = i+1;
			}
		}//end of for loop
		System.out.println(al.get(answer).rate);
	}
}
