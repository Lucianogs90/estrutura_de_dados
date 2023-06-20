import java.util.*;

class Grafo {
    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;

    public Grafo(int numVertices) {
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

    public void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Grafo graph = new Grafo(4);

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

        // Travessia do grafo usando BFS
        System.out.println("Travessia do grafo usando BFS:");
        graph.BFS(2);
    }
}
