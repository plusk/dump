import random
 
def pick_sentence(sentences):
	return sentences[random.randint(0, len(sentences)-1)]

def print_sentence(str1, str2, str3):
	print(str1, str2 + str3)
 
def intro_text():
	print("\n"*20)
	print("Hei, jeg heter Eliza og vil gjerne snakke med deg.")
	print("Ikke start svar med stor bokstav og bruk hele setninger.")
	print("Skriv 'hade' hvis du vil avslutte samtalen")
	print("**************************************************")
	print("")

def main():
	answer = "ikke hade"

	questions = ['Hva gjør du', 'Hvordan går det', 'Hvorfor heter du',
					'Liker du å hete', 'Føler du deg bra', 'Hva har du gjort idag',
					'Hva tenker du om framtida', 'Hva gjør deg glad', 'Hva gjør deg trist']

	follow_ups = ['Hvorfor sier du', 'Hva mener du med', 'Hvor lenge har du sagt',
					'Hvilke tanker har du om', 'Kan du si litt mer om',
					'Når tenkte du første gang på']

	responses = ['Fint du sier det', 'Det skjønner jeg godt', 'Så dumt da', 'Føler meg også sånn',
					'Blir trist av det du sier', 'Så bra', 'Du er jammen frekk']
 
	intro_text()
 
	name = input("Hva er navnet ditt? ")
 
	while answer != "hade":
		pass
 
		sentence = pick_sentence(questions)
 
		print_sentence(sentence, name, "?")
 
		answer = input("Svar: ")
 
		followup = pick_sentence(follow_ups)
 
		print_sentence(followup, answer, "?")
 
		input("Svar: ")
 
		response = pick_sentence(responses)
 
		print_sentence(response, name, ".")
main()