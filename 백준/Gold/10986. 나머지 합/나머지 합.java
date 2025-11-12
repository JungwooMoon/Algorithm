import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n+1];
        long[] div = new long[m];
        long cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            long val = Long.parseLong(st.nextToken());
            arr[i] = arr[i-1] + val;
            int remainder = (int) (arr[i] % m);
            if (remainder == 0) cnt++;
            div[remainder] = div[remainder] + 1;
        }
        
        for (int i = 0; i < m; i++) {
            if (div[i] > 1) {
                cnt += div[i] * (div[i]-1) / 2;
            }
        }
        
        
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}