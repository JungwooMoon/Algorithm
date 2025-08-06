import java.io.*;
import java.util.*;

class Main {
    static boolean found;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<Integer, List<Integer>> graph = new HashMap<>();
        String basic = br.readLine();
		String[] parts = basic.split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			String line = br.readLine();
			
            String[] edge = line.split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
		}
         for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(graph, i, 1, visited);
            if (found) break;
        }
        if (found) {
                bw.write("1");
            } else {
                bw.write("0");
            }
            bw.flush();
		    bw.close();
		    br.close();
    }
        
    static void dfs(Map<Integer, List<Integer>> graph, int node, int depth, boolean[] visited) {
        if (depth == 5) {
            found = true;
            return;
        }

        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(graph, next, depth + 1, visited);
            }
        }
        visited[node] = false; 
 
    }
}