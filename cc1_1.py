class Solution(object):
# time complexity is O(nlog(n)), space comp is O(1)
    def uniquechar1(self, string):
        if string == '':
            return True

        string = sorted(string)
        prev = string[0]

        for char in string[1:]:
            if char == prev:
                return False

            prev = char

        else:
            return True
	
    def uniquechar2(self, string):
#tc is O(n), sc is O(1)
	boolean_list = []
	for i in range(256):
	    boolean_list.append(True)
	for char in string:
	    if(boolean_list[ord(char)]):
		boolean_list[ord(char)] = False
	    else:
		return False
	return True	

s = Solution()
print s.uniquechar1("q")
print s.uniquechar1("")
print s.uniquechar1("qqqqaaasq")
print s.uniquechar1("aldwocfq")
print s.uniquechar2("qqqqqqqqqqqqqq")
