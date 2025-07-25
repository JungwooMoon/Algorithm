import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<Integer>());
		}
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < 2 * n; j += 2) {
				if (line.charAt(j) == '1') {
					graph.get(i).add(j / 2);
				}
			}
		}

		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bw.write(Integer.toString(isPossible(graph, i, j, n)));
                bw.write(" ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}

	static int isPossible(Map<Integer, List<Integer>> graph, int i, int j, int n) {
		boolean[][] visited = new boolean[n][n];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(i);
		int cnt = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if (cnt != 0 && cur == j) return 1;

			for (int next : graph.get(cur)) {
				if (!visited[cur][next]) {
					queue.offer(next);
					visited[cur][next] = true;
				}
			}
			cnt = 1;
		}

		return 0;

	}
}