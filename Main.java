public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreRecursiva = new ArvoreBinaria();
        int folhasRecursivas = arvoreRecursiva.contarNosFolha(arvoreRecursiva.raiz);
        System.out.println("Total de nós folha usando recursividade: " + folhasRecursivas);

        ArvoreBinariaSR arvoreIterativa = new ArvoreBinariaSR();
        int folhasIterativas = arvoreIterativa.contarNosFolha(arvoreIterativa.raiz);
        System.out.println("Total de nós folha sem utilizar recursividade: " + folhasIterativas);
    }
}