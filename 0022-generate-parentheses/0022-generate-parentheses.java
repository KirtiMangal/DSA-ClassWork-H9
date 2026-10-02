class Solution {
    public void generate(List<String> result,int max,int open,int close, String unprocessed){
        if(unprocessed.length()==(2*max)){
            result.add(unprocessed);
            return;
        }

        if(open<max){
            generate(result,max,open+1,close,unprocessed+"(");
        }

        if(close<open){
            generate(result,max,open,close+1,unprocessed+")");
        }
    }

    
    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList<String>();
        generate(result,n,0,0,"");
        return result;
        
    }
}