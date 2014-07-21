import java.util.Arrays;
public class Solutioncc1_4 {
	//TC is O(n), SC is O(n)
	public static char[] replacespace(char[] str) {
		int length = str.length;
		int new_length = 0;
		int space_num_count = 0, i;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				space_num_count ++;
			}
		} 
		
		new_length = length + 2 * space_num_count;
		char[] newstr = new char[new_length];
		//str[new_length] = '\0';
		
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				newstr[new_length - 1] = '0';
				newstr[new_length - 2] = '2';
				newstr[new_length - 3] = '%';
				new_length -= 3;
			} else {
				newstr[new_length - 1] = str[i];
				new_length -= 1;
			}
		}
		return newstr;
	}

	public static void main(String[] args) {
		String str = "Hello World Bill !  ";
		char[] s = str.toCharArray();
		System.out.println(Arrays.toString(replacespace(s)));
	}
}
