
import java.util.*;
import java.io.*;

public class BOJ_1541_잃어버린괄호 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        ArrayList<Integer> number = new ArrayList<>();
        ArrayList<Integer> cmd = new ArrayList<>();
        int cur = 0;
        cmd.add(1);
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '-' || line.charAt(i) == '+') {
                if (line.charAt(i) == '-') {
                    cmd.add(-1);
                } else {
                    cmd.add(1);
                }
                number.add(cur);
                cur = 0;
            } else {
                cur = cur * 10 + (line.charAt(i) - '0');
            }
        } // end of for loop

        int answer = 0;
        number.add(cur);
        boolean minus = false;
        for (int i = 0; i < number.size(); i++) {
            if (cmd.get(i) == -1) {
                minus = true;
            }
            if (minus)
                answer -= number.get(i);
            else
                answer += number.get(i);
        }
        System.out.println(answer);
    }
}
