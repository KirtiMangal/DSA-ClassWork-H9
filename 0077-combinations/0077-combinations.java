class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k, new ArrayList<>());
        return res;
    }

    void dfs(int start, int n, int k, List<Integer> curr) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= n; i++) {
            curr.add(i);

            dfs(i + 1, n, k, curr);
            curr.remove(curr.size() - 1);
        }
    }
}