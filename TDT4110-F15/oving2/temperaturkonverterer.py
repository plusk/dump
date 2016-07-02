def convert(fahr):
    cels=(fahr-32)/1.8
    return cels
print(convert(int(input("Skriv inn antall fahrenheit grader: "))))