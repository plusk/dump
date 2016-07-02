import pickle

def generate():
    li = []
    for a in range(9):
        li.append([])
        for b in range(9):
            li[a].append(0)
    return li

def output(li):
    first = "    "
    sep = "  +-------+-------+-------+"

    for c in range(1, 10):
        if(c%3 == 0):
            first += str(c)
            first += "   "
        else:
            first += str(c)
            first += " "
    print(first)

    for d in range(1, 10):
        if((d - 1) % 3 == 0):
            print(sep)

        row = str(d)
        row += " "

        for e in range(len(li[d-1])):
            if(e % 3 == 0):
                row += "| "
            row += str(li[d-1][e])
            row += " "
        row += "|"

        print(row)
    print(sep)

def inrow():
    if val in li[row]:
        print("That value is already in the row.")
        return True
    else:
        return False
def incol():
    for f in range(len(li)):
        if val == li[f][col]:
            print("That value is already in the column.")
            return True
    return False
def inbox():
    if (row <= 2):
        limrow = 0
    elif (row <= 5):
        limrow = 3
    elif (row <= 8):
        limrow = 6

    if (col <= 2):
        limcol = 0
    elif (col <= 5):
        limcol = 3
    elif (col <= 8):
        limcol = 6

    for g in range(limrow, limrow+3):
        for h in range(limcol, limcol+3):
            if val == li[g][h]:
                print("That value is already in the square.")
                return True
    return False

def load():
    liload = pickle.load(open("sudoku.txt", "rb"))
    return liload

def save(li):
    pickle.dump(li, open("sudoku.txt", "wb"))

li = generate()

lastinn = input("Load? (y/n) ")
if lastinn == "y":
    li = load()

slots = 0
while True:
    output(li)
    userinput = input("Row, column, value: ")
    if userinput == "save":
        save(li)
        break
    nums = list(map(int, userinput.split(',')))
    row = nums[0] - 1
    col = nums[1] - 1
    val = nums[2]
    if (0 <= row <= 8) and (0 <= col <= 8) and (0 <= val <= 9):
        if (val == 0 and li[row][col] != 0):
            li[row][col] = 0
            slots -= 1

        if (val == li[row][col]):
            continue

        if inrow() or incol() or inbox():
            continue
        else:
            li[row][col] = val
            slots += 1
    else:
        print("Your numbers are not valid.")
    if slots == 81:
        print("You won.")
        break