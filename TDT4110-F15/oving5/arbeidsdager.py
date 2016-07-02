def is_leap_year (year):
	if year % 400 == 0:
		return True
	elif year % 100 == 0:
		return False
	elif year % 4 == 0:
		return True
	return False

def weekday_newyear(yearnr):
	dag = ["man", "tir", "ons", "tor", "fre", "lor", "son"]
	y = 0
	for x in range(1900, yearnr+1):
#		print(x, dag[y])
		if x == yearnr:
			return y
		if is_leap_year(x):
			y += 2
		else:
			y += 1
		if y > 6:
			y -= 7

def is_workday(weekday):
	weekdays = ["man", "tir", "ons", "tor", "fre", "lor", "son"]
	for n in range(5):
		if(weekday == n):
			return True
	return False

# Aldri under 260 dager, +1 ved et tilfelle, +2 ved annet?
def workdays_in_year(year):
	arbeidsdager = 0
	dag = weekday_newyear(year)
	if is_leap_year(year):
		dager = 366
	else:
		dager = 365
	for x in range(dager):
		if dag > 6:
			dag -= 7
		if is_workday(dag):
			arbeidsdager += 1
		dag += 1
	return(arbeidsdager)


for x in range(1900, 1920):
	print(x,"har",workdays_in_year(x),"arbeidsdager")