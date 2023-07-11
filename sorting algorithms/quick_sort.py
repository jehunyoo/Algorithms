def quick_sort(array: list[int], start: int, end: int) -> list[int]:
    if start >= end:
        return
    
    pivot = start # Hoare Partition
    left, right = start + 1, end
    while left <= right:
        while left <= end and array[left] <= array[pivot]:
            left += 1
        while right > start and array[right] >= array[pivot]:
            right -= 1
        if left <= right:
            array[left], array[right] = array[right], array[left]
        elif left > right:
            array[right], array[pivot] = array[pivot], array[right]
    
    quick_sort(array, start, right - 1)
    quick_sort(array, right + 1, end)

    return array


def quick_sort(array: list[int]) -> list[int]:
    if len(array) <= 1:
        return array
    
    pivot = array[0]
    tail = array[1:]

    left = [x for x in tail if x <= pivot]
    right = [x for x in tail if x > pivot]

    return quick_sort(left) + [pivot] + quick_sort(right)