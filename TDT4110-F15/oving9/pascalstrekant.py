def pascalsTrekant(n):
	li = []
	for x in range(n):
		li.append([])
		z = 0
		for y in range(x+1):
			if not y:
				li[x].append(1)
			elif y < x:
				li[x].append(li[x-1][z] + li[x-1][z+1])
				z += 1
			elif y == x:
				li[x].append(1)
		print("Linje:",x,"- Innhold:", li[x])
	return li
def pascalsPolynom(n, li):
	utvidet = ""
	for a in range(n+1):
		segment = ""
		ba = li[n][a]
		if (ba != 1):
			segment += str(ba)
		if not not(n-a):
			if (n-a != 1):
				segment += str("y^"+str(n-a))
			else:
				segment += str("y")
		if (n-a != 0 and a != 0):
			segment += "*"
		if not not(a):
			if (a != 1):
				segment += str("x^"+str(a))
			else:
				segment += str("x")
		utvidet += "(" + segment + ")"
		if (a != n):
			utvidet += " + "
	full = "(y+x)^" + str(n) + " = " + utvidet
	return full
print(pascalsPolynom(7, pascalsTrekant(8)))