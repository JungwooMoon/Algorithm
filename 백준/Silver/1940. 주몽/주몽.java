import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int s = 0;
        int e = n-1;
        int cnt = 0;
        
        while(s != e) {
            int sum = arr[s] + arr[e];
            if (sum == m) {
                cnt++;
                e--;
            } else if (sum > m) {
                e--;
            } else {
                s++;
            }
        }
        
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}