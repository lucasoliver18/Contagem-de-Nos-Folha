import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinariaSR {

    public No raiz;

    public ArvoreBinariaSR() {
        raiz = new No("A");
        raiz.esquerdo = new No("B");
        raiz.direito = new No("C");
        raiz.esquerdo.esquerdo = new No("D");
        raiz.esquerdo.direito = new No("E");
        raiz.direito.direito = new No("F");
    }

    public int contarNosFolha(No raiz) {
        if (raiz == null) return 0;

        int contador = 0;
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();

            if (atual.esquerdo == null && atual.direito == null) {
                contador++;
            } else {
                if (atual.esquerdo != null) {
                    fila.add(atual.esquerdo);
                }
                if (atual.direito != null) {
                    fila.add(atual.direito);
                }
            }
        }

        return contador;
    }
}