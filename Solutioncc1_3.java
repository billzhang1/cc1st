import java.util.Arrays;
public class Solutioncc1_3 {
    public static String sort(String str) {
	char[] content = str.toCharArray();
	java.util.Arrays.sort(content);
	return new String(content);
    }

    //TC is 
    public static boolean permutation(String str1, String str2) {
	if (str1.length() != str2.length()) {
	    return false;
	}
	
	return sort(str1).equals(sort(str2));
    }

// TC is O(n), SC is O(n)
    public static boolean permutation2(String str1, String str2) {
	if (str1.length() != str2.length()) {
	    return false;
	}

	int[] letters = new int[256];
	char[] str1array = str1.toCharArray();

	for(char c : str1array) {
	    letters[c] ++;
	}

	for(char c : str2.toCharArray()) {
	    if (--letters[c] < 0) {
		return false;	
	    }
	}
	return true;
    }

    public static void main(String[] args) {
	System.out.println(permutation2("god", "dog"));
	System.out.println(permutation2("saaaacc", "acaacaa"));
	char[] test1 = new char[3];
    }
}
