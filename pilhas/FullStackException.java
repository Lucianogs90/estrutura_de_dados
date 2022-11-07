package pilhas;

/**
 * * Exceção de tempo de execução lançada quando alguém tenta executar uma
 * operação top * ou pop sobre uma pilha vazia.
 */
public class FullStackException extends RuntimeException {
    public FullStackException(String err) {
        super(err);
    }
}