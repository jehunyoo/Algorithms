import heapq

# O(ElogE) = O(ElogV) < O(V^2)
def dijkstra(graph: list[list[int]], n: int, start: int) -> list[int]:
    """
    graph: graph[i][j] = distance from node i to node j
    n: the number of nodes
    start: start node

    returns list of distances of shortest path to other nodes
    """
    INF = int(1e9)
    distance = [INF for _ in range(n)]
    distance[start] = 0

    queue: list[tuple[int, int]] = [] # (distance, node)
    heapq.heappush(queue, (0, start))

    while queue:
        dist, node = heapq.heappop(queue)
        if distance[node] < dist:
            continue
        for neighbor, d in enumerate(graph[node]):
            if d != INF and (shorter := dist + d) < distance[neighbor]:
                distance[neighbor] = shorter
                heapq.heappush(queue, (shorter, neighbor))
    
    return distance

# O(V^2)
def dijkstra(graph: list[list[int]], n: int, start: int) -> list[int]:
    """
    graph: graph[i][j] = distance from node i to node j
    n: the number of nodes
    start: start node

    returns list of distances of shortest path to other nodes
    """
    INF = int(1e9)
    distance = [INF for _ in range(n)]
    visited = [False for _ in range(n)]
    
    distance[start] = 0
    visited[start] = True
    for neighbor, d in enumerate(graph[start]):
        if d != INF:
            distance[neighbor] = d
    
    for _ in range(n - 1):
        # find next node
        next_node = None
        next_dist = INF
        for nd in range(n):
            if distance[nd] < next_dist and not visited[nd]:
                next_dist = distance[nd]
                next_node = nd
        
        # update distance
        node = next_node
        visited[node] = True
        for neighbor, d in graph[node]:
            if d != INF and (shorter := distance[node] + d) < distance[neighbor]:
                distance[neighbor] = shorter
    
    return distance