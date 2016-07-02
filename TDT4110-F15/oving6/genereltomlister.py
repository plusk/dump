li = list(range(1, 7))
print(li)
for x in li:
	if x % 2:
		li[x-1] *= -1

li.sort(reverse = True)
#	li = sorted(li, reverse=True)

print(li)