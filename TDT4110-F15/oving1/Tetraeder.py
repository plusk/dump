import math

h = int(input("Skriv inn høyden her: "))
a = h * 3/math.sqrt(6)
oa = math.sqrt(3)*pow(a, 2)
v = math.sqrt(2)*pow(a, 3)/12

print("Overflatearealet til et tetraeder med høyde", h, "=", oa)
print("Volumet til et tetraeder med høyde", h, "=", v)
