def find(root, x):
    if root[x] != x:
        root[x] = find(root, root[x])
    return root[x]

def union(root, x, y):
    x = find(root, x)
    y = find(root, y)
    
    if x < y:
        root[y] = x
    else:
        root[x] = y

def kruskal(edges: list[tuple[int, int, int]], N: int) -> int:
    path = 0
    root = [x for x in range(N)]

    for cost, x, y in sorted(edges):
        if find(root, x) != find(root, y):
            union(root, x, y)
            path += cost
    
    return path