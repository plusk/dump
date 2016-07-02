def strlik(str1, str2):
	if not(len(str1)==len(str2)):
		return False
	for x in range(len(str1)):
		if str1[x] != str2[x]:
			return False
	return True
#print(strlik("test", "test"))

def strrev(streng):
	liste = list(streng)
	y = len(liste)
	x = 0
	while x <= (y/2):
		y -= 1
		liste[x], liste[y] = liste[y], liste[x]
		x += 1
	streng = "".join(liste)
	return streng
#print(strrev("anders"))

def strpal(streng):
	return strlik(streng, strrev(streng))
print(strpal("abba"))

def strinn(str1, str2):
	print(str1.split(str2))
	if(strlik(str1, "".join(str1.split(str2)))):
		return False
	return str1.index(str2)
print(strinn("blablatestblabla", "tomat"))