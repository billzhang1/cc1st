public class Solution2_4 {
	public static void partition(SLinkedList mylist, int x) {
		if (mylist.head == null || mylist.head.next == null)
			return;
		Node leftStart = null;
		Node leftEnd = null;
		Node rightStart = null;
		Node rightEnd = null;
		Node node = mylist.head;
		
		while (node != null) {
			Node next = node.next;
			node.next = null;
			if (node.data < x) {
				if (leftStart == null) {
					leftStart = node;
					leftEnd = node;
				} else {
					leftEnd.next = node;
					leftEnd = node;
				}
			} else {
				if (rightStart == null) {
					rightStart = node;
					rightEnd = node;
				} else {
					rightEnd.next = node;
					rightEnd = node;
				}
			}
			node = next;
		}
		
		if (leftStart == null)
			mylist.head = rightStart;
		if (rightStart == null)
			mylist.head = leftStart;
			
		leftEnd.next = rightStart;
		mylist.head = leftStart;
	}
	
	public static void partition2(SLinkedList mylist, int x) {
		Node node = mylist.head;
		if (node == null || node.next == null)
			return;
		Node leftStart = null;
		Node rightStart = null;
		
		while (node != null) {
			Node next = node.next;
			if (node.data < x) {
				node.next = leftStart;
				leftStart = node;
			} else {
				node.next = rightStart;
				rightStart = node;
			}
			node = next;
		}
		if (leftStart == null)
			mylist.head = rightStart;
		if (rightStart == null)
			mylist.head = leftStart;
			
		Node newHead = leftStart;
		while (leftStart.next != null) {
			leftStart = leftStart.next;
		}
		leftStart.next = rightStart;
		mylist.head = newHead;
		
	}
	
	public static void partitionInList(SLinkedList mylist, int x) {
		if (mylist.head == null || mylist.head.next == null)
			return;
		Node prev = mylist.head;
		Node cur = mylist.head.next;
		Node next = null;
		Node newHead = mylist.head;
		
		while (cur != null) {
			next = cur.next;
			if (cur.data < x) {
				prev.next = cur.next;
				cur.next = newHead;
				newHead = cur;
			} else {
				prev = cur;
			}
			cur = next;
		}
		mylist.head = newHead;
		
	}
	
	public static void main(String[] args) {
		SLinkedList list = new SLinkedList(10);
		list.print();
		partitionInList(list, 10);
		list.print();
	}
}