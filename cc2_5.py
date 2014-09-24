import random

class Node(object):
	def __init__(self, data = None):
		self.data = data
		self.next = None


class IntWrapper(object):
	def __init__(self):
		self.value = 0


def linkedlist_generator(count):
	random.seed()
	head = Node(random.randint(0, 9))
	count -= 1
	current = head
	while count > 0:
		new_node = Node(random.randint(0, 9))
		current.next = new_node
		current = new_node
		count -= 1
	return head
	
def linkedlist_printer(node):
	while node:
		print node.data,
		node = node.next
	print

def add_lists(l1, l2, carry = 0):
	#TC is O(M+N), SC is O(max(M,N))
	if l1 == None and l2 == None and carry == 0:
		return None
		
	result = Node(0)
	
	value = carry
	if l1 != None:
		value += l1.data
	if l2 != None:
		value += l2.data
		
	result.data = value % 10
	
	if l1 != None or l2 != None:
		l1 = None if l1 == None else l1.next
		l2 = None if l2 == None else l2.next
		value = 1 if value >= 10 else 0
		more = add_lists(l1, l2, value)
		result.next = more
		
	return result
		
	
	
l1_head = linkedlist_generator(3)
l2_head = linkedlist_generator(3)
print "original list: "
linkedlist_printer(l1_head)
linkedlist_printer(l2_head)
print "sum:"
new_head = add_lists(l1_head, l2_head)
linkedlist_printer(new_head)
