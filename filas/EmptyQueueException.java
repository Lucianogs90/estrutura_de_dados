package filas;
/**
 * * Exceção de tempo de execução lançada quando alguém tenta executar uma
 * operação front * ou dequeue sobre uma fila vazia.
 */
public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException(String err) {
        super(err);
    }
}