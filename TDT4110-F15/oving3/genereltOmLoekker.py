def summerTall(a, b):
	sum = 0
	for x in range(a, b+1):
		sum += x
	return sum
print(summerTall(1,100))

def multTall():
	sum = 1
	x = 1
	while sum < 1000:
		sum *= x
		x += 1
		print(sum)
multTall()

def spmSpam():
	korrekt = False
	while korrekt == False:
		fasit = 4
		svar = int(input("Hva er 2+2? "))
		if svar == fasit:
			korrekt = True
spmSpam()