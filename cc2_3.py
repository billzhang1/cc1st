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
	head = Node(random.randint(1, 100))
	count -= 1
	current = head
	while count > 0:
		new_node = Node(random.randint(1, 100))
		current.next = new_node
		current = new_node
		count -= 1
	return head
	
def linkedlist_printer(node):
	while node:
		print node.data,
		node = node.next
	print
	
def delete_node(node):
	#TC is O(1), SC is O(1)
	if not node:
		return False
	temp = node.next
	node.data = temp.data
	node.next = temp.next
	return True

	
list_head = linkedlist_generator(10)
print "original list: "
linkedlist_printer(list_head)
n = list_head.next.next
print "delete %d" % n.data
result = delete_node(n)
if result:
	print "list after deletion is ",
	linkedlist_printer(list_head)
else:
	print "Wrong operation!"
