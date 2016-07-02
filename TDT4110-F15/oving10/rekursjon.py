#hæ

import math

def reksum(n): #FIKS DEN DRITTEN
	tot = 0
	for x in range(1, n+1):
		tot += x
	return tot
	if x < n:
		return reksum(n-1)

	if n == 0:

print(reksum(4))

def rekmin(li): #FIKS DEN DRITTEN
	li.sort()
	return li[0]
print(rekmin([9,7,4,7,8,2,4,6,4,5,3]))

def sin(x):
	tol = 0.01
	if (x < tol):
		return x
	else:
		return 3*sin(x/3) - 4*math.pow(sin(x/3), 3)
print(sin(0.1))