import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] arr1 = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			arr1[i] = arr[i];
		}
        boolean test = true;
		Arrays.sort(arr1);
		Deque<Integer> queue = new ArrayDeque<>();
		int i1 = 0;
		for (int i = 0; i < n; i++) {
			if (i1 == n) {
				if (queue.isEmpty()) {
					test = false;
                    break;
				} else {
					int cur = queue.pop();
					if (arr[i] == cur) {
						sb.append("-\n");
						continue;
					} else {
						test = false;
					}
				}
			} else if (arr[i] > arr1[i1]) {
				boolean test2 = false;
				while (i1 < n) {
					if (arr[i] < arr1[i1]) {
						test2 = false;
						break;
					}
					if (arr[i] == arr1[i1]) {
						sb.append("+\n");
						sb.append("-\n");
						test2 = true;
						i1++;
						break;
					}
					queue.push(arr1[i1]);
					sb.append("+\n");
					i1++;
				}
				if (!test2) {
					test = false;
					break;
				}
			} else if (arr[i] < arr1[i1]) {
				if (!queue.isEmpty()) {
					int cur = queue.pop();
					if (arr[i] == cur) {
						sb.append("-\n");
					} else {
						test = false;
						break;
					}
				} else {
					test = false;
					break;
				}
			} else if (arr[i] == arr1[i1]) {
				sb.append("+\n");
				sb.append("-\n");
				i1++;
			}
		}
        if (test) {
            bw.write(sb.toString());    
        } else {
            bw.write("NO");
        }
		bw.flush();
		bw.close();
		br.close();

	}
}