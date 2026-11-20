// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         int n= nums.length;
//         Set<List<Integer>> set= new HashSet<>();

//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 for(int k=j+1;k<n;k++){
//                     for(int l=k+1;l<n;l++){
//                         long sum= (long) nums[i]+nums[j]+nums[k]+nums[l];

//                         if(sum==target){
//                             List<Integer> temp= Arrays.asList(nums[i],nums[j],nums[k],nums[l]);

//                             Collections.sort(temp);
//                             set.add(temp);
//                         }
//                         }
//                     }
//                 }
//             }

//             return new ArrayList<>(set);
//         }
//     }


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n= nums.length;
         Arrays.sort(nums);

        Set<List<Integer>> set= new HashSet<>();
    
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int k= j+1;
                int l= n-1;

                while(k<l){
                    long sum= (long)nums[i]+nums[j]+nums[k]+nums[l];

                    if(sum==target){
                        set.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));

                        k++;
                        l--;
                    }

                    else if(sum<target){
                        k++;
                    }

                    else{
                         l--;
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }}