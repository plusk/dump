import math

def sumSerie(heltall):
	sum = 0
	n = 1
	while (n <= heltall):
		if (sum + math.pow(n,2) > heltall):
			sum -= math.pow(n, 2)
			print("Resultat med n =",heltall,":",sum)
			print("Antall ledd:",n)
			break
		if (n % 2 == 0):
			sum -= math.pow(n, 2)
		elif (n % 2 == 1):
			sum += math.pow(n, 2)
		n += 1
	return sum
print(sumSerie(12))