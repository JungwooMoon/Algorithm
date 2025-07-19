class Solution {
    public int solution(String s) {
        int test = 1;
        int answer = s.length() + 1;
        while (test <= s.length()) {
            String val = "";
            String temp = "";
            int cnt = 1;
            for(int i = 0; i < s.length(); i += test) {
                String cur;
                if (i+test >= s.length()) {
                    cur = s.substring(i);
                } else {
                    cur = s.substring(i, i+test);
                }
                
                if (cur.equals(temp)) {
                    cnt++;
                } else if (!cur.equals(temp)) {
                    if (cnt > 1) {
                        val += Integer.toString(cnt);
                    }
                    val += cur;
                    cnt = 1;
                } 
                
                temp = cur;
            }
            if (cnt > 1) {
                val += Integer.toString(cnt);
            }
            test++;
            answer = Math.min(answer, val.length());
        }
        return answer;
    }
}