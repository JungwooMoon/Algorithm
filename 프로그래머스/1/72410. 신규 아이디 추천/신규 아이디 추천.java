class Solution {
    public String solution(String new_id) {
        String answer = "";
        String lower_id = new_id.toLowerCase();
        String second = "";
        
        for (int i = 0; i < lower_id.length(); i++) {
            if ((lower_id.charAt(i) >= 'a' && lower_id.charAt(i) <= 'z') || (lower_id.charAt(i) >= '0' && lower_id.charAt(i) <= '9') || lower_id.charAt(i) == '-' || lower_id.charAt(i) == '_' || lower_id.charAt(i) == '.') {
      second += lower_id.charAt(i);     
            } 
        }
        
        String third = "";
        
        for (int i = 0; i < second.length(); i++) {
            if (second.charAt(i) == '.') {
                third += second.charAt(i);
                while (i + 1 < second.length() && second.charAt(i+1) == '.') {
                    i++;
                } 
            } else {
                third += second.charAt(i);
            }
        }
        
        String remove_start = third;
        
        if (remove_start.startsWith(".")) {
            remove_start = remove_start.substring(1);
        }
        
        if (remove_start.endsWith(".")) {
            remove_start = remove_start.substring(0, remove_start.length()-1);
        } 
        
        if (remove_start.equals("")) {
            answer = "a";
        } else {
            answer = remove_start;
        }
        
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15); 
        }
        
        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }
        
        while(answer.length() <= 2) {
            answer += answer.charAt(answer.length()-1);
        }
        
        return answer;
    }
}