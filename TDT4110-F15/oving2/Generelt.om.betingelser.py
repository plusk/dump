a = 5
print("Verdien til a er:", a)
b = int(input("Skriv inn en verdi for b: "))

if (a*b) > (a+b):
    print("a*b er større enn a+b.")
elif (a*b) < (a+b):
    print("a+b er større enn a*b.")
else:
    print("a*b og a+b er like store? Dette burde være umulig.")
    
c = 3*4
d = int(input("Hva er 3*4? "))

if c == d:
    print("Korrekt.")
else:
    print("Inkorrekt.")