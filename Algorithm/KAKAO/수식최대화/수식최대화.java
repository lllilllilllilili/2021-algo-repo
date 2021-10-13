class Solution {
    public long solution(String expression) {
        long answer = Long.MIN_VALUE;
        String[][] pri = { { "*", "-", "+" }, { "*", "+", "-" }, { "+", "*", "-" }, { "+", "-", "*" },
                { "-", "*", "+" }, { "-", "+", "*" } };

        for (int i = 0; i < pri.length; i++) {
            long k = DFS(0, pri[i], expression);
            answer = Math.max(answer, Math.abs(k));
        }
        return answer;
    }

    static long DFS(int n, String[] pri, String expression) {
        if (n == 2) {
            long sum = 0;
            if (pri[n].equals("*")) {
                String[] temp = expression.split("\\*");
                sum = Long.parseLong(temp[0]);
                for (int i = 1; i < temp.length; i++) {
                    sum *= Long.parseLong(temp[i]);
                }
            } else if (pri[n].equals("-")) {
                String[] temp = expression.split("-");
                sum = Long.parseLong(temp[0]);
                for (int i = 1; i < temp.length; i++) {
                    sum -= Long.parseLong(temp[i]);
                }
            } else if (pri[n].equals("+")) {
                String[] temp = expression.split("\\+");
                sum = Long.parseLong(temp[0]);
                for (int i = 1; i < temp.length; i++) {
                    sum += Long.parseLong(temp[i]);
                }
            }
            return sum;
        }
        long sum = 0;
        if (pri[n].equals("*")) {
            String[] temp = expression.split("\\*");
            sum = (DFS(n + 1, pri, temp[0]));
            for (int i = 1; i < temp.length; i++) {
                sum *= (DFS(n + 1, pri, temp[i]));
            }
        } else if (pri[n].equals("-")) {
            String[] temp = expression.split("-");
            sum = (DFS(n + 1, pri, temp[0]));
            for (int i = 1; i < temp.length; i++) {
                sum -= (DFS(n + 1, pri, temp[i]));
            }
        } else if (pri[n].equals("+")) {
            String[] temp = expression.split("\\+");
            sum = (DFS(n + 1, pri, temp[0]));
            for (int i = 1; i < temp.length; i++) {
                sum += (DFS(n + 1, pri, temp[i]));
            }
        }
        return sum;
    }
}