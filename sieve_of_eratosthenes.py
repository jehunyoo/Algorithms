def sieve_of_eratosthenes(n: int) -> list[int]:
    primes = [True for _ in range(n + 1)]

    for num in range(2, int(n ** 0.5) + 1):
        if primes[num]:
            for multiple in range(num * 2, n + 1, num):
                primes[multiple] = False
    
    return [prime for prime, isprime in enumerate(primes[2:], 2) if isprime]