package tabelas_hash;

public class LaboratorioTabelaHash {
   
    public static void main(String[] args) {
        TabelaHash idade = new TabelaHash(30);
        idade.put("Claudeir", 30);
        idade.put("Luciano", 32);
        idade.put("Fernando", 17);
        idade.put("Luciano", 40);
//        idade.print();
//        System.out.println(idade.isEmpty());
//        System.out.println(idade.size());
//        idade.clear();

        try {
            System.out.println(idade.remove("Fernando"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        idade.print();
        System.out.println(idade.isEmpty());
        System.out.println(idade.size());
    }
    
}
