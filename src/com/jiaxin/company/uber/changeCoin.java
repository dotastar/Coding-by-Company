//换硬币那题
class Untitled {
	public static void main(String[] args) {
		
	}
	
	public int changeCoin(int n) {
		int[] coins = {1, 5, 10, 25};
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[n];
	}
}