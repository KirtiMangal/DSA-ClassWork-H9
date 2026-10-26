class Solution {
    public int removeDuplicates(int[] nums) {
        int n= nums.length;
        HashSet<Integer> set= new HashSet<>();

        int i=0;
        for(int j=0;j<n;j++){
            if(set.add(nums[j])){
                nums[i]=nums[j];

                i++;
            }
        }

        return i;
    }
}