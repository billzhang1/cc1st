from list_common import circular_list_generator
from list_common import linkedlist_printer

def find_loopstart(head):
	#TC is O(N), SC is O(1)
	slow = head
	fast = head
	
	while fast != None and fast.next != None:
		slow = slow.next
		fast = fast.next.next
		if slow == fast:
			break
	
	if fast == None or fast.next == None:
		return "Not a loop"
	
	slow = head
	while slow != fast:
		slow = slow.next
		fast = fast.next
	
	return fast.data

cir_list = circular_list_generator()
startpoint = find_loopstart(cir_list)
print startpoint
