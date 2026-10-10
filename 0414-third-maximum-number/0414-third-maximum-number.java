class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        if (list.size() < 3) {
            return list.get(0);
        }

        return list.get(2);
    }
}
