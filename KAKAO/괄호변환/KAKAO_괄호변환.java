import java.util.*;

class Solution {
    // 올바른 괄호인지 체크
    boolean isCorrect(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (st.size() == 0 || st.peek() == ')' || (st.peek() == '(' && s.charAt(i) == '(')) {
                st.push(s.charAt(i));
            } else {
                st.pop();
            }
        } // end of for loop

        if (st.isEmpty())
            return true;
        else
            return false;
    }

    // 균형잡힌 괄호인지 체크
    boolean isBalanced(String s) {

        int cha = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')')
                cha += 1;
            else if (s.charAt(i) == '(')
                cha -= 1;
        }
        if (cha == 0)
            return true;
        else
            return false;
    }

    public String solution(String p) {
        String answer = "";
        // 빈문자열, 올바른 괄호 문자열이면 리턴한다.
        if (p.length() == 0 || isCorrect(p))
            return p;
        // #u가 균형잡힌 괄호 문자열이 될 때까지 2개씩 추가해서 u,v 나누기

        String u = "";
        String v = "";

        for (int i = 2; i <= p.length(); i++) {

            if (isBalanced(p.substring(0, i))) {
                u = p.substring(0, i);
                v = p.substring(i, p.length());
                break;
            }
        }

        // 올바른 괄호 문자열이거나
        if (isCorrect(u)) {
            answer += u + solution(v);
        }
        // 올바른 괄호 문자열이 아니거나
        else {
            answer += ('(' + solution(v) + ')');
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == ')')
                    answer += '(';
                else if (u.charAt(i) == '(')
                    answer += ')';
            }
        }
        return answer;
    }
}