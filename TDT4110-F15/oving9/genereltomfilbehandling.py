def skrivtall():
	f = open("tall.txt", "w")
	f.write("\n".join(map(str,range(100))))
	f.close()
def lestall():
	f = open("tall.txt", "r")
	li = f.read()
	f.close()

	li = [int(x) for x in li.split("\n")]

	kontroll = list(range(100))
	print(kontroll)
	if (li == kontroll):
		return "Tallene er korrekte."
	elif(li != kontroll):
		return "Tallene er ikke korrekte."

skrivtall()
print(lestall())

def fil(les):
	if les:
		f = open("leseskrive.txt", "r")
		streng = f.read()
		f.close()
		return streng
	if not les:
		f = open("leseskrive.txt", "w")
		f.write(input("Skriv noe inn i filen: "))
		f.close()
		return "Inputtet er lagret."