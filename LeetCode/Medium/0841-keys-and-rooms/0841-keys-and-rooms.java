class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
				//✅ 각 방의 방문 여부를 기록할 리스트를 선언한다.
        boolean[] visited = new boolean[rooms.size()];
        BFS(rooms, visited, 0);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    public void BFS(List<List<Integer>> rooms, boolean[] visited, int start) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        //int count = 0;
        queue.offer(start);
        visited[start] = true;
        //count++;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for (int room : rooms.get(current)) {
                if (!visited[room]) {
                    queue.offer(room);
                    visited[room] = true;
                    //count++;
                }
            }        
        }
        //return count;
    }
}
