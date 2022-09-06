import java.util.ArrayList;

public class ListaEncadeada {
    int valor;
    ListaEncadeada prox;
    
    // Standard constructor
    public ListaEncadeada() {
        this.valor = 0;
        this.prox = null;
    }
    
    public ListaEncadeada(int valor) {
        this.valor = valor;
        this.prox = null;
    }

    // Constructor for a specific ListaEncadeada
    public ListaEncadeada(int valor, ListaEncadeada prox) {
        this.valor = valor;
        this.prox = prox;
    }
    
    // Adding a new ListaEncadeada method
    public ListaEncadeada adicionar(ListaEncadeada prox) {
        prox.prox = new ListaEncadeada();
        this.prox = prox;
        return prox;
    }
    
    public ArrayList<ListaEncadeada> percorrer() {
        ListaEncadeada primeiro = this;
       
        ArrayList<ListaEncadeada> lista = new ArrayList<>();
        while(primeiro.prox != null) {
            lista.add(primeiro);
            primeiro = primeiro.prox;
        }
        return lista;
    }

    
    public static void main(String[] args) {
        // ListaEncadeada populate
        ListaEncadeada elo1 = new ListaEncadeada(1);
        ListaEncadeada elo2 = elo1.adicionar(new ListaEncadeada(2));
        ListaEncadeada elo3 = elo2.adicionar(new ListaEncadeada(3));
        ListaEncadeada elo4 = elo3.adicionar(new ListaEncadeada(4));
        ListaEncadeada elo5 = elo4.adicionar(new ListaEncadeada(5));
       
        for (int i = 0; i < elo1.percorrer().size(); i++) {
            System.out.print(elo1.percorrer().get(i).valor + ", ");
        }
    }

}