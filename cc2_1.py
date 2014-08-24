import random

class Node(object):
	def __init__(self, data = None):
		self.data = data
		self.next = None

def linkedlist_generator(count):
	random.seed()
	head = Node(random.randint(1, 10))
	count -= 1
	current = head
	while count > 0:
		new_node = Node(random.randint(1, 10))
		current.next = new_node
		current = new_node
		count -= 1
	return head
	
def linkedlist_printer(node):
	while node:
		print node.data,
		node = node.next
	print
	
def duplicate_remover(head):
	test_set = set([])
	test_set.add(head.data)
	prev = head
	current = head.next

	while current:
		if current.data not in test_set:
			test_set.add(current.data)
			prev = current
		else:
			prev.next = current.next
		current = current.next
	return head
	
list_a = linkedlist_generator(10)
print ("before deletion: ")
linkedlist_printer(list_a)
print ("after deletion: ")
list_a = duplicate_remover(list_a)
linkedlist_printer(list_a)

	
	
	
