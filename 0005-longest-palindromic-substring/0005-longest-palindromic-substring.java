class Solution {
    public String longestPalindrome(String s) {
        int n= s.length();
        String longest= "";

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String sub= s.substring(i,j+1);

                if(isPallindrome(sub) && sub.length()>longest.length()){
                    longest= sub;
                }
            }
        }

        return longest;
    }

        public boolean isPallindrome(String s){
            int n= s.length();
            int left=0;
            int right= n-1;

            while(left<right){
                if(s.charAt(left)!=s.charAt(right)){
                    return false;
                }

                left++;
                right--;
            }

            return true;
    }
}