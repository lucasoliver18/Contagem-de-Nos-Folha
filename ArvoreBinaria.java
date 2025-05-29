public class ArvoreBinaria {

    public No raiz;

    public ArvoreBinaria() {
        raiz = new No('A');
        raiz.esquerdo = new No('B');
        raiz.direito = new No('C');
        raiz.esquerdo.esquerdo = new No('D');
        raiz.esquerdo.direito = new No('E');
        raiz.direito.direito = new No('F');
    }

    public int contarNosFolha(No no) {
        if (no == null)
            return 0;
        if (no.esquerdo == null && no.direito == null)
            return 1;
        return contarNosFolha(no.esquerdo) + contarNosFolha(no.direito);
    }
}