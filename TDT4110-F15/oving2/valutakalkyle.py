kroner = (int(input("Hvor mange kroner vil du veksle inn? ")))
valuta = (input("EURO, GBP, eller RUB?: "))
sted = (input("BANK eller FLYPLASS?: "))
tid =  (input("NÅ eller SENERE?: "))

#gjør til uppercase for sikkerhetsskyld
valuta = valuta.upper()
sted = sted.upper()
tid = tid.upper()

if tid == "NÅ":
    if valuta == "EURO":
        kon = 8.7
    elif valuta == "GBP":
        kon = 11.9
    elif valuta == "RUB":
        kon = 0.14
    stedMult = 0.9
elif tid == "SENERE":
    if valuta == "EURO":
        kon = 9.1
    elif valuta == "GBP":
        kon = 12.5
    elif valuta == "RUB":
        kon = 0.15
    stedMult = 0.95
sum = kroner*kon*stedMult
print("Du får", sum, valuta)