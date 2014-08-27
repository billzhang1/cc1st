public class Solution2_2 {
	
	public static Node kthToLastRecursive(Node head, int k, IntWrapper i) {
		if (k < 1)
			return null;
		if (head == null)
			return null;
		
		Node node = kthToLastRecursive(head.next, k, i);
		i.value += 1;
		if (i.value == k)
			return head;
		return node;
	}
	
	public static Node kthToLastRunner(Node head, int k) {
		if (k < 1)
			return null;
		Node p1 = head;
		Node p2 = head;
		
		for (int i = 0; i < k - 1; i ++) {
			if (p2 == null)
				return null;
			p2 = p2.next;
		}
		
		if (p2 == null)
			return null;
			
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	public static void main(String[] args) {
		SLinkedList list = new SLinkedList(10);
		list.print();
		IntWrapper i = new IntWrapper();
		int k = 2;
		Node node = kthToLastRecursive(list.head, k, i);
		if (node != null)
			System.out.printf("k is %d, kthToLast Node is %d\n", k, node.data);
		else
			System.out.println("node is null, wrong!");
	}
}

class IntWrapper {
	public int value = 0;
}