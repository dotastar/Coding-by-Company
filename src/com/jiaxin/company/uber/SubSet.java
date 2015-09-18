//The number of recursive calls, T(n) satisfies the recurrence T(n) = T(n - 1) + T(n - 2) + ... + T(1) + T(0), which solves to T(n) = O(2^n). Since we spend O(n) time within a call, the time complexity is O(n2^n);
class Untitled {
	public static void main(String[] args) {
		
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		helper(nums, 0, res, list);
		return res;
	}
	
	public void helper(int[] nums, int index, List<List<Integer>> res, List<Integer> list) {
		res.add(new ArrayList<Integer>(list));
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			helper(nums, i + 1, res, list);
			list.remove(list.size() - 1);
		}
	}
}