import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreAVL arvore = new ArvoreAVL();
        int opcao;

        do {
            System.out.println("\n--- MENU INTERATIVO ÁRVORE AVL ---");
            System.out.println("1 - Inserir nó");
            System.out.println("2 - Remover nó");
            System.out.println("3 - Exibir árvore em pré-ordem");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do nó: ");
                    String entrada = scanner.nextLine().trim();
                    if (!entrada.isEmpty() && entrada.matches("^[a-zA-Z0-9]+$")) {
                        arvore.inserir(entrada.toUpperCase());
                        System.out.println("Nó '" + entrada.toUpperCase() + "' inserido com sucesso.");
                    } else {
                        System.out.println("Entrada inválida! Digite apenas letras ou números (sem espaços ou símbolos).");
                    }
                    break;

                case 2:
                    System.out.print("Digite o valor do nó a remover: ");
                    String entradaRemover = scanner.nextLine().trim();
                    if (!entradaRemover.isEmpty() && entradaRemover.matches("^[a-zA-Z0-9]+$")) {
                        arvore.remover(entradaRemover.toUpperCase());
                        System.out.println("Nó '" + entradaRemover.toUpperCase() + "' removido (se existia).");
                    } else {
                        System.out.println("Entrada inválida! Digite apenas letras ou números (sem espaços ou símbolos).");
                    }
                    break;

                case 3:
                    System.out.print("Pré-ordem: ");
                    arvore.preOrdem();
                    break;

                case 4:
                    System.out.println("Programa Encerrado, volte sempre! ");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}