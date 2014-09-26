from list_common import Node
from list_common import list_length

class Result(object):
	def __init__(self, checkres = False, node = None):
		self.checkres = checkres
		self.node = node

def check_palindrome(head):
	# TC is O(n), SC is O(n)
	slow = head
	fast = head
	stack = []
	
	#when odd nodes, fast.next==null. when even, fast == null
	while fast != None and fast.next != None:
		stack.append(slow)
		slow = slow.next
		fast = fast.next.next
	
	if fast != None:
		slow = slow.next
		
	while slow != None:
		top = stack.pop()
		if slow.data != top.data:
			return False
		slow = slow.next
	return True
	
def check_palindrome_recursive(head, length):
	#
	#TC is O(n), SC is O(n).-recursion depth
	#If we use recursion, we can avoid using additional data structure, 
	#however, we still use the system stack. That's using space O(N) too
	#
	if head == None or length == 0:
		return Result(True, None)
	elif length == 1:
		return Result(True, head.next)
	elif length == 2:
		return Result(head.data == head.next.data, head.next.next)
		
	result = check_palindrome_recursive(head.next, length - 2)
	
	if not result.checkres or result.node == None:
		return result
	else:
		result.checkres = head.data == result.node.data
		result.node = result.node.next
		return result

def	check_palindrome2(head):
	result = check_palindrome_recursive(head, list_length(head))
	return result.checkres


pa1 = Node('a', Node('b', Node('c', Node('b', Node('a')))))
print check_palindrome(pa1)
pa2 = Node('a', Node('b', Node('c', Node('c', Node('b', Node('a'))))))
print check_palindrome(pa2)
pa3 = Node('b', Node('b', Node('a')))
pa4 = Node('b')
print check_palindrome(pa3)
print
print check_palindrome2(pa1)
print check_palindrome2(pa2)
print check_palindrome2(pa3)
print check_palindrome2(pa4)



	
		
	
	