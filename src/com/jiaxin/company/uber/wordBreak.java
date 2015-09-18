//https://leetcode.com/problems/word-break/
//isSub[i]是表示到字符串s的第i个元素为止能不能用字典中的词来表示
//O(n^2)
class Untitled {
	public static void main(String[] args) {
		
	}
	
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] isSub = new boolean[s.length() + 1];
		isSub[0] = true;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				isSub[i + 1] = isSub[i] && wordDict.contains(s.substring(j, i + 1));
				if (isSub[i + 1]) {
					break;
				}
			}
		}
		return isSub[s.length()];
	}
}