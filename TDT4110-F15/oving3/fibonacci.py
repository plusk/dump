def fibonacci(k):
	fib = [1,2]
	x = 2
	k -= 1
	sum = 3

	while x <= k:
		fib.append(fib[x-1]+fib[x-2])
		sum += fib[x]
		x += 1
	print("f(k) =", fib[k])
	print("Sum:", sum)
	return fib
print(fibonacci(10))