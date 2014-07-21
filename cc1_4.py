class Solution(object):
	# TC is O(n), SC is O(n)
	# does not perform this operation in place as object string in Python is immutable
	def replacespace(self, str):
		str_list = str.split()
		str = "%20".join(str_list)
		return str

s = Solution()
print s.replacespace("Hello World, my name is Bill!")
