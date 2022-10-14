public class LaboratorioPilha {

    public static void main(String[] args) {
        
        String texto1 = "( )(( )){([( )])}";
        String texto2 = "((( )(( )){([( )])}))";
        String texto3 = ")(( )){([( )])}";
        String texto4 = "({[ ])}";
        String texto5 = "(";
        
        PilhaArray<String> pilha = new PilhaArray<String>();

        String[] token = texto1.split("");

        for (String caractere : token) {
            if(caractere.matches("[\\)\\]\\}]") && pilha.top() == null){
                System.out.println("Tá errado");
            } else if(caractere.matches())
        }
        
        System.out.println(pilha.isEmpty());


    }
}
