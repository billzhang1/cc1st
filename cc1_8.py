class Solution(object):
	def isRotation(self, s1, s2):
		newString = s1 + s2
		if (s2 in newString and len(s1) == len(s2) and len(s1) > 0):
			return True
		else:
			return False
			
			
s = Solution()
a = "waterbottle"
b = "erbottlewab"
c = ""
print s.isRotation(c, c)