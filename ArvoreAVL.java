public class ArvoreAVL {

    public No raiz;

    public void inserir(char valor) {
        raiz = inserirAVL(raiz, valor);
    }

    private No inserirAVL(No no, char valor) {
        if (no == null) return new No(valor);

        if (valor < no.valor) {
            no.esquerdo = inserirAVL(no.esquerdo, valor);
        } else if (valor > no.valor) {
            no.direito = inserirAVL(no.direito, valor);
        } else {
            return no;
        }

        atualizarAltura(no);
        return balancear(no);
    }

    public void remover(char valor) {
        raiz = removerAVL(raiz, valor);
    }

    private No removerAVL(No no, char valor) {
        if (no == null) return null;

        if (valor < no.valor) {
            no.esquerdo = removerAVL(no.esquerdo, valor);
        } else if (valor > no.valor) {
            no.direito = removerAVL(no.direito, valor);
        } else {
            if (no.esquerdo == null) return no.direito;
            if (no.direito == null) return no.esquerdo;

            No sucessor = encontrarMinimo(no.direito);
            no.valor = sucessor.valor;
            no.direito = removerAVL(no.direito, sucessor.valor);
        }

        atualizarAltura(no);
        return balancear(no);
    }

    private No encontrarMinimo(No no) {
        while (no.esquerdo != null) {
            no = no.esquerdo;
        }
        return no;
    }

    public void preOrdem() {
        preOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerdo);
            preOrdem(no.direito);
        }
    }

    private int altura(No no) {
        return no == null ? 0 : no.altura;
    }

    private void atualizarAltura(No no) {
        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));
    }

    private int fatorBalanceamento(No no) {
        return no == null ? 0 : altura(no.esquerdo) - altura(no.direito);
    }

    private No balancear(No no) {
        int fb = fatorBalanceamento(no);

        if (fb > 1) {
            if (fatorBalanceamento(no.esquerdo) < 0) {
                no.esquerdo = rotacaoEsquerda(no.esquerdo);
            }
            return rotacaoDireita(no);
        }

        if (fb < -1) {
            if (fatorBalanceamento(no.direito) > 0) {
                no.direito = rotacaoDireita(no.direito);
            }
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerdo;
        No T2 = x.direito;

        x.direito = y;
        y.esquerdo = T2;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direito;
        No T2 = y.esquerdo;

        y.esquerdo = x;
        x.direito = T2;

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }
}