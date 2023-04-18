package arvore_binaria;

class Node {
  private Integer value;
  private Node leftNode;
  private Node rightNode;

  public Node() {
  }

  public Node(Integer value) {
    super();
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Node getLeftNode() {
    return leftNode;
  }

  public void setLeftNode(Node leftNode) {
    this.leftNode = leftNode;
  }

  public Node getRightNode() {
    return rightNode;
  }

  public void setRightNode(Node rightNode) {
    this.rightNode = rightNode;
  }

  @Override
  public String toString() {
    return "Node [value=" + value + "]";
  }
}

public class BinaryTree {
  private Node root;

  public boolean isEmpty() {
    return root == null; // Se a raiz for nula, a árvore está vazia
  }

  public int getHeight() {
    return getHeight(this.root);
  }

  private int getHeight(Node root) {
    if (root == null) { // Se a raiz for nula, a árvore está vazia
      return 0; // Retorna 0
    }
    int leftHeight = getHeight(root.getLeftNode()); // Calcula a altura da subarvore esquerda
    int rightHeight = getHeight(root.getRightNode()); // Calcula a altura da subarvore direita
    if (leftHeight > rightHeight) { // Retorna a maior altura
      return leftHeight + 1; // +1 para contar a raiz
    } else { // Retorna a maior altura
      return rightHeight + 1; // +1 para contar a raiz
    }
  }

  public int getNodeAmount() {
    return getNodeAmount(root);
  }

  private int getNodeAmount(Node root) {
    if (root == null) { // Se a raiz for nula, a árvore está vazia
      return 0; // Retorna 0
    }
    int leftNodeAmount = getNodeAmount(root.getLeftNode()); // Calcula a quantidade de nós da subarvore esquerda
    int rightNodeAmount = getNodeAmount(root.getRightNode()); // Calcula a quantidade de nós da subarvore direita
    return leftNodeAmount + rightNodeAmount + 1; // Retorna a soma das quantidades de nós das subárvores mais a raiz
  }

  public void printPosTree() {
    if (this.isEmpty()) { // Se a raiz for nula, a árvore está vazia
      System.out.println("Árvore vazia"); // Imprime uma mensagem
    } else { // Se a árvore não estiver vazia
      printPosTree(this.root); // Chama o método recursivo para imprimir a árvore
    }
  }

  private void printPosTree(Node node) {
    if (node.getLeftNode() != null) { // Se o nó esquerdo não for nulo, chama o método recursivamente
      printPosTree(node.getLeftNode()); // Imprime a subarvore esquerda
    }
    if (node.getRightNode() != null) { // Se o nó direito não for nulo, chama o método recursivamente
      printPosTree(node.getRightNode()); // Imprime a subarvore direita
    }
    System.out.println("Nó: " + node.getValue()); // Imprime o valor do nó
  }

  public void printPreTree() {
    if (this.isEmpty()) { // Se a raiz for nula, a árvore está vazia
      System.out.println("Árvore vazia"); // Imprime uma mensagem
    } else { // Se a árvore não estiver vazia
      printPreTree(this.root); // Chama o método recursivo para imprimir a árvore
    }
  }

  private void printPreTree(Node node) {
    System.out.println("Nó: " + node.getValue()); // Imprime o valor do nó
    if (node.getLeftNode() != null) { // Se o nó esquerdo não for nulo, chama o método recursivamente
      printPreTree(node.getLeftNode()); // Imprime a subarvore esquerda
    }
    if (node.getRightNode() != null) { // Se o nó direito não for nulo, chama o método recursivamente
      printPreTree(node.getRightNode()); // Imprime a subarvore direita
    }
  }

  public void printSortedTree() {
    if (this.isEmpty()) { // Se a raiz for nula, a árvore está vazia
      System.out.println("Árvore vazia"); // Imprime uma mensagem
    } else { // Se a árvore não estiver vazia
      printSortedTree(this.root); // Chama o método recursivo para imprimir a árvore
    }
  }
  
  private void printSortedTree(Node node) {
    if (node.getLeftNode() != null) { // Se o nó esquerdo não for nulo, chama o método recursivamente
      printSortedTree(node.getLeftNode()); // Imprime a subarvore esquerda
    }
    System.out.println("Nó: " + node.getValue()); // Imprime o valor do nó
    if (node.getRightNode() != null) { // Se o nó direito não for nulo, chama o método recursivamente
      printSortedTree(node.getRightNode()); // Imprime a subarvore direita
    }
  }

  public void insert(int value) {
    insert(this.root, value);
  }

  public void insert(Node node, int value) {
    if (this.isEmpty()) { // Se a raiz for nula, a árvore está vazia
      this.root = new Node(value); // Insere o nó na raiz
    } else { // Se a árvore não estiver vazia, insere o nó na posição correta
      if (value < node.getValue()) { // Verifica se o valor a ser inserido é menor que o do nó corrente da árvore, se
                                     // sim, vai para subarvore esquerda
        if (node.getLeftNode() != null) { // Se tiver elemento no nó esquerdo, continua a busca
          insert(node.getLeftNode(), value); // Insere o nó na subarvore esquerda
        } else { // Se o nó esquerdo for vazio, insere o novo nó em seu lugar
          node.setLeftNode(new Node(value)); // Insere o nó na subarvore esquerda
        }
      } else if (value > node.getValue()) { // Verifica se o valor a ser inserido é maior que o do nó corrente da
                                            // árvore,
                                            // se sim, vai para subarvore direita
        if (node.getRightNode() != null) { // Se tiver elemento no nó direito, continua a busca
          insert(node.getRightNode(), value); // Insere o nó na subarvore direita
        } else { // Se o nó direito for vazio, insere o novo no em seu lugar
          node.setRightNode(new Node(value)); // Insere o nó na subarvore direita
        }
      }
    }
  }

