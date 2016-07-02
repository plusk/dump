op = input("+, -, * eller / ?: ")
a = int(input("Skriv inn en verdi for a: "))
b = int(input("Skriv inn en verdi for b: "))
def pluss(a,b):
    sum = a+b
    return sum
def minus(a,b):
    sum = a-b
    return sum
def gange(a,b):
    sum = a*b
    return sum
def dele(a,b):
    sum = a/b
    return sum

if op == "+":
    sum = pluss(a,b)
elif op == "-":
    sum = minus(a,b)
elif op == "*":
    sum = gange(a,b)
elif op == "/":
    sum = dele(a,b)
print(a, op, b, "er lik:", sum)