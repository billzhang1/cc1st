import java.util.Stack;

public class S2_7 {
	private class Result {
		boolean checkres;
		Node node;
		
		public Result(boolean checkres, Node node) {
			this.checkres = checkres;
			this.node = node;
		}
	}
	
	public int listLength(Node node) {
		if (node == null)
			return 0;
		int count = 0;
		while (node != null) {
			count += 1;
			node = node.next;
		}
		
		return count;	
	}
	
	public boolean checkPalindrome(Node head) {
		Node slow = head;
		Node fast = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast != null) {
			slow = slow.next;
		}
		
		while (slow != null) {
			int top = stack.pop().intValue();
			
			if (top != slow.data)
				return false;
			slow = slow.next;
		}
		return true;
	}
	
	public Result checkPalindromeRecursive(Node head, int length) {
		if (head == null || length == 0)
			return new Result(true, null);
		else if (length == 1)
			return new Result(true, head.next);
		else if (length == 2)
			return new Result(head.data == head.next.data, head.next.next);
			
		Result res = checkPalindromeRecursive(head.next, length - 2);
		
		if (!res.checkres || res.node == null)
			return res;
		else {
			res.checkres = head.data == res.node.data;
			res.node = res.node.next;
			return res;
		}
	}
	
	public boolean checkPalindrome2(Node head) {
		Result res = checkPalindromeRecursive(head, listLength(head));
		return res.checkres;
	}
	
	public static void main(String[] args) {
		S2_7 a = new S2_7();
		Node pa1 = new Node(0, new Node(1, new Node(2, new Node(1, new Node(0, null)))));
		System.out.println(a.checkPalindrome(pa1));
		Node pa2 = new Node(0, new Node(1, new Node(1, new Node(0, null))));
		System.out.println(a.checkPalindrome(pa2)+"\n");
		System.out.println(a.checkPalindrome2(pa1));
		System.out.println(a.checkPalindrome2(pa2));
	}
}