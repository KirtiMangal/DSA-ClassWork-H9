class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n= nums.length;

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[n];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        int n= nums.length;
        
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {

            if (used[i]) {
                continue;
            }

            if (set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);

            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, used, current, result);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}