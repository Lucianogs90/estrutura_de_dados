package sorting_algorithms;

public class BubbleSort {

    public BubbleSort(int[] numeros) {
        int temp;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }

    public static void main(String[] args) {
        
        int[] numeros = { 1, 5, 3, 2, 4 };
        
        new BubbleSort(numeros);

    }
}