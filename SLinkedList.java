import java.util.Random;

public class SLinkedList {
	public Node head;
	
	public SLinkedList(int count) {
		Random rand = new Random();
		head = new Node(rand.nextInt(9) + 1);
		count --;
		Node current = head;
		while (count > 0) {
			Node newNode = new Node(rand.nextInt(9) + 1);
			current.next = newNode;
			current = newNode;
			count --;
		}
	}
	
	public void print() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
}