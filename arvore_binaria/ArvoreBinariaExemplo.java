package arvore_binaria;

import java.util.Scanner;

class No {
  public int item;
  public No direita;
  public No esquerda;
}

// Classe Arvore
class Arvore {
  private No raiz; // Nó raiz

  public Arvore() {
    raiz = null;
  } // inicializa arvore

  public void inserir(int valor) {
    No novo = new No(); // cria um novo Nó
    novo.item = valor; // atribui o valor recebido ao item de dados do Nó
    novo.direita = null;
    novo.esquerda = null;

    if (raiz == null)
      raiz = novo;
    else { // se nao for a raiz
      No atual = raiz;
      No anterior;
      while (true) {
        anterior = atual;
        if (valor <= atual.item) { // ir para esquerda
          atual = atual.esquerda;
          if (atual == null) {
            anterior.esquerda = novo;
            return;
          }
        } // fim da condição ir a esquerda
        else { // ir para direita
          atual = atual.direita;
          if (atual == null) {
            anterior.direita = novo;
            return;
          }
        } // fim da condição ir a direita
      } // fim do laço while
    } // fim do else não raiz

  }

  public No buscar(int chave) {
    if (raiz == null)
      return null; // se arvore vazia
    No atual = raiz; // começa a procurar desde raiz
    while (atual.item != chave) { // enquanto nao encontrou
      if (chave < atual.item)
        atual = atual.esquerda; // caminha para esquerda
      else
        atual = atual.direita; // caminha para direita
      if (atual == null)
        return null; // encontrou uma folha -> sai
    } // fim laço while
    return atual; // terminou o laço while e chegou aqui é pq encontrou item
  }

  public void inOrder(No atual) {
    if (atual != null) {
      inOrder(atual.esquerda);
      System.out.print(atual.item + " ");
      inOrder(atual.direita);
    }
  }

  public void preOrder(No atual) {
    if (atual != null) {
      System.out.print(atual.item + " ");
      preOrder(atual.esquerda);
      preOrder(atual.direita);
    }
  }

  public void posOrder(No atual) {
    if (atual != null) {
      posOrder(atual.esquerda);
      posOrder(atual.direita);
      System.out.print(atual.item + " ");
    }
  }

  public void caminhar() {
    System.out.print("\n Exibindo em ordem: ");
    inOrder(raiz);
    System.out.print("\n Exibindo em pos-ordem: ");
    posOrder(raiz);
    System.out.print("\n Exibindo em pre-ordem: ");
    preOrder(raiz);
    System.out.print("\n Altura da arvore: " + altura(raiz));
    System.out.print("\n Quantidade de folhas: " + folhas(raiz));
    System.out.print("\n Quantidade de Nós: " + contarNos(raiz));
    if (raiz != null) { // se arvore nao esta vazia
      System.out.print("\n Valor minimo: " + min().item);
      System.out.println("\n Valor maximo: " + max().item);
    }
  }

  public int altura(No atual) {
    if (atual == null || (atual.esquerda == null && atual.direita == null))
      return 0;
    else {
      if (altura(atual.esquerda) > altura(atual.direita))
        return (1 + altura(atual.esquerda));
      else
        return (1 + altura(atual.direita));
    }
  }

  public int folhas(No atual) {
    if (atual == null)
      return 0;
    if (atual.esquerda == null && atual.direita == null)
      return 1;
    return folhas(atual.esquerda) + folhas(atual.direita);
  }

  public int contarNos(No atual) {
    if (atual == null)
      return 0;
    else
      return (1 + contarNos(atual.esquerda) + contarNos(atual.direita));
  }

  public No min() {
    No atual = raiz;
    No anterior = null;
    while (atual != null) {
      anterior = atual;
      atual = atual.esquerda;
    }
    return anterior;
  }

  public No max() {
    No atual = raiz;
    No anterior = null;
    while (atual != null) {
      anterior = atual;
      atual = atual.direita;
    }
    return anterior;
  }

}

// Teste da classe Arvore
class ArvoreBinariaApp {
  public static void main(String[] args) {
    int valor;
    Arvore minhaArvore = new Arvore();
    Scanner entrada = new Scanner(System.in);
    System.out.println("Entre com 10 valores inteiros: ");
    for (int i = 0; i < 10; i++) {
      valor = entrada.nextInt();
      minhaArvore.inserir(valor);
    }
    minhaArvore.caminhar();
    System.out.println("\n Entre com um valor a ser buscado: ");
    valor = entrada.nextInt();
    No encontrado = minhaArvore.buscar(valor);
    if (encontrado != null)
      System.out.println("Encontrado " + valor);
    else
      System.out.println("Não encontrado " + valor);
    
    entrada.close();
  }
}