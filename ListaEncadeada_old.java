import java.util.ArrayList;

public class ListaEncadeada_old {
    int valor;
    ListaEncadeada_old prox;
    
    // Standard constructor
    public ListaEncadeada_old() {
        this.valor = 0;
        this.prox = null;
    }
    
    public ListaEncadeada_old(int valor) {
        this.valor = valor;
        this.prox = null;
    }

    // Constructor for a specific ListaEncadeada_old
    public ListaEncadeada_old(int valor, ListaEncadeada_old prox) {
        this.valor = valor;
        this.prox = prox;
    }
    
    // Adding a new ListaEncadeada_old method
    public ListaEncadeada_old adicionar(ListaEncadeada_old prox) {
        prox.prox = new ListaEncadeada_old();
        this.prox = prox;
        return prox;
    }
    
    public ArrayList<ListaEncadeada_old> percorrer() {
        ListaEncadeada_old primeiro = this;
       
        ArrayList<ListaEncadeada_old> lista = new ArrayList<>();
        while(primeiro.prox != null) {
            lista.add(primeiro);
            primeiro = primeiro.prox;
        }
        return lista;
    }

    
    public static void main(String[] args) {
        // ListaEncadeada_old populate
        ListaEncadeada_old elo1 = new ListaEncadeada_old(1);
        ListaEncadeada_old elo2 = new ListaEncadeada_old(2);
        ListaEncadeada_old elo3 = new ListaEncadeada_old(3);
        ListaEncadeada_old elo4 = new ListaEncadeada_old(4);
        ListaEncadeada_old elo5 = new ListaEncadeada_old(5);

        elo1.adicionar(elo3);
        elo3.adicionar(elo2);
        elo2.adicionar(elo5);
        elo5.adicionar(elo4);
       
        for (int i = 0; i < elo1.percorrer().size(); i++) {
            System.out.print(elo1.percorrer().get(i).valor + ", ");
        }
    }

}