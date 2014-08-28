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

"""

"""
def partition(node, x):
	#TC is O(n), SC is O(n)
	if node == None or node.next == None: #If there is only one node there is no point in doing partition
		return node
	left_start = None
	left_end = None
	right_start = None
	right_end = None
	
	while node != None:
		next = node.next #because node is manipulated in while loop
		node.next = None #
		if node.data < x:
			if left_start == None:
				left_start = node
				left_end = node
			else:
				left_end.next = node
				left_end = node
		else:
			if right_start == None:
				right_start = node
				right_end = node
			else:
				right_end.next = node
				right_end = node
		node = next
	
	if left_start == None:
		return right_start
	
	if right_start == None:
		return left_start
		
	left_end.next = right_start
	return left_start
	
def partition2(node, x):
	#TC is O(n), SC is O(n)
	if node == None or node.next == None:
		return node
	left_start = None
	right_start = None
	
	while node != None:
		next = node.next
		#node.next = None
		if node.data < x:
			node.next = left_start
			left_start = node
		else:
			node.next = right_start
			right_start = node
		node = next
	
	if left_start == None:
		return right_start

	if right_start == None:
		return left_start
		
	head = left_start
	while left_start.next != None:
		left_start = left_start.next
		
	left_start.next = right_start
	return head
	
def partition_in_list(head, x):
	#TC is O(n), SC is O(1)
	if head == None or head.next == None:
		return head
	prev = head
	cur = head.next
	next = None
	new_head = head
	
	while cur != None:
		next = cur.next
		if cur.data < x:
			prev.next = cur.next
			cur.next = new_head
			new_head = cur
		else:
			prev = cur
		cur = next
	return new_head
			
	
list_head = linkedlist_generator(10)
print "original list: "
linkedlist_printer(list_head)
d = 49
print "d is %d" % d
print "after partition"
new_head = partition_in_list(list_head, d)
linkedlist_printer(new_head)
