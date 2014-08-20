/* 
N = (s1+s1).length, M=s2.length, concatenation takes O(N) time
Depends on the time complexity of isSubstring function:
Boyer-Moore: O(MN) worse, O(N/M) on average
*/
public class Solution1_8 {
	public boolean isRotation(String s1, String s2) {
		int len = s1.length();
		if (len == s2.length() && len > 0) {
			String ss1 = s1 + s2;
			return isSubstring(ss1, s2);
		}
		return false;
	}
}

// https://gist.github.com/chrislukkk/779f7943a04cbb903575
//for isSubstring90 function can be implemented by Boyer-Moore algorithm