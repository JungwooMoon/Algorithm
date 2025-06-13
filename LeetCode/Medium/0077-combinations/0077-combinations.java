class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans, new ArrayList<>(), 1, n, k);
        return ans;
    }

    void backTrack(List<List<Integer>> ans, List<Integer> cur, int start, int n, int k) {
        if (cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            backTrack(ans, cur, i+1, n, k);
            cur.remove(cur.size() - 1);
        }
    }
}