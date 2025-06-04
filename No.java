public class No {
    char valor;
    int altura;
    No esquerdo, direito;

    public No(char valor) {
        this.valor = valor;
        this.altura = 1;
        this.esquerdo = null;
        this.direito = null;
    }
}