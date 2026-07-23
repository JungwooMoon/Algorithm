class Solution {
    public String solution(String new_id) {
        String step1 = new_id.toLowerCase(); 
        String step2 = "";
        for(int i = 0; i < step1.length(); i++) {
            if (step1.charAt(i) >= 'a' && step1.charAt(i) <= 'z') {
                step2 += step1.charAt(i);
            }
            
            if (step1.charAt(i) >= '0' && step1.charAt(i) <= '9') {
                step2 += step1.charAt(i);
            }
            
            if (step1.charAt(i) == '-' || step1.charAt(i) == '_' || step1.charAt(i) == '.') {
                step2 += step1.charAt(i);
            }
        }
        
        String step3 = "";
        int cnt = 0;
        for (int i = 0; i < step2.length(); i++) {
            if (step2.charAt(i) == '.' && cnt == 0) {
                step3 += step2.charAt(i);
                cnt++;
            }
            
            if (step2.charAt(i) != '.') {
                step3 += step2.charAt(i);
                cnt = 0;
            }
        }
        
        String step4 = step3;
        
        if (step4.startsWith(".")) {
            step4 = step4.substring(1, step4.length());
        }
        
        if (step4.endsWith(".")) {
            step4 = step4.substring(0, step4.length()-1);
        }
        
        String step5 = step4;
        
        if(step5.length() == 0) {
            step5 += 'a';
        }
        
        String step6 = step5;
        
        if (step6.length() > 15) {
            step6 = step6.substring(0, 15);
        }
        
        if (step6.endsWith(".")) {
            step6 = step6.substring(0, step6.length()-1);
        }
        
        String answer = step6;
        
        if (answer.length() <= 2) {
            while(answer.length() < 3) {
                answer += answer.charAt(answer.length()-1);
            }
        }
        
        
        return answer;
    }
}