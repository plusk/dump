import math

a = int(input("Oppgi en a-verdi: "))
b = int(input("Oppgi en b-verdi: "))
c = int(input("Oppgi en c-verdi: "))
d = pow(b, 2) - 2*a*c

print(d)

if d < 0:
        print ("Ligningen 2x*x + 4x + 9 = 0 har to imaginære løsninger.")
elif d > 0:
        print ("Ligningen 2x*x + 4x + 9 = 0 har to reelle løsninger.")
elif d == 0:
        print ("Ligningen 2x*x + 4x + 9 = 0 har én reell dobbeltrot.")