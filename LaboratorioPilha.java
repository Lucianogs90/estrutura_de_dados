public class LaboratorioPilha {


    public boolean symbolMatch(String texto){
        PilhaArray<String> pilha = new PilhaArray<String>();

        String[] token = texto.split("");

        for (String caractere : token) {
            if (caractere.matches("[\\)\\]\\}]") && pilha.size() == 0) {
                /* System.out.println("Há problemas na abertura ou fechamento desta sequência"); */
                return false;
            } else if (caractere.matches("[\\(\\[\\{]")) {
                pilha.push(caractere);
                /* System.out.println(pilha); */
            } else if (caractere.matches("[\\)]") && pilha.top().matches("[\\(]")
                    || caractere.matches("[\\]]") && pilha.top().matches("[\\[]")
                    || caractere.matches("[\\}]") && pilha.top().matches("[\\{]")) {
                pilha.pop();
                /* System.out.println(caractere);
                System.out.println(pilha); */
            }
        }

        if(!pilha.isEmpty()){
            /* System.out.println("Há problemas na abertura ou fechamento desta sequência"); */
            return false;
        }else{
            /* System.out.println("Tudo correto com a abertura e fechamento desta sequência"); */
            return true;
        }
    }

    public static void main(String[] args) {

        String texto1 = "( )(( )){([( )])}";
        String texto2 = "((( )(( )){([( )])}))";
        String texto3 = ")(( )){([( )])}";
        String texto4 = "({[ ])}";
        String texto5 = "(";
        String texto6 = ")";

        LaboratorioPilha l = new LaboratorioPilha();
        System.out.println(l.symbolMatch(texto1));
        System.out.println(l.symbolMatch(texto2));
        System.out.println(l.symbolMatch(texto3));
        System.out.println(l.symbolMatch(texto4));
        System.out.println(l.symbolMatch(texto5));
        System.out.println(l.symbolMatch(texto6));

    }
}
