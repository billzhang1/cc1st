public class S2_6 {
	public static Node findLoopStart(Node head) {
		Node slow = head;
		Node fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		
		if (fast == null || fast.next == null)
			return null;
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
	
	public static void main(String[] args) {
		CirLinkedList cList = new CirLinkedList();
		Node startPoint = findLoopStart(cList.head);
		System.out.println(startPoint.data);
	}
}