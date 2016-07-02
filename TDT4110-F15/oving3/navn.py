fornavn = [
'johan', 'eli', 'mats', 'lene', 'simon',
'inger', 'henrik', 'mari', 'per']
etternavn = [
'Hag', 'Hag', 'Basmestad', 'Grimlavaag', 'Kleivesund',
'Fintenes', 'Svalesand', 'Molteby', 'Hegesen']

for n in range(len(fornavn)):
	fornavn[n] = fornavn[n].capitalize()
#	print(fornavn[n], etternavn[n])
	print(fornavn[n], etternavn[len(etternavn)-1-n])
# Simon Kleivesund har samme navn uansett hva fordi listene har oddetall lengde, og krysser hverandre pa midten