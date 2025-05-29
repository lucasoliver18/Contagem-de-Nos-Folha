public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        int totalFolhas = arvore.contarNosFolha(arvore.raiz);
        System.out.println("Total de nós folha: " + totalFolhas);
    }
}