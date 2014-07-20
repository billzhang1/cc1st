public class Solutioncc1_3 {
    public static String sort(String str) {
	char[] content = str.toCharArray();
	java.util.Arrays.sort(content);
	return new String(content);
    }

    public static boolean permutation(String str1, String str2) {
	if (str1.length() != str2.length()) {
	    return false;
	}
	
	return sort(str1).equals(sort(str2));
    }

    public static void main(String[] args) {
	System.out.println(permutation("god", "dog"));
	System.out.println(permutation("saaaacc", "caacaa"));
    }
}
