def familie():
	fam = {}
	medlem = ""
	navn = ""

	while(True):
		medlem = input("Hvilket familiemedlem? ")
		if medlem != "":
			navn = input("Hva heter familiemedlemmet? ")
			if navn != "":
				fam.setdefault(medlem,[]).append(navn)
			else:
				break
		else:
			break
	return fam
print(familie())
