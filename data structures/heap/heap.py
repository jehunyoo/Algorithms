# min heap
class Heap:

    def __init__(self) -> None:
        self.heap = [None]
        self.size = 0
    
    def push(self, item) -> None:
        self.size += 1
        if len(self.heap) <= self.size:
            self.heap.append(None)

        index = self.size
        while index != 1 and item < self.heap[index // 2]:
            self.heap[index] = self.heap[index // 2]
            index //= 2
        
        self.heap[index] = item
    
    def pop(self):
        item = self.heap[1]
        last = self.heap[self.size]
        self.size -= 1
        parent = 1
        child = 2

        while child <= self.size:
            if child < self.size and self.heap[child + 1] < self.heap[child]:
                child += 1
            
            if last <= self.heap[child]:
                break

            self.heap[parent] = self.heap[child]
            parent = child
            child *= 2
        
        self.heap[parent] = last
        
        return item

    def __str__(self) -> str:
        return "[" + " ".join(map(str, self.heap[1:self.size+1])) + "]"