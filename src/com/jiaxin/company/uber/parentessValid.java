//Print all permutations of 3 pair of parens. ()()(), (()()), (())(),,,. et
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        String item = new String();
        if (n <= 0) {
            return res;
        }
        generate(res, item, n, n);
        return res;
    }
    
    public void generate(List<String> res, String item, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(new String(item));
        }
        if (left > 0) {
            generate(res, item + "(", left - 1, right);
        } 
        if (right > 0) {
            generate(res, item + ")", left, right - 1);
        }
    }
}