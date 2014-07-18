class Solution(object):
    def uniquechar(self, string):
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

s = Solution()
print s.uniquechar("q")
