import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		st = new StringTokenizer(br.readLine());
		int[] min = new int[4];
		for (int i = 0; i < 4; i++) {
			min[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		String cur = s.substring(0, p);
		int[] cur_min = new int[4];
		for (int j = 0; j < p; j++) {
			if (cur.charAt(j) == 'A') cur_min[0]++;
			if (cur.charAt(j) == 'C') cur_min[1]++;
			if (cur.charAt(j) == 'G') cur_min[2]++;
			if (cur.charAt(j) == 'T') cur_min[3]++;
		}
		if (cur_min[0] >= min[0] && cur_min[1] >= min[1] && cur_min[2] >= min[2] && cur_min[3] >= min[3]) {
			cnt++;
		}
		int prev = 0;
		for (int i = p; i < s.length(); i++) {
			if (s.charAt(prev) == 'A') cur_min[0]--;
			if (s.charAt(prev) == 'C') cur_min[1]--;
			if (s.charAt(prev) == 'G') cur_min[2]--;
			if (s.charAt(prev) == 'T') cur_min[3]--;

			if (s.charAt(i) == 'A') cur_min[0]++;
			if (s.charAt(i) == 'C') cur_min[1]++;
			if (s.charAt(i) == 'G') cur_min[2]++;
			if (s.charAt(i) == 'T') cur_min[3]++;

			if (cur_min[0] >= min[0] && cur_min[1] >= min[1] && cur_min[2] >= min[2] && cur_min[3] >= min[3]) {
				cnt++;
			}

			prev++;
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		br.close();
		bw.close();
	}
}