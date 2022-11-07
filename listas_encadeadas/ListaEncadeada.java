package listas_encadeadas;
public class ListaEncadeada {
    public static class No{
        public int valor;
        public No proximo;

        public No(int valor){
            this.valor = valor;
        }
    }

    public No inicio;

    /* Adiciona um nó no final da lista:
    *  1. Criar um novo nó com o valor informado;
    *  2. Fazer o último nó da lista apontar para o novo nó
    */

    public void add(int valor){
        //Criar novo nó
        No novo = new No(valor);

        if(inicio == null){
            this.inicio = novo;

        }else{
            No ultimo = this.inicio;

            while(ultimo.proximo != null){
                ultimo = ultimo.proximo;
            }

            ultimo.proximo = novo;
        }
    }

    public void limparLista(){
        this.inicio = null;
    }

    public void exibirLista(){
        No atual = this.inicio;

        while(atual != null){
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.add(1);
        lista.add(5);
        lista.add(3);

        lista.exibirLista();
    }
}
