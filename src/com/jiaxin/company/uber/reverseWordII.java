class Untitled {
	public static void main(String[] args) {
		
	}
	
	public String reverseII(String s) {
		char[] str = s.toCharArray();
		reverse(str, 0, str.length);
		for (int i = 0, j = 0; i < str.length; i++) {
			if (j == str.length || s[j] == ' ') {
				reverse(str, j, i);
				j = i + 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char a : str) {
			sb.append(a);
		}
		return sb.toString();
	}
	
	public void reverse(char[] str, int start, int end) {
		while (start < end) {
			char temp = char[start];
			char[start] = char[end];
			char[end] = temp;
			start++;
			end--;
		}
	}
}