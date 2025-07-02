class Solution {


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, 1, n, new ArrayList<>(), k);
        return ans;
    }

    void dfs (List<List<Integer>> ans, int s, int n, List<Integer> cur, int k) {
        if (cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = s; i <= n; i++) {
            cur.add(i);
            dfs(ans, i+1, n, cur, k);
            cur.remove(cur.size()-1);
        }
    }
}