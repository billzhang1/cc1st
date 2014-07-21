class Solution(object):
	def compressed_size(self, string):
		if not string:
			return "empty string"
		current = string[0]
		count = 0
		new_size = 0
		for c in string:
			if c == current:
				count = count + 1
			else:
				current = c
				new_size += 1 + len(str(count))
				count = 1
		new_size += 1 + len(str(count))	
		return new_size

	def compress(self, string):
		size = self.compressed_size(string)
		if size >= len(string):
			return string 	
		targetstring = ""
		current = string[0]
		count = 0
		for c in string:
			if c == current:
				count = count + 1
			else:
				targetstring += current
				targetstring += str(count)
				count = 1
				current = c
		targetstring += current + str(count)
		return targetstring

s = Solution()
print s.compress("aaabbccbbaa") 
print s.compress("a")
print s.compress("ab")
print s.compress("aa")
