package filas;
/**
 * * Exceção de tempo de execução lançada quando alguém tenta executar uma
 * operação enqueue sobre uma fila cheia.
 */
public class FullQueueException extends RuntimeException {
    public FullQueueException(String err) {
        super(err);
    }
}