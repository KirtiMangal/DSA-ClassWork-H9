class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list= new ArrayList<>();

        while(head!=null){
            list.add(head.val);
            head= head.next;
        }

        int left=0;
        int right= list.size()-1;

        while(left<right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}