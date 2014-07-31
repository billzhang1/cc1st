public class Solutioncc1_5 {
	//TC is O(n^2), SC is O(n^2)
	public static String compress(String original_str) {
		char current = original_str.charAt(0);
		int count = 1;
		String target_str = "";
		for (int i = 1; i < original_str.length(); i ++) {
			if (current == original_str.charAt(i)) {
				count ++;
			} else {
				target_str += current + "" + count;
				current = original_str.charAt(i);
				count = 1;
			}
		}
		return target_str + current + count;
	}
	
	//try to implement StringBuffer in java, http://stackoverflow.com/questions/7156122/what-is-the-complexity-of-this-simple-piece-of-code
	public static int compressed_size(String original_str) {
		if (original_str == null || original_str.isEmpty()) {
			return 0;
		}
		char current = original_str.charAt(0);
		int size = 0;
		int count = 1;
		for(int i = 1; i < original_str.length(); i ++) {
			if (current == original_str.charAt(i)) {
				count ++;
			} else {
				size += 1 + String.valueOf(count).length();
				current = original_str.charAt(i);
				count = 1;
			}
		}
		return size + 1 + String.valueOf(count).length();
	}

	public static String compress2(String original_str) {
		int size = compressed_size(original_str);
		if (size >= original_str.length()) {
			return original_str;
		} 

		StringBuffer s = new StringBuffer();
		char current = original_str.charAt(0);
		int count = 1;
		
		for (int i = 1; i < original_str.length(); i ++) {
			if (current == original_str.charAt(i)) {
				count ++;
			} else {
				s.append(current);
				s.append(count);
				current = original_str.charAt(i);
				count = 1;
			}
		}
		s.append(current);
		s.append(count);
		return s.toString();
	}

	public static int setArray(char[] array, int index, char current, int count) {
		array[index] = current;
		index ++;

		char[] count_array = String.valueOf(count).toCharArray();
		for (char c : count_array) {
			array[index] = c;
			index ++;
		}
		return index;
	}	

	//TC is O(n), SC is O(n)
	public static String compress3(String original_str) {
		int size = compressed_size(original_str);
		if ( size >= original_str.length()){
			return original_str;
		} 
		
		char[] array = new char[size];
		int index= 0;
		char current = original_str.charAt(0);
		int count = 1;

		for (int i = 1; i < original_str.length(); i ++) {
			if (current == original_str.charAt(i)) {
				count ++;
			} else {
				index = setArray(array, index, current, count);
				current = original_str.charAt(i);
				count = 1;
			}
		}
		index = setArray(array, index, current, count);
		return String.valueOf(array);
	}
	
	public static void main(String[] args) {
		System.out.println(compress3("aabbccdddbb"));
		System.out.println(compress3("a"));
		System.out.println(compress3("ab"));
		System.out.println(compress3("aa"));
	}
}
