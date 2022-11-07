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
    }

}
