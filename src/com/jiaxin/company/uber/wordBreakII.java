class Untitled {
	public static void main(String[] args) {
		
	}
	
	public List<String> wordBreakII(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<String>();
		if (isSub(s, wordDict)) {
			HashMap<Integer, ArrayList<String>> hm = new HashMap<Integer, ArrayList<String>>();
			ArrayList<String> zero = new ArrayList<String>();
			zero.add("");
			hm.put(0, zero);
			for (int i = 0; i < s.length(); i++) {
				ArrayList<String> cur = new ArrayList<String>();
				hm.put(i + 1, cur);
				for (int j = 0; j <= i; j++) {
					if (wordDict.contains(s.substring(j, i + 1))) {
						for (String str : hm.get(j)) {
							hm.get(i + 1).add(str + (str.lenth() == 0 ? "" : " ") + s.substring(j, i + 1));
						}
					}
				}
			}
		}
		return hm.get(s.length());
	}
	
	public boolean isSub(String s, Set<String> wordDict) {
		boolean[] isSub = new boolean[s.length() + 1];
		isSub[0] = true;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				isSub[i + 1] = isSub[j] && wordDict.contains(s.substring(j, i + 1));
				if (isSub[i + 1]) {
					break;
				}
			}
		}
		return isSub[s.length()];
	}
}