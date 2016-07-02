poeng = int(input("Hvor mange poeng fikk du? "))

if poeng > 100 | poeng < 0:
    print("Feilmelding: Utenfor skalaen.")

elif poeng <= 100 & poeng >= 89:
    print("A")

elif poeng >= 77:
    print("B")

elif poeng >= 65:
    print("C")

elif poeng >= 53:
    print("D")

elif poeng >= 41:
    print("E")

elif poeng >= 0:
    print("F")
