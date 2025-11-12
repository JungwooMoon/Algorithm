import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        for (int i = 1; i <= n/2; i++) {
            int e = i + 1;
            int sum = i;
            while (sum <= n) {
                if (sum == n) cnt++;
                sum += e;
                e++;
            }
        }
        
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}