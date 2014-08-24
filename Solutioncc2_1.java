import java.util.HashSet;

public class Solutioncc2_1 {
	//TC is O(n), SC is O(null)
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
	
	public static void main(String[] args) {
		SLinkedList list = new SLinkedList(10);
		list.print();
		removeDup(list);
		list.print();
	}
}