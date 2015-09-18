public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n<k){return result;}
        helper(result, res, n, k, 1);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> res, int n, int k, int start){
        if(res.size()==k){
            result.add(new ArrayList<Integer>(res));
            return;
        } else {
            for(int i=start;i<=n;i++){
                res.add(i);
                helper(result, res, n, k, i+1);
                res.remove(res.size()-1);
            }
        }
        
    }
}