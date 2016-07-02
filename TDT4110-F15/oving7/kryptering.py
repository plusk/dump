def caesar(string, hakk):
	li = list(string)
	for x in range(len(li)):
		y = ord(li[x]) + hakk
		if y > 122:
			y -= 97
			y = y % 26
			y += 97
		li[x] = chr(y)
	string = "".join(li)
	return string
print(caesar("xyz", 3))

def anticaesar(string, hakk):
	li = list(string)
	for x in range(len(li)):
		y = ord(li[x]) - hakk
		if y < 97:
			y += 26
			y -= 97
			y = y % 26
			y += 97
		li[x] = chr(y)
	string = "".join(li)
	return string
#print(anticaesar(caesar("xyz", 3), 3))

#strInput = input("Skriv en streng som skal krypteres: ")
#strKrypt = caesar(strInput, 3)
#print("Kryptert:", strKrypt)
#strDekrypt = anticaesar(strKrypt, 3)
#print("Dekryptert:", strDekrypt)

# Hvis les, returnerer dekryptert innhold av filen
# Hvis skriv, krypterer strengen og lagrer det i filen
def fil(string, hakk, les):
	if les:
		f = open("kryptering.txt", "r")
		strDekrypt = anticaesar(list(f.read()), hakk)
		f.close()
		return strDekrypt
	if not les:
		f = open("kryptering.txt", "w")
		f.write(caesar(string, hakk))
		f.close()
		return "Strengen er kryptert og lagret."
#print(fil("xyz", 3, True))