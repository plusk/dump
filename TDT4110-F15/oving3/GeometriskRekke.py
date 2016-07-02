import math

#	def summer(r, n):
#		return (1-math.pow(r,n+1))/(1-r)

def summer(r,n):
	x = 0
	sum = 0
	tol = 0.001
	grense = (1)/(1-r)
	while (x <= n) & (sum + tol < grense):
		sum += math.pow(r,x)
		x += 1
	print("Antall iterasjoner:", x)
	print("Differanse mellom sum og grenseverdi:", grense - sum)
	return sum
print(summer(0.5,10000))
