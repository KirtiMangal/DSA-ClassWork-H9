// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n= nums.length;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(nums[i]+nums[j]==target){
//                     int[] a={i,j};
//                     return a;
//                 }
//             }
//         }

//         return null;
//     }
// }

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n= nums.length;
        Map<Integer,Integer> map= new HashMap<>();

        for(int i=0;i<n;i++){
            int required= target-nums[i];

            if(map.containsKey(required)){
                return new int[]{map.get(required),i};
            }

            map.put(nums[i],i);
        }

        return new int[]{};
    }}