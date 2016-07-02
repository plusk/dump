import math

def delelig(a,b):
	if not(a%b):
		return True
	else:
		return False

def isprime(a,b):
	for i in range(3, round(math.sqrt(a)+0.5), 2):
		if delelig(a,b):
			return 0
	return 1

def nyprim(a):
	f = open("primlist.txt", "r")
	prim = [2]
	gamprim = f.read()
	prim = list(map(int, gamprim.split(",")))
	f.close()
	for x in range(len(prim)):
		if (isprime(a,prim[x])):
			prim.append(a)
			f = open("primlist.txt", "a")
			f.write(","+str(a))
			f.close()
			break
nyprim(3) # ser ut til å akseptere alle tall