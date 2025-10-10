import java.util.*;

class Solution {

    HashSet<String> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        bt(user_id, banned_id, new boolean[user_id.length], 0);
        return set.size();
    }
    
    public void bt(String[] user_id, String[] banned_id, boolean[] visited_user, int cnt) {
        
        
        if (cnt == banned_id.length) {
            
            List<String> temp = new ArrayList<>();
            
            for (int i = 0; i < user_id.length; i++) {
                if (visited_user[i]) {
                    temp.add(user_id[i]);
                }
            }
            Collections.sort(temp);
            String ids = String.join(",", temp);
            set.add(ids);
            return; 
        }
        
        for (int i = 0; i < user_id.length; i++) {
            String user = user_id[i];
            if (!visited_user[i]) {
                
                String ban = banned_id[cnt];
                
                if (user.length() != ban.length()) continue;
                boolean pass = true;
                for (int k = 0; k < ban.length(); k++) {
                    if (ban.charAt(k) != '*' && ban.charAt(k) != user.charAt(k)) {
                        pass = false;
                        break;
                    }
                }

                if (pass) {
                    visited_user[i] = true;
                    bt(user_id, banned_id, visited_user, cnt + 1);
                    visited_user[i] = false;
                }
                
            }
        }
    }
}