import random

def lirandom(length, a, b):
	li = []
	for x in range(length):
		li.append(random.randint(a,b))
	return li
#print(lirandom(5, 0, 9))

# Ikke en del av oppgaven, lager en liste av tilfeldige lister for lifelles
def lilist(length):
	li = []
	for x in range(length):
		li.append(lirandom(5, 0, 9))
	return li
li = lilist(5)
#print(li)

def lifelles(li):
	fellesli = []
	klar = True
	for x in range(len(li)):
		for y in range(len(li[x])):
			for z in range(len(fellesli)):
				if (li[x][y] == fellesli[z]):
					klar = False
					break
				else:
					klar = True
			if klar:
				fellesli.append(li[x][y])
	return fellesli
#print(lifelles(li))

def liparrekke(li):
	curind = 0
	curlen = 0
	topind = 0
	toplen = 0
	for x in range(len(li)):
		if not(li[x] % 2):
			if curlen == 0:
				curind = x
			curlen += 1
		else:			
			if toplen < curlen or toplen == 0:
				topind = curind
				toplen = curlen
			curind = 0
			curlen = 0
	if toplen < curlen or toplen == 0:
		topind = curind
		toplen = curlen
	if toplen == 0:
		return "Det var ingen partall i listen."
	return topind, toplen
print(liparrekke([1,2,1,2,2,1]))