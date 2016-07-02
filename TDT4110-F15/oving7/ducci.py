import math

num = [10,8,12,15,5,7,43,21]

def ducci(num):
	sekvens = []
	x = 0
	while x < len(num):
		if x == len(num)-1:
			sekvens.append(math.fabs(num[x]-num[0]))
		else:
			sekvens.append(math.fabs(num[x]-num[x+1]))
		x += 1
	return sekvens
print(ducci(num))