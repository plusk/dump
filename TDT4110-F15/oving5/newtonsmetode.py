# hva faen er denne oppgaven

import math

def f(x):
	return ((x-12)*math.exp(5*x))-(8*math.pow(x+2, 2))
def g(x):
	return (math.pow(6*x, 4)-math.pow(5*x, 3)-math.pow(2*x, 2)-x)

def derf(h, x):
	return (f(x+(h/2))-f(x-(h/2)))/h
def derg(h, x):
	return (g(x+(h/2))-g(x-(h/2)))/h

def newt(x):
	tol = 13
	while True:
		if(f(x)<tol):
			print("Ferdig!")
			print(x)
			break
		x -= (f(x))/(der(3,x))
		print(x)
newt(13)