def les():
	f = open("poenggrenser.csv", "r")
	streng = f.read()
	f.close()
	return streng
streng = les()

liste = streng.split("\n")

nyli = []

for x in range(len(liste)-1):
	nyli.append(liste[x].split(","))

def tellalle(li):
	n = 0
	for x in li:
		if (x[1] == "\"Alle\""):
			n += 1
	return n
print(tellalle(nyli))

def finnsnitt(li):
	n = 0
	tot = 0
	for x in li:
		if not(x[1] == "\"Alle\""):
			n += 1
			tot += float(x[1])
	snitt = tot / n
	return snitt
print(finnsnitt(nyli))

def finnbunn(li):
	bunn = 0
	for x in li:
		if not(x[1] == "\"Alle\""):
			ny = float(x[1])
			if (ny < bunn):
				bunn = ny
			elif bunn !=:
				bunn = ny
	return bunn
print(finnbunn(nyli))