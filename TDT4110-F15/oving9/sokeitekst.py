import re

def les():
	f = open("bibel.txt", "r")
	streng = f.read()
	f.close()
	return streng

def fjern(streng):
	streng = streng.lower()
	streng = re.sub("[^a-z +]", "", streng)
	streng = re.sub(" +", " ", streng)
	return streng

def tell(streng): #antall forekomster av ALLE ord
	li = streng.split()
	dic = {}
	for x in li:
		if x in dic:
			dic[x] += 1
		else:
			dic[x] = 1
	return dic

def antall(dic, word):
	return dic[word]
print(antall(tell(fjern(les())), "genesis"))