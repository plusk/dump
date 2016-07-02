# Skriv alt på nytt

import math

def vekinput():
	vecStr = input("Skriv inn x, y, og z verdier separert med , (Eks: 1,2,3): ")
	vecLi = list(map(int, vecStr.split(",")))
	return vecLi

def vekoutput(vec):
	print("vec1 =", vec)

def skalarprodukt(vec, skalar):
	vec2 = [x * skalar for x in vec]
	return vec2

def vekleng(vec):
	return math.sqrt(math.pow(vec[0], 2) + math.pow(vec[1], 2) + math.pow(vec[2], 2))

def dotprodukt(vec1, vec2):
	sum = vec1[0]*vec2[0] + vec1[1]*vec2[1] + vec1[2]*vec2[2]
	return sum

def main():
	vec1 = vekinput()
	vekoutput(vec1)
	skalar = int(input("Skalar: "))
	vec2 = skalarprodukt(vec1, skalar)
	print("vec2 =",vec2)

	leng1 = vekleng(vec1)
	print("Lengde 1:",leng1)
	leng2 = vekleng(vec2)
	print("Lengde 2:",leng2)
	forhold = leng2 - leng1
	print("Differanse:",forhold)

	vec3 = vekinput()

	print("dotprodukt:",dotprodukt(vec1, vec3))

main()
