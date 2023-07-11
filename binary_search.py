from typing import Optional

def binary_search(array: list[int], target: int) -> Optional[int]:
    start, end = 0, len(array) - 1
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        elif array[mid] < target:
            start = mid + 1
        elif array[mid] > target:
            end = mid - 1
    
    return None

def binary_serach(array: list[int], target: int, start: int, end: int) -> Optional[int]:
    if start > end:
        return None
    
    mid = (start + end) // 2
    if array[mid] == target:
        return mid
    elif array[mid] < target:
        return binary_search(array, target, mid + 1, end)
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    
    