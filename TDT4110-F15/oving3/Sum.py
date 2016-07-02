import math

#	def summer(n):
#		sum = 0
#		for x in range(n):
#			sum += 1/(math.pow(x+1,2))
#		return sum
#	print(summer(100000))

def summer(n):
	sum = 0
	tol = 0.001
	i = 0
	x = 1/(math.pow(i+1,2))
	while (x > tol) and (i <= n):
		x = 1/(math.pow(i+1,2))
		sum += x
		i += 1
	return sum
print(summer(10000))

print(math.pow(math.pi,2)/6)