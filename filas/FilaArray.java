package filas;

/**
 * Implementação da interface Fila usando um array de tamanho fixo.
 * Uma exceção é lançada ao tentar realizar uma operação de enqueue quando
 * o
 * tamanho da fila é igual ao tamanho do array. Esta classe inclui os
 * principais métodos de uma fila
 */
public class FilaArray<E> implements Fila<E> {
    protected int capacity; // capacidade real do array da fila
    public static final int CAPACITY = 500; // capacidade padrão do array da fila
    protected E S[]; // array genérico usado para implementar a fila
    protected int fim = 0; // índice para o final da fila
    protected int inicio = 0; // índice para o início da fila

    public FilaArray() {
        this(CAPACITY);
    }

    public FilaArray(int cap) {
        this.capacity = cap;
        this.S = (E[]) new Object[capacity]; // Está ok este aviso
    }

    public int size() {
        return ((capacity - inicio + fim) % capacity);
    }

    public boolean isEmpty() {
        return (inicio == fim);
    }

    public void enqueue(E element) throws FullQueueException {
        if (this.size() == capacity) {
            throw new FullQueueException("A fila está cheia!");
        }
        S[fim++] = element;
    }

    public E front() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("A fila está vazia!");
        }
        return S[inicio];
    }

    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("A fila está vazia!");
        }
        E element = S[inicio];
        S[inicio++] = null; // exclui a referência ao elemnto que ocupava a posição top
        return element;
    }

}