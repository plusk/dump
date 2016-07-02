import math

def numint(N, a, b):
	h = (b-a)/N
	sum = 0
	for i in range(N+1):
		sum += math.sin(i*h+(h/2)+a)
	return sum
print(numint(100, 0, math.pi))

def trapes():
	h = (b-a)/N
	for i in range(1, N+1):
		pass

#def simpsons():