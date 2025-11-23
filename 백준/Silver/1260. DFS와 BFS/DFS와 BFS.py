import sys
from collections import deque

input = sys.stdin.readline
# sys.setrecursionlimit(10**6) 

def dfs(node):
    visited_dfs[node] = True
    result_dfs.append(node)
    for nxt in graph[node]:
        if not visited_dfs[nxt]:
            dfs(nxt)

def bfs(start):
    queue = deque([start])
    visited_bfs[start] = True
    while queue:
        node = queue.popleft()
        result_bfs.append(node)
        for nxt in graph[node]:
            if not visited_bfs[nxt]:
                visited_bfs[nxt] = True
                queue.append(nxt)

N, M, V = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, N+1):
    graph[i].sort()

visited_dfs = [False] * (N+1)
result_dfs = []
dfs(V)

visited_bfs = [False] * (N+1)
result_bfs = []
bfs(V)

print(" ".join(map(str, result_dfs)))
print(" ".join(map(str, result_bfs)))