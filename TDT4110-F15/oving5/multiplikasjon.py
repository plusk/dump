import math

def mult():
	itr = 1
	tol = 0.01
	sum = 2
	sumny = 2

	while True: 
		sumny = sum * (1+(1/math.pow(itr+1, 2)))
		
		if (sumny - sum) < tol:
			break

		sum = sumny

		itr += 1
	print(itr)
mult()

def antimult(n):
	if n == 0 or (1+(1/math.pow(n, 2))) < 1.01:
		return 1
	else:
		return ((1+(1/math.pow(n, 2))) * antimult(n-1))
print(antimult(5))