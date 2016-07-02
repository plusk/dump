mynter = [20, 10, 10, 5, 5, 5, 1, 1, 1, 1]

def countCoins(mynter):
	antall = [0, 0, 0, 0]
	for x in range(len(mynter)):
		if mynter[x] == 1:
			antall[3] += 1
		elif mynter[x] == 5:
			antall[2] += 1
		elif mynter[x] == 10:
			antall[1] += 1
		elif mynter[x] == 20:
			antall[0] += 1
	return antall
print(countCoins(mynter))

liste = [12,23,34,45,56,67,78,89,90,98,87,65,54,43,21]
def numCoins(li):
	totantall = []
	antall = [0, 0, 0, 0]
	for x in range(len(li)):
		antall = [0, 0, 0, 0]
		while li[x] > 0:
			if li[x] > 20:
				li[x] -= 20
				antall[0] += 1
			elif li[x] >=  10:
				li[x] -= 10
				antall[1] += 1
			elif li[x] >= 5:
				li[x] -= 5
				antall[2] += 1
			elif li[x] >= 1:
				li[x] -= 1
				antall[3] += 1
		totantall.append(antall)
	return totantall
totalmynt = numCoins(liste)
print(totalmynt)

# SPOER STUDASS OM DETTE
#		print(liste)
# SPOER STUDASS OM DETTE

def weighCoins(tot):
	totalvekt = 0
	for x in tot:
		vekt = x[0]*9.9 + x[1]*6.8 + x[2]*7.85 + x[3]*4.35
		totalvekt += vekt
	return totalvekt
print(weighCoins(totalmynt))