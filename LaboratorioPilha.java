public class LaboratorioPilha {

    public boolean symbolMatch(String texto) {
        PilhaArray<String> pilha = new PilhaArray<String>();

        String[] token = texto.split("");

        for (String caractere : token) {
            if (caractere.matches("[\\)\\]\\}]") && pilha.size() == 0) {
                return false;
            } else if (caractere.matches("[\\(\\[\\{]")) {
                pilha.push(caractere);
            } else if (caractere.matches("[\\)]") && pilha.top().matches("[\\(]")
                    || caractere.matches("[\\]]") && pilha.top().matches("[\\[]")
                    || caractere.matches("[\\}]") && pilha.top().matches("[\\{]")) {
                pilha.pop();
            } else {
                return false;
            }
        }

        if (pilha.isEmpty()) {
            return true;
        } else {
            return false;
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
