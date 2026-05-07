class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1; i < s.length()/2+1; i++) {
            String prev = s.substring(0, i);
            String min = prev;
            int cnt = 1;
            for (int j = i; j < s.length(); j+=i) {
                if (j+i > s.length()) {
                    if (cnt > 1) {
                        min += Integer.toString(cnt);
                    }
                    
                    min += s.substring(j, s.length());
                    break;
                }
                
                if (prev.equals(s.substring(j, j+i))) {
                    cnt++;
                    if (j+i >= s.length()) {
                        min += Integer.toString(cnt); 
                    }
                    
                } else {
                    if (cnt != 1) {
                        min += Integer.toString(cnt);    
                    }
                    cnt = 1;
                    prev = s.substring(j, j+i);
                    min += prev;
                } 
            }
            
            
            answer = Math.min(min.length(), answer);
        }
        
        return answer;
    }
}