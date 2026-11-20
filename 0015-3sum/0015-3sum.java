// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         int n= nums.length;
//         Set<List<Integer>> set= new HashSet<>();
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 for(int k=j+1;k<n;k++){
//                     if(nums[i]+nums[j]+nums[k]==0){
//                         List<Integer> temp= Arrays.asList(nums[i],nums[j],nums[k]);

//                         Collections.sort(temp);

//                         set.add(temp);
//                     }
//                 }
//             }
//         }

//         return new ArrayList<>(set);
//     }
// }

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> set= new HashSet<>();
        for(int i=0;i<n;i++){
            int j= i+1;
            int k= n-1;

            while(j<k){
                int sum= nums[i]+nums[j]+nums[k];

                if(sum==0){
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));

                    j++;
                    k--;
                }

                else if(sum<0){
                    j++;
                }

                else{
                    k--;
                }
            }
        }

        return new ArrayList<>(set);

    }}