def gcd(a,b):
	while b != 0:
		gammel_b = b
		b = a % b
		a = gammel_b
	return a

def reduce_fraction(a,b):
	div = gcd(a,b)
	a /= div
	b /= div
	return a,b

a = 5
b = 10
print("For a = ",a,"; b = ",b," skriver programmet ut ", "\"",reduce_fraction(a, b),"\"", sep="")

a = 4
b = 2
print("For a = ",a,"; b = ",b," skriver programmet ut ", "\"",reduce_fraction(a, b),"\"", sep="")

a = 42
b = 13
print("For a = ",a,"; b = ",b," skriver programmet ut ", "\"",reduce_fraction(a, b),"\"", sep="")