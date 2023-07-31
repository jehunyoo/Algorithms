# path compression
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


N = 100
rank = [0 for _ in range(N)]