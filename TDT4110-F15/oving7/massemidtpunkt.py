import random

def center_of_mass(li):
	center = 0
	totmass = 0
	for i in range(1,len(li)+1):
		m = li[i-1]
		r = -0.5 + i

		center += m*r
		totmass += m
	center /= totmass
	return center
print(center_of_mass([1])) # 0.5
print(center_of_mass([1, 1])) # 1
print(center_of_mass([1, 1, 1])) # 1.5
print(center_of_mass([3, 1, 3])) # 1.5
print(center_of_mass([1, 2, 3, 4])) # 2.5

def lirandom():
	li = []
	for x in range(15):
		li.append(random.randint(1,10))
	print(li)
	return center_of_mass(li)
print("Massemidtpunkt til tilfeldig liste:", lirandom())