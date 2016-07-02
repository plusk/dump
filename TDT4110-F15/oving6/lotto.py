import random

numbers = list(range(1, 35))
myGuess = [1, 2, 3, 4, 5, 6, 7]

def trekk(n):
	global numbers
	trukket = []
	for x in range(n):
		trukket.append(numbers.pop(random.randint(0, len(numbers)-1)))
	return trukket

def compList(li1, li2):
	like = 0
	for x in range(len(li1)):
		for y in range(len(li2)):
			if li1[x] == li2[y]:
				like += 1
	return like

def premie(like, tilike):
	premie = 0
	if like == 7:
		premie = 2749455
	elif like == 6 and tilike == 1:
		premie = 102110
	elif like == 6:
		premie = 3385
	elif like == 5:
		premie = 95
	elif like == 4 and tilike == 1:
		premie = 45
	return premie

def main():	
	corGuess = trekk(7)

	like = compList(myGuess, corGuess)

	tilliste = trekk(3)
	tilike = compList(myGuess, tilliste)

	print(premie(like, tilike))
	print("Antall like:", like)
	print("Antall tilike:", tilike)
main()

penger = 0
for x in range(1000000):
	numbers = list(range(1, 35))
	myGuess = [1, 2, 3, 4, 5, 6, 7]
	corGuess = trekk(7)
	like = compList(myGuess, corGuess)
	tilliste = trekk(3)
	tilike = compList(myGuess, tilliste)
	penger += premie(like, tilike)
	penger -= 5
	print(premie(like, tilike))
print(penger)