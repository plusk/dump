f = open("numbers.txt", "r")
nums = f.read()
nums = list(map(int, nums.split("\n")))
f.close()
print("Antall rader:", len(nums))

forekomster = [0,0,0,0,0,0,0,0,0,0]
for x in nums:
	forekomster[x] += 1
print(forekomster)

for x in range(len(forekomster)):
	print(x,": ", forekomster[x], sep = '')