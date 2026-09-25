class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int n= candidates.length;
        
        List<List<Integer>> result= new ArrayList<>();
        backtrack(0,candidates,target, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int idx, int[] candidates, int target, List<Integer> current, List<List<Integer>> result){
        int n= candidates.length;

        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }

        if(idx==n || target<0){
            return;
        }

        current.add(candidates[idx]);
        backtrack(idx,candidates,target-candidates[idx],current,result);

        current.remove(current.size()-1);
        backtrack(idx+1,candidates,target,current,result);

    }
}