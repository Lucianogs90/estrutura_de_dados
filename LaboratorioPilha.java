public class LaboratorioPilha {

    public static void main(String[] args) {
        
        String texto1 = "( )(( )){([( )])}";
        String texto2 = "((( )(( )){([( )])}))";
        String texto3 = ")(( )){([( )])}";
        String texto4 = "({[ ])}";
        String texto5 = "(";
        String texto6 = ")";
        
        PilhaArray<String> pilha = new PilhaArray<String>();

        String[] token = texto1.split("");

        for (String caractere : token) {
            if(caractere.matches("[\\)\\]\\}]") && pilha.size() == 0){
                System.out.println("Tá errado");
            } else if(caractere.matches("[\\(\\[\\{]")){
                pilha.push(caractere);
                System.out.println(pilha);
            } else if(caractere.matches("[\\)]") && pilha.top().matches("[\\(]")){
                pilha.pop();
                System.out.println(caractere);
                System.out.println(pilha);
            }
        }
        
        


    }
}
