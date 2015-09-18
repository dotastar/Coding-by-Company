class Untitled {
	public static void main(String[] args) {
		
	}
	
	public List<List<Integer>> subsetII(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		helper(nums, 0, res, list);
		return res;
	}
	
	public void helper(int[] nums, int index, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
		res.add(new ArrayList<Integer>(list));
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			helper(res, list, nums, i + 1);
			while (i < nums.length && nums[i] == nums[i + 1]) {
				i++;
			}
			list.remove(list.size() - 1);
		}
	}
}