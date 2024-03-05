import java.util.Scanner;

class Pilha {
    private static int[] pilha = new int[5];//cria a array
    private static int topo = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Loop do menu
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    empilhar();
                    break;
                case 2:
                    desempilhar();
                    break;
                case 3:
                    topo();
                    break;
                case 4:
                    listar();
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }

    private static void empilhar() {
        Scanner scanner = new Scanner(System.in);
        if (topo == 5 - 1) {
            System.out.println("Pilha cheia!");
            return;
        }

        topo++;
        System.out.println("Digite o valor a ser empilhado: ");
        int valor = scanner.nextInt();
        pilha[topo] = valor;
        System.out.println("Valor empilhado com sucesso!");
    }

    private static void desempilhar() {
        if (topo == -1) {
            System.out.println("Pilha vazia!");
            return;
        }

        int valorDesempilhado = pilha[topo];
        topo--;
        System.out.println("Valor " + valorDesempilhado + " desempilhado com sucesso!");
    }

    private static void topo() {
        if (topo == -1) {
            System.out.println("Pilha vazia!");
            return;
        }

        System.out.println("Valor no topo da pilha: " + pilha[topo]);
    }

    private static void listar() {
        if (topo == -1) {
            System.out.println("Pilha vazia!");
            return;
        }

        System.out.println("Elementos da pilha:");
        for (int i = topo; i >= 0; i--) {
            System.out.println(pilha[i]);
        }
    }

    private static void exibirMenu() {
        System.out.println("\n--- Menu Pilha ---");
        System.out.println("1. Empilhar");
        System.out.println("2. Desempilhar");
        System.out.println("3. Topo da pilha");
        System.out.println("4. Listar pilha");
        System.out.println("5. Sair");
        System.out.print("Digite a opcao desejada: ");
    }
}
