// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         int n= nums.length;
//         Arrays.sort(nums);

//         for(int i=0;i<n-1;i++){
//             if(nums[i]==nums[i+1]){
//                 return true;
//             }
//         }

//         return false;
//     }
// }

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n= nums.length;
        Set<Integer> set= new HashSet<>();

        for(int i=0;i<n;i++){
        if(set.contains(nums[i])){
            return true;
        }

        set.add(nums[i]);
    }

    return false;
}}