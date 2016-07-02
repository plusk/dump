import math
h = pow(int(input("Skriv inn et tall: ")), int(input("Skriv inn en eksponent: ")))
x = float(input("Skriv inn en x-verdi: "))
f1 = math.sin(x)
f2 = math.sin(x + h)

der = (f2 - f1)/h

print("Den deriverte er:", format(der))
