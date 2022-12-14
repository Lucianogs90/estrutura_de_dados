package pilhas;
import java.util.EmptyStackException;

import filas.EmptyQueueException;

/**
 * * Implementação da interface Stack usando um arranjo de tamanho fixo.
 * Uma exceção é lançada ao tentar realizar uma operação de push quando o
 * tamanho da pilha é igual ao tamanho do arranjo. Esta classe inclui os
 * principais
 * métodos da classe Java predefinida java.util.Stack.
 */
public class PilhaArray<E> implements Pilha<E> {
    protected int capacity; // capacidade real do array da pilha
    public static final int CAPACITY = 500; // capacidade padrão do array da pilha
    protected E S[]; // array genérico usado para implementar a pilha
    protected int top = -1; // índice para o topo da pilha

    public PilhaArray() {
        this(CAPACITY);
    }

    public PilhaArray(int cap) {
        this.capacity = cap;
        this.S = (E[]) new Object[capacity]; // Está ok este aviso
    }

    public int size() {
        return (top + 1);
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public void push(E element) throws EmptyQueueException {
        if (this.size() == capacity) {
            throw new EmptyQueueException("A pilha está cheia!");
        }
        S[++top] = element;
    }

    public E top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return S[top];
    }

    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E element = S[top];
        S[top--] = null; // exclui a referência ao elemnto que ocupava a posição top
        return element;
    }

    public String toString() {
        String s;
        s = "[";
        if (this.size() > 0) {
            s += S[0];
        }
        if (this.size() > 1) {
            for (int i = 0; i <= this.size() - 1; i++) {
                s += ", " + S[i];
            }
        }

        s += "]";

        return s;
    }

}