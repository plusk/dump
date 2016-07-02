num = [8,5,0,2,7,4,1,3,9,6]

def bubbleSort(num):
	for x in range(len(num)-1,0,-1):
		for y in range(x):
			if num[y] > num[y+1]:
				num[y], num[y+1] = num[y+1], num[y]
	return num
print(bubbleSort(num))

num = [8,5,0,2,7,4,1,3,9,6]

def selectionSort(num):
	nynum = []
	for x in range(len(num)):
		top = 0
		for y in range(len(num)):
			if num[y] > num[top]:
				top = y
		nynum = [num.pop(top)] + nynum
	return nynum
print(selectionSort(num))