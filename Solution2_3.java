public class Solution2_3 {
	public static boolean deleteNode(Node node) {
		if (node == null) 
			return false;
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
		return true;
	}
	
	public static void main(String[] args) {
		SLinkedList list = new SLinkedList(10);
		list.print();
		Node n = list.head.next.next;
		System.out.printf("delete: %d\n", n.data);
		boolean result = deleteNode(n);
		if (result)
			list.print();
		else
			System.out.println("Wrong operation!");
		
	}
}