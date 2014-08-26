import java.util.HashSet;

public class Solutioncc2_1 {
	//TC is O(n), SC is O(n)
	public static void removeDup(SLinkedList mylist) {
		if (mylist == null || mylist.head == null)
			return;
		HashSet<Integer> newSet = new HashSet<Integer>();
		newSet.add(mylist.head.data);
		Node prev = mylist.head;
		Node cur = mylist.head.next;
		
		while (cur != null) {
			if (newSet.contains(cur.data)) {
				prev.next = cur.next;
			} else {
				newSet.add(cur.data);
				prev = cur;
			}
			cur = cur.next;
		}
	}
	
	public static void removeNobufferDup(SLinkedList mylist) {
		//TC is O(n), SC is O(1)
		if (mylist == null || mylist.head == null)
			return;
		Node current = mylist.head;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		SLinkedList list = new SLinkedList(10);
		list.print();
		//removeDup(list);
		removeNobufferDup(list);
		list.print();
	}
}