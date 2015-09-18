//happy number
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<Integer>();
        while (!hs.contains(n)) {
            hs.add(n);
            int sum = getSum(n);
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }
    
    public int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}