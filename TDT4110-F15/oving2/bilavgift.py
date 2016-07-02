def main():
    print("Et program for å beregne nettopris på bil")
    navn = input("Navnet på bilen: ")
    brutto = int(input("Bruttopris på bilen [kr]: "))
    vekt = int(input("Vekt på bilen [kg]: "))
    hk = int(input("Antall hestekrefter på bilen [hk]: "))
    co2 = int(input("Antall gram CO2-utslipp på bilen [gram]: "))
    volum = int(input("Motorvolum på bilen [liter]: "))

    print("Utsalgspris på", navn, "vil bli", beregn_avgift(brutto, vekt, hk, co2, volum), "kr")
def beregn_avgift(brutto, vekt, hk, co2, volum):
    Vekt_p = brutto*vekt*0.00034
    Hk_p = brutto*hk*0.00015
    CO2_p = brutto*co2*0.004
    Volum_p = brutto*volum*0.00055
    Nettopris = brutto + Vekt_p + Hk_p + CO2_p + Volum_p
    return Nettopris
main()

#Ford Mondeo 1.8: Motorvolum: 1800 l, Vekt: 1680 kg, Hestekrefter: 125 hk, Co2: 125 g, Bruttopris: 120000 kr
#Nettopris = 369594 kr
#Ford Mondeo 1.0: Motorvolum: 1000 l, Vekt: 1780 kg, Hestekrefter: 125 hk, Co2: 114 g, Bruttopris: 130000 kr
#Nettopris = 341893 kr
#BMV M5 3.0: Motorvolum: 3000 l, Vekt: 1980 kg, Hestekrefter: 350 hk, Co2: 150 g, Bruttopris: 260000 kr
#Nettopris = 1033682 kr
#BMV M5 1.3: Motorvulum: 1300 l, Vekt: 1980 kg, Hestekrefter: 350 hk, Co2: 125 g, Bruttopris: 270000 kr
#Nettopris = 793989 kr