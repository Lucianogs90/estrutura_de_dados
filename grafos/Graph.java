import java.util.*;

class Graph {
  private int numVertices;
  private LinkedList<Integer>[] adjacencyList;

  public Graph(int numVertices) {
    this.numVertices = numVertices;
    adjacencyList = new LinkedList[numVertices];
    for (int i = 0; i < numVertices; i++) {
      adjacencyList[i] = new LinkedList<>();
    }
  }

  public void addVertex() {
    numVertices++;
    LinkedList<Integer> newList = new LinkedList<>();
    adjacencyList = Arrays.copyOf(adjacencyList, numVertices);
    adjacencyList[numVertices - 1] = newList;
  }

  public void addEdge(int source, int destination) {
    adjacencyList[source].add(destination);
  }

  public void DFS(int startVertex) {
    boolean[] visited = new boolean[numVertices];
    DFSUtil(startVertex, visited);
  }

  private void DFSUtil(int vertex, boolean[] visited) {
    visited[vertex] = true;
    System.out.print(vertex + " ");

    for (int neighbor : adjacencyList[vertex]) {
      if (!visited[neighbor]) {
        DFSUtil(neighbor, visited);
      }
    }
  }
}

class Main {
  public static void main(String[] args) {
    Graph graph = new Graph(4);

    // Adicionando vértices
    graph.addVertex();
    graph.addVertex();

    // Adicionando arestas
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);

    // Travessia do grafo usando DFS
    System.out.println("Travessia do grafo usando DFS:");
    graph.DFS(2);
  }
}
