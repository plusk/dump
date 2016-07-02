def lagbrett():
    li = []
    for a in range(3):
        li.append([])
        for b in range(3):
            li[a].append("-")
    return li
li = lagbrett()

def printbrett(li):
    first = "    "
    sep = "  +---+---+---+"

    for x in range(1, 4):
        first += str(x)
        first += "   "
    print(first)

    for y in range(1, 4):
        print(sep)

        row = str(y)
        row += " "

        for z in range(len(li[y-1])):
            row += "| "
            row += str(li[y-1][z])
            row += " "
        row += "|"

        print(row)
    print(sep)


def tanavn():
    brukeren = input("Skriv inn navnet til bruker nr. 1: ")
    brukerto = input("Skriv inn navnet til bruker nr. 2: ")
    #hvorfor

    return brukeren, brukerto

def lovlig():
    if li[row][col] == "-":
        return True
    else:
        return False

def gyldig():
    if (0 <= row <= 2) and (0 <= col <= 2):
        if(val == "x" or val == "o"):
            return True
    else:
        return False

brukeren, brukerto = tanavn()
turn = True
while True:
    printbrett(li)
    if turn:
        val = "x"
        curbruker = brukeren
    else:
        val = "o"
        curbruker = brukerto
    print(curbruker, "sin tur.")
    userinput = input("Skriv inn rad og kolonne: ")
    nums = userinput.split(',')
    row = int(nums[0]) - 1
    col = int(nums[1]) - 1
    if (lovlig() and gyldig()):
        li[row][col] = val
        turn = not turn