def selection_sort(array: list[int]) -> list[int]:
    for i in range(len(array) - 1):
        argmin = i
        for j in range(i + 1, len(array) - 1):
            if array[j] < array[argmin]:
                argmin = j

        array[i], array[argmin] = array[argmin], array[i]
    
    return array

def selection_sort(array: list[int]) -> list[int]:
    for i in range(len(array) - 1):
        argmin, _ = min(enumerate(array[i:], i), key=lambda x: x[1])
        array[i], array[argmin] = array[argmin], array[i]
    
    return array
