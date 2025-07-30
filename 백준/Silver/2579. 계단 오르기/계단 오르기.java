import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            bw.write("0");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        int[] stair = new int[n];
        for (int i = 0; i < n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n];
        dp[0] = stair[0];
        if (n == 1) {
            bw.write(Integer.toString(stair[0]));
        }
        else if (n == 2) {
            bw.write(Integer.toString(stair[0] + stair[1]));
        } else {
            dp[1] = Math.max(stair[1], stair[0] + stair[1]);
            dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i]);
            }
            bw.write(Integer.toString(dp[n-1]));
        }
        
        bw.flush();
        bw.close();
        br.close();
        
        
        
        
    }
}