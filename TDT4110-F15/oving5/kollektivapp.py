def finnpris(alder):
	if alder > 60:
		print("Gratis!")
	elif alder >= 26:
		print("80 kroner")
	elif alder >= 21:
		print("50 kroner")
	elif alder >= 5:
		print("20 kroner")
	elif alder < 5:
		print("Gratis!")
finnpris(5)