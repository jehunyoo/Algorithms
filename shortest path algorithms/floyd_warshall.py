def floyd_warshall(graph: list[list[int]], n: int) -> list[list[int]]:
    """
    graph: graph[i][j] = distance from node i to node j
    n: the number of nodes

    returns double list of distances of shortest path to other nodes
    """
    for k in range(n):
        for i in range(n):
            for j in range(n):
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

    return graph