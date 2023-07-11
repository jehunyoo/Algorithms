from collections import defaultdict

# assume 0 <= all elements in array < N
def count_sort(array: list[int]) -> list[int]:
    count = defaultdict(int)
    for n in array:
        count[n] += 1
    
    return [k for k, v in count.items() for _ in range(v)]