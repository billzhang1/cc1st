def circular_list_generator():
	a = Node('A')
	b = Node('B')
	c = Node('C')
	d = Node('D')
	e = Node('E')
	f = Node('F')
	g = Node('G')
	h = Node('H')
	
	a.next = b
	b.next = c
	c.next = d
	d.next = e
	e.next = f
	f.next = g
	g.next = h
	h.next = c
	
	return a

def linkedlist_printer(node):
	while node:
		print node.data,
		node = node.next
	print

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
	
def list_length(node):
	if node == None:
		return 0
	count = 0
	while node:
		count += 1
		node = node.next
	return count


class Node(object):
	def __init__(self, data = None, next = None):
		self.data = data
		self.next = next
		

