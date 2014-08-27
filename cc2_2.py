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
	
def kth_to_last_recursive(head, k, i):
	#TC O(n^2), SC O(n)
	if k <= 0:
		return None
	if head == None:
		return None
	
	node = kth_to_last_recursive(head.next, k, i)
	i.value += 1
	
	if i.value == k:
		return head
	return node

def kth_to_last_runner(head, k):
	#TC O(n), SC O(1)
	if k < 0:
		return None
	p1 = head
	p2 = head
	for i in range(k-1):
		if p2 == None:
			return None
		p2 = p2.next
	if p2 == None:
		return None
	
	while p2.next:
		p1 = p1.next
		p2 = p2.next
		
	return p1

	
list_a = linkedlist_generator(10)
print "original list: "
linkedlist_printer(list_a)
#i = IntWrapper()
k = 11
print "k is: %d" % k
#node = kth_to_last_recursive(list_a, k, i)
node = kth_to_last_runner(list_a, k)
print "print kth value to the last element: "
linkedlist_printer(node)

	
	
	
