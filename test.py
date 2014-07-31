from __future__ import print_function

def getIndex(x, y, width):
	return x + y * width

def printMatrix(matrix, m, n):
	"""
	Print Matrix row by row
	"""
	for i in range(m*n):
		print(matrix[i], end="\t")
		if((i + 1) % n == 0):
			print()

def findZero(matrix, m, n):
	"""
	Find all zeros in the matrix, and mark down the index
	"""
	zeroIndex = list()
	for x in range(n):
		for y in range(m):
			if(matrix[getIndex(x, y, n)] == 0):				
				zeroIndex.append((x, y))
	print("zero indeces:")
	for pair in zeroIndex:
		print(pair)
		matrix = setZero(matrix, pair[0], pair[1], m, n)
	return matrix

def setZero(matrix, x, y, m, n):
	"""
	Set the entire row and column to zero
	If the element in (x, y) is zero
	"""
	for index in range(m):
		matrix[getIndex(x, index, n)] = 0
	for index in range(n):
		matrix[getIndex(index, y, n)] = 0
	return matrix


m = 5
n = 4
matrix = list(range(m*n))
matrix[6] = 0
print("Before setZero:")
printMatrix(matrix, m, n)
matrix = findZero(matrix, m, n)
print("After setZero:")
printMatrix(matrix, m, n)
