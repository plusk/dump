#x = 2
#y = input (’Skriv inn et tall ")
#    z = x // y
#print (z)

# x og y er variabler, x = 2 og y = det brukeren skriver inn
# z er lik x delt på y med heltallsdivisjon

# Feil 1, linje 2 mangler ordentlig anførselstegn rundt string
# Feil 2, linje 3 har unødvendig innrykk
# Feil 3, linje 2 henter string input, men man må ha integer for at linje 3 skal fungere

# "Rettet" kode
x = 2
y = int(input("Skriv inn et tall: "))
z = x // y
print (z)

print()

a = 2
b = 3
if (b<a or not b%a):
    b = a+b
else:
    a = a*b 
print("a: ",a)
print("b: ",b)
# møter ikke kriteriene til if-setning, går inn i else, a = 6 og b = 3

print()

def tilfeldigListe(inputTall):
    import random
    liste = [0 for index in range(inputTall)]

    for index in range(inputTall):
        liste[index] = random.randint(0,10)

    return liste

def sorterListe(liste):
    return sorted(liste)

inputTall = int(input("Skriv inn et tall: "))
print(sorterListe(tilfeldigListe(inputTall)))
#inputTall sier hvor mange tall det skal være i listen
#hvert tall i listen blir et tilfeldig tall mellom 0 og 10
#sorterListe sorterer tallene i stigende rekkefølge