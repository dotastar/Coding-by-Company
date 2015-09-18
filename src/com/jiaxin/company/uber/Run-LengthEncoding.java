//Run-Length Encoding
class Untitled {
	public static void main(String[] args) {
		
	}
	
	public String compress(String s) {
		int size = countS(s);
		if (size >= s.length()) {
			return s;
		}
		char[] str = new char[size];
		int index = 0;
		char last = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == last) {
				count++;
			} else {
				index = setChar(str, last, index, count);
				last = s.charAt(i);
				count = 1;
			}
		}
		index = setChar(str, last, index, count);
		return String.valueOf(str);
	}
	
	public int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index++;
		char[] cnt = String.valueOf(count).toCharArray();
		for (char x : cnt) {
			array[index] = x;
			index++;
		}
		return index;
	}
	
	public int countS(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char last = s.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == last) {
				count++;
			} else {
				last = s.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
}