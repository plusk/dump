def separate(numbers, threshold):
	under = []
	over = []
	for x in numbers:
		if x < threshold:
			under.append(x)
		elif x >= threshold:
			over.append(x)
	return under, over
print(separate([0,9,1,8,2,7,3,6,4,5], 5))

def multiplication_table(n):
	matrise = []
	for x in range(n):
		rad = []
		for y in range(1, n+1):
			rad.append(y*(x+1)
		matrise.append(rad)
		print(x)
	return matrise
print(multiplication_table(3))