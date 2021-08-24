import java.util.*;

class Solution {
    static String secToStr(int n){
        String ret = "";
        int s = n%60; n/=60;
        int m = n%60; n/=60;
        int h = n;
        
        if(h<10) ret+="0";
        ret+=Integer.toString(h);
        ret+=":";
        
        if(m<10) ret+="0";
        ret+=Integer.toString(m);
        ret+=":";
        
        if(s<10) ret+="0";
        ret+=Integer.toString(s);
        
        return ret;
    }
    static int strToSec(String n){
        int ret = 0;
        String h = n.substring(0,2);
        String m = n.substring(3,5);
        String s = n.substring(6,8);
       
        ret+=Integer.parseInt(h)*60*60;
        ret+=Integer.parseInt(m)*60;
        ret+=Integer.parseInt(s);
        
        return ret;
    }
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int[] adv = new int[360000];
        for(int i=0; i<logs.length; i++){
            int start = strToSec(logs[i].substring(0,8));
            int finish = strToSec(logs[i].substring(9,17));
            for(int j=start; j<finish; j++){
                adv[j]+=1;
            }
        }
        
        int N = strToSec(play_time); //play_time
        int len = strToSec(adv_time); //adv_time
        
        int idx = 0;
        long sum = 0;
        long maxSum = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<len; i++){
            sum+=adv[i];
            q.add(adv[i]);
        }
        
        maxSum = sum;
        
        for(int i=len; i<N; i++){
            sum += adv[i];
            q.add(adv[i]);
            sum-=q.peek();
            q.poll();
            if(sum>maxSum){
                idx = i-len+1;
                maxSum = sum;
            }
        }
        
        answer = secToStr(idx);
        
        return answer;
    }
}