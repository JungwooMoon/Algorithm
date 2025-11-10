import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        double max = 0.0;
        
        for (int x : arr) {
            max = max > x ? max : x;
        }
        
        double sum = 0.0;
        
        for (int x : arr) {
            sum += x / max * 100.0;
        }
        
        bw.write(sum/n + "\n");
        bw.flush();
        bw.close();
    }
}