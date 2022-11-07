package filas;
/** 
 * Interface para uma fila: uma coleção de objetos 
 * que são inseridos e removidos de acordo com o princípio de o primeiro que entra é o 
 * primeiro que sai. Esta interface inclui os principais métodos de uma fila
 * 
 * @author Luciano Gomes da Silva
 * @see FullQueueException
 * */

public interface Fila<E>{
    /** 
     * Retorna o número de elementos na fila.
     * @return número de elementos na fila.
     **/

    public int size();

    /** 
     * Indica quando a fila está vazia. 
     * @return true se a fila é vazia, false em caso contrário. 
     **/
    public boolean isEmpty();

    /** 
     * Inspeciona o elemento no início da fila. 
     * @return o elemento do início da fila. 
     * @exception EmptyQueueException se a fila estiver vazia. 
     **/
    public E front();

    /** 
     * Insere um elemento no final da fila. 
     * @param element a ser inserido. 
     **/
    public void enqueue(E element);

    /** 
     * Remove o elemento do início da fila. 
     * @return elemento a ser removido. 
     * @exception EmptyQueueException se a fila estiver vazia. 
     **/
    public E dequeue();
}
