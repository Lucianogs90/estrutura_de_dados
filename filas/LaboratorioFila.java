package filas;

public class LaboratorioFila {
    public static void main(String[] args) {

        FilaArray<String> fila1 = new FilaArray<String>(10);

        fila1.enqueue("abacate");
        fila1.enqueue("morango");
        fila1.enqueue("sabão");

        System.out.println("O tamanho da fila é: " + fila1.size());

        System.out.println(fila1.dequeue());

        fila1.enqueue("goiaba");

        System.out.println(fila1.dequeue());

        System.out.println("O tamanho da fila é: " + fila1.size());

        System.out.println(fila1.dequeue());
        System.out.println(fila1.dequeue());

        System.out.println("O tamanho da fila é: " + fila1.size());

        /*
         * =============================================================================
         */

        FilaArray<Integer> fila2 = new FilaArray<Integer>(11);

        for (int i = 0; i < 10; i++) {
            fila2.enqueue(i * i);
        }

        System.out.println("O tamanho da fila é: " + fila2.size());

        for (int i = 0; i < 10; i++) {
            System.out.println(fila2.dequeue());
        }

        fila2.enqueue(100);
        fila2.enqueue(200);
        fila2.enqueue(300);
        fila2.enqueue(400);

        System.out.println("O tamanho da fila é: " + fila2.size());

        System.out.println(fila2.dequeue());
        System.out.println(fila2.dequeue());
        System.out.println(fila2.dequeue());
        System.out.println(fila2.dequeue());

        System.out.println("O tamanho da fila é: " + fila2.size());

    }

}
