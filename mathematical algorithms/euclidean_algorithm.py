# Euclidean Algorithm
# For A, B (A > B), GCD(A, B) == GCD(B, A % B), divide until A % B == 0 and A is GCD
# Greatest Common Divisor
# O(logN), iteration
def gcd(A: int, B: int) -> int:
    A, B = max(A, B), min(A, B)

    while B != 0:
        A, B = B, A % B
    
    return A

# recursion
def gcd(A: int, B: int) -> int:
    A, B = max(A, B), min(A, B)

    if B == 0:
        return A
    else:
        return gcd(B, A % B)
    
# Least Common Multiple
def lcm(A, B):
    return (A * B) // gcd(A, B)