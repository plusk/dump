teller = 0
def logg(tid, navn, melding):
    global teller
    print("Msg ", teller, ", Klokken ", tid, " sendte ", navn, " foelgende melding: ", "\"", melding, "\"", sep="")
    teller += 1
logg("13:30", "Anders Larsen", "Dette er lett")

def main():
    logg("23:59", "Mr. Y", "Har du mottatt pakken?")
    logg("0:00", "Mdm. Evil", "Ja. Pakken er mottatt.")
    logg("0:03", "Dr. Horrible", "All you need is love!")
    logg("0:09", "Mr. Y", "Dr. Horrible, Dr. Horrible , calling Dr. Horrible .")
    logg("0:09", "Mr. Y", "Dr. Horrible, Dr. Horrible wake up now.")
    logg("0:09", "Dr. Horrible", "Up now!")
main()