  public Node search(int value) {
    return search(this.root, value);
  }

  private Node search(Node node, int value) {
    if (node == null) { // Se o nó for nulo, a árvore está vazia
      return null; // Retorna nulo
    } else { // Se a árvore não estiver vazia, busca o nó na posição correta
      if (value < node.getValue()) { // Verifica se o valor a ser buscado é menor que o do nó corrente da árvore, se
                                     // sim,
                                     // vai para subarvore esquerda
        return search(node.getLeftNode(), value); // Busca o nó na subarvore esquerda
      } else if (value > node.getValue()) { // Verifica se o valor a ser buscado é maior que o do nó corrente da
                                            // árvore,
                                            // se sim, vai para subarvore direita
        return search(node.getRightNode(), value); // Busca o nó na subarvore direita
      } else { // Se o valor for igual ao do nó corrente, retorna o nó
        return node; // Retorna o nó
      }
    }
  }

  public Node remove(int value) throws Exception {
    return remove(this.root, value);
  }

  private Node remove(Node node, int value) throws Exception {
    if (this.isEmpty()) { // Se a raiz for nula, a árvore está vazia
      throw new Exception("Árvore vazia"); // Lança uma exceção
    } else { // Se a árvore não estiver vazia, remove o nó na posição correta
      if (value < node.getValue()) { // Verifica se o valor a ser removido é menor que o do nó corrente da árvore, se
                                     // sim, vai para subarvore esquerda
        node.setLeftNode(remove(node.getLeftNode(), value)); // Remove o nó na subarvore esquerda
      } else if (value > node.getValue()) { // Verifica se o valor a ser removido é maior que o do nó corrente da
                                            // árvore, se sim, vai para subarvore direita
        node.setRightNode(remove(node.getRightNode(), value)); // Remove o nó na subarvore direita
      } else if (node.getLeftNode() != null && node.getRightNode() != null) { // Se o nó a ser removido tiver dois
                                                                              // filhos
        System.out.println("  Removeu Nó " + node.getValue()); // Imprime o valor do nó removido
        node.setValue(findMinNode(node.getRightNode()).getValue()); // Substitui o valor do nó removido pelo valor do
                                                                    // menor nó da subarvore direita
        node.setRightNode(removeMinNode(node.getRightNode())); // Remove o menor nó da subarvore direita
      } else { // Se o nó a ser removido tiver um filho ou nenhum
        System.out.println("  Removeu Nó " + node.getValue()); // Imprime o valor do nó removido
        node = (node.getLeftNode() != null) ? node.getLeftNode() : node.getRightNode(); // Substitui o nó removido pelo
                                                                                        // filho dele
      }
      return node; // Retorna o nó removido
    }
  }

  private Node removeMinNode(Node node) {
    if (node == null) { // Se o nó for nulo, a árvore está vazia
      System.out.println("  ERRO "); // Imprime uma mensagem de erro
    } else if (node.getLeftNode() != null) { // Se o nó esquerdo não for nulo, chama o método recursivamente
      node.setLeftNode(removeMinNode(node.getLeftNode())); // Remove o menor nó da subarvore esquerda
      return node; // Retorna o nó removido
    } else { // Se o nó esquerdo for nulo, o nó a ser removido é o menor nó da subarvore
      return node.getRightNode(); // Retorna o nó direito do nó removido
    }
    return null; // Retorna nulo
  }

  private Node findMinNode(Node node) {
    if (node != null) { // Se o nó não for nulo, a árvore não está vazia
      while (node.getLeftNode() != null) { // Enquanto o nó esquerdo não for nulo, continua a busca
        node = node.getLeftNode(); // Vai para o nó esquerdo
      }
    }
    return node; // Retorna o nó encontrado
  }
}

class BinaryTreeTest {
  public static void main(String[] args) {
    BinaryTree arvore = new BinaryTree();
    arvore.insert(10);
    arvore.insert(5);
    arvore.insert(15);
    arvore.insert(3);
    arvore.insert(7);
    arvore.insert(12);
    arvore.insert(18);
    arvore.insert(1);
    arvore.insert(9);
    arvore.insert(4);
    arvore.insert(6);
    arvore.insert(8);
    arvore.insert(11);
    arvore.insert(13);
    arvore.insert(20);
    arvore.insert(16);
    arvore.insert(19);
    arvore.insert(2);
    arvore.insert(9); // Valor já existente
    arvore.insert(14);
    arvore.insert(17);
    arvore.insert(20); // Valor já existente
    
    arvore.printPosTree();
    
    System.out.println("Altura: " + arvore.getHeight());
    System.out.println("Quantidade de Nós: " + arvore.getNodeAmount());
    try {
      arvore.remove(10);
    } catch (Exception e) {
      e.printStackTrace();
    }
    arvore.printPosTree();
    System.out.println("Altura: " + arvore.getHeight());
    System.out.println("Quantidade de Nós: " + arvore.getNodeAmount());

    arvore.printSortedTree();
  }
}