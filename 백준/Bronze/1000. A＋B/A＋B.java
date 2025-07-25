import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int sum = a + b;
        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void main(String[] args) throws IOException {
        solution();
    }
}