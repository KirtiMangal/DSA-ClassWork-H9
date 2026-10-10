class Solution {
    public int thirdMax(int[] nums) {
        int n= nums.length;
        TreeSet<Integer> set= new TreeSet<>();

        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        if(set.size()<3){
            return set.last();
        }

        set.pollLast();
        set.pollLast();

        return set.last();
    }
}