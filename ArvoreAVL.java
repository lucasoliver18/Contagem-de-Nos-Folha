public class ArvoreAVL {
    public No raiz;

    public int altura(No no) {
        return no == null ? 0 : no.altura;
    }

    public int fatorBalanceamento(No no) {
        return no == null ? 0 : altura(no.esquerdo) - altura(no.direito);
    }

    public No rotacaoDireita(No y) {
        No x = y.esquerdo;
        No T2 = x.direito;

        x.direito = y;
        y.esquerdo = T2;

        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;
        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;

        return x;
    }

    public No rotacaoEsquerda(No x) {
        No y = x.direito;
        No T2 = y.esquerdo;

        y.esquerdo = x;
        x.direito = T2;

        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;
        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;

        return y;
    }

    public No inserir(No no, String valor) {
        if (no == null)
            return new No(valor);

        if (valor.compareTo(no.valor) < 0)
            no.esquerdo = inserir(no.esquerdo, valor);
        else if (valor.compareTo(no.valor) > 0)
            no.direito = inserir(no.direito, valor);
        else
            return no;

        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));
        int balanceamento = fatorBalanceamento(no);

        if (balanceamento > 1 && valor.compareTo(no.esquerdo.valor) < 0)
            return rotacaoDireita(no);

        if (balanceamento < -1 && valor.compareTo(no.direito.valor) > 0)
            return rotacaoEsquerda(no);

        if (balanceamento > 1 && valor.compareTo(no.esquerdo.valor) > 0) {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && valor.compareTo(no.direito.valor) < 0) {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void inserir(String valor) {
        raiz = inserir(raiz, valor);
    }

    public No remover(No raiz, String valor) {
        if (raiz == null)
            return raiz;

        if (valor.compareTo(raiz.valor) < 0)
            raiz.esquerdo = remover(raiz.esquerdo, valor);
        else if (valor.compareTo(raiz.valor) > 0)
            raiz.direito = remover(raiz.direito, valor);
        else {
            if ((raiz.esquerdo == null) || (raiz.direito == null)) {
                No temp = (raiz.esquerdo != null) ? raiz.esquerdo : raiz.direito;
                raiz = (temp == null) ? null : temp;
            } else {
                No temp = menorValorNo(raiz.direito);
                raiz.valor = temp.valor;
                raiz.direito = remover(raiz.direito, temp.valor);
            }
        }

        if (raiz == null)
            return raiz;

        raiz.altura = Math.max(altura(raiz.esquerdo), altura(raiz.direito)) + 1;
        int balanceamento = fatorBalanceamento(raiz);

        if (balanceamento > 1 && fatorBalanceamento(raiz.esquerdo) >= 0)
            return rotacaoDireita(raiz);

        if (balanceamento > 1 && fatorBalanceamento(raiz.esquerdo) < 0) {
            raiz.esquerdo = rotacaoEsquerda(raiz.esquerdo);
            return rotacaoDireita(raiz);
        }

        if (balanceamento < -1 && fatorBalanceamento(raiz.direito) <= 0)
            return rotacaoEsquerda(raiz);

        if (balanceamento < -1 && fatorBalanceamento(raiz.direito) > 0) {
            raiz.direito = rotacaoDireita(raiz.direito);
            return rotacaoEsquerda(raiz);
        }

        return raiz;
    }

    public void remover(String valor) {
        raiz = remover(raiz, valor);
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

    private No menorValorNo(No no) {
        No atual = no;
        while (atual.esquerdo != null)
            atual = atual.esquerdo;
        return atual;
    }
}