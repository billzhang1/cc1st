public class Solution2_5 {
	public static Node addLists(Node n1, Node n2, int carry) {
		//TC is O(M+N), SC is O(max(M,N))
		if (n1 == null & n2 == null & carry == 0) {
			return null;
		}
		
		Node result = new Node(0);
		
		int value = carry;
		if (n1 != null) {
			value += n1.data;
		}
		if (n2 != null) {
			value += n2.data;
		}
		
		result.data = value % 10;
		
		if (n1 != null || n2 != null) {
			Node more = addLists(n1 == null ? null : n1.next,
			                     n2 == null ? null : n2.next,
			                     value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}
	
	public static Node followUp(Node l1, Node l2) {
		//the reverse is in place. TC is O(M+N), SC is O(max(M,N))
		if (l1 == null || l2 == null)
			return null;
		l1 = reverse(l1);
		l2 = reverse(l2);
		Node sum = addLists(l1, l2, 0);
		return reverse(sum);
	}
	
	public static void print(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static Node reverse(Node node) {
		Node tail = null;
		Node next = node.next;
		while (next != null) {
			node.next = tail;
			tail = node;
			node = next;
			next = node.next;
		}
		node.next = tail;
		return node;
	}
	
	public static void main(String[] args) {
		SLinkedList l1 = new SLinkedList(3);
		SLinkedList l2 = new SLinkedList(4);
		l1.print();
		l2.print();
		Node sum = addLists(l1.head, l2.head, 0);
		print(sum);
		Node sum2 = followUp(l1.head, l2.head);
		print(sum2);
	}
}