import heapq

def dijkstra_hop_limit(graph: list[list[int]], start: int, end: int, hop_limit: int) -> list[int]:
    """
    graph: graph[i][j] = distance from node i to node j
    n: the number of nodes
    start: start node
    end: end node
    hop_limit: at most hot_limit nodes

    returns shortest distance from start to end with at most hop_limit nodes
    returns -1 if impossible
    """
    INF = int(1e9)

    visited = {}
    heap: list[tuple[int, int, int]] = [] # (distance, hop, node)
    heapq.heappush(heap, (0, 0, start))

    while heap:
        dist, hop, node = heapq.heappop(heap)
        if node == end:
            return dist
        if (node not in visited or hop < visited[node]) and hop <= hop_limit:
            visited[node] = hop
            for neighbor, d in enumerate(graph[node]):
                if d != INF:
                    heapq.heappush(heap, (dist + d, hop + 1, neighbor))
    
    return -1