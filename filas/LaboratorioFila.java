package filas;

public class LaboratorioFila {
    public static void main(String[] args) {

        FilaArray<String> fila = new FilaArray<String>(10);

        fila.enqueue("abacate");
        fila.enqueue("morango");
        fila.enqueue("sabão");
        System.out.println(fila.dequeue());
        fila.enqueue("goiaba");
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());

        
        FilaArray<Integer> fila2 = new FilaArray<Integer>(11);

        for(int i = 0; i < 10; i++){
            fila2.enqueue(i*i);
        }

        
        for (int i = 0; i < 10; i++){
            System.out.println(fila2.dequeue());
        }

        fila2.enqueue(100);
        fila2.enqueue(200);
        fila2.enqueue(300);
        fila2.enqueue(400);

        System.out.println(fila2.dequeue());
        System.out.println(fila2.dequeue());
        System.out.println(fila2.dequeue());
        System.out.println(fila2.dequeue());

    }

}
