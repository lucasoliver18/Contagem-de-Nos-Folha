public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        System.out.println("Inserção dos elementos: A, B, C, D, E, F");
        arvore.inserir('A');
        arvore.inserir('B');
        arvore.inserir('C');
        arvore.inserir('D');
        arvore.inserir('E');
        arvore.inserir('F');

        System.out.print("Pré-ordem após inserção: ");
        arvore.preOrdem();

        System.out.println("Removendo o nó 'C'");
        arvore.remover('C');

        System.out.print("Pré-ordem após remoção: ");
        arvore.preOrdem();
    }
}