import sys

antall_kvinner = 0
antall_menn = 0
antall_fag = 0
antall_itgk = 0
antall_timer_lekser = 0

def hade(inputvariabel):
	if inputvariabel.lower() == "hade":
		print(antall_kvinner)
		print(antall_menn)
		print(antall_fag)
		print(antall_itgk)
		print(antall_timer_lekser)
		sys.exit()

while True:
	kjonn = ""
	while True:
		if kjonn == "m" or kjonn == "k":
			break
		else:
			kjonn = input("K for kvinne, M for mann: ").lower()
			hade(kjonn)

	alder = input("Hvor gammel er du? ")
	hade(alder)
	alder = int(alder)

	if alder < 18:
		print ("Du kan ikke ta spørreundersøkelsen.")
	else:
		fag = 0		
		while True:
			if fag == "ja" or fag == "nei":
				break
			else:
				fag = input("Skal du ta et fag? (Ja/Nei) ").lower()
				hade(fag)
		if alder < 22:
			variabelmedlem_ITGK = input("Tar du ITGK? ").lower()
		else:
			variabelmedlem_ITGK = input("Tar virkelig du ITGK? ").lower()
		hade(variabelmedlem_ITGK)

		timer_lekser = input("Hvor mange timer bruker du på lekser per dag? ")
		hade(timer_lekser)
		timer_lekser = int(timer_lekser)

		if kjonn == "k":
			antall_kvinner += 1
		elif kjonn == "m":
			antall_menn += 1
		if fag == "ja":
			antall_fag += 1
		if variabelmedlem_ITGK == "ja":
			antall_itgk += 1
		if antall_timer_lekser == 0:
			antall_timer_lekser += timer_lekser
		else:
			antall_timer_lekser = (antall_timer_lekser + timer_lekser)/2 