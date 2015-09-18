class Untitled {
	public static void main(String[] args) {
		
	}
	
	public ArrayList<String> anagrams(String[] str) {
		ArrayList<String> res = new ArrayList<String>();
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < str.length; i++) {
			String temp = sorted(str[i]);
			ArrayList<String> val = hm.get(temp);
			if (val != null) {
				val.add(str[i]);
			} else {
				val = new ArrayList<String>();
				val.add(str[i]);
				hm.put(temp, val);
			}
		}
		Set<String> hset = hm.keySet();
		for (String s : hset) {
			ArrayList<String> val = hm.get(s);
			if (val.size() > 1) {
				res.addAll(val);
			}
		}
		return res;
	}
	
	public String sorted(String s) {
		char[] sorts = s.toCharArray();
		Arrays.sort(sorts);
		return new String(sorts);
	}
}