def wholeNumber (x):
    try:
        float(x)
        return 1
    except ValueError:
        return 0
def evenNumber(x):
    if x % 2 == 1:
        return 0
    elif x % 2 == 0:
        return 1
def posiNumber(x):
    if x < 0:
        return 0
    elif x > 0:
        return 1
def main():
    tall = int(input("Oppgi tall: "))
    if wholeNumber(tall):
        print("Dette er et heltall.")
    elif not wholeNumber(tall):
        print("Dette er ikke et heltall.")
    if (wholeNumber(tall) & evenNumber(tall)):
        print("Dette er et partall.")
    elif wholeNumber(tall):
        print("Dette er ikke et partall.")
    if posiNumber(tall):
        print("Dette er et positivt tall.")
    elif not posiNumber(tall):
        print("Dette er ikke et positivt tall.")
main()