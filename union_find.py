# path compression
def find(root: list[int], x: int) -> int:
    if root[x] != x:
        root[x] = find(root, root[x])
    return root[x]

def union(root: list[int], x: int, y: int) -> None:
    x = find(root, x)
    y = find(root, y)
    
    if x < y:
        root[y] = x
    else:
        root[x] = y


N = 100
root = [x for x in range(N)]