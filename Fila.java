import java.util.Scanner;

public class Fila {

    private int[] fila; 
    private int inicio; 
    private int fim; 
    private int tamanhoMaximo; 

    public Fila(int tamanhoMaximo) {
        this.fila = new int[tamanhoMaximo];
        this.inicio = 0;
        this.fim = 0;
        this.tamanhoMaximo = tamanhoMaximo;
    }


    public void inserir(int elemento) {
        if (Cheia()) {
            System.out.println("Erro: Fila cheia!");
            return;
        }

        fila[fim] = elemento;
        fim = (fim + 1) % tamanhoMaximo;
    }
    
    public int remover() {
        if (Vazia()) {
            System.out.println("Erro: Fila vazia!");
            return -1;
        }

        int elementoRemovido = fila[inicio];
        inicio = (inicio + 1) % tamanhoMaximo;
        return elementoRemovido;
    }
    
    public boolean Vazia() {
        return inicio == fim;
    }

    public boolean Cheia() {
        return (fim + 1) % tamanhoMaximo == inicio;
    }

    public void mostrarFila() {
        if (Vazia()) {
            System.out.println("Fila vazia!");
            return;
        }

        System.out.print("Fila: ");
        for (int i = inicio; i != fim; i = (i + 1) % tamanhoMaximo) {
            System.out.print(fila[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho máximo da fila: ");
        int tamanhoMaximo = scanner.nextInt();

        Fila fila = new Fila(tamanhoMaximo);

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir elemento");
            System.out.println("2. Remover elemento");
            System.out.println("3. Mostrar fila");
            System.out.println("4. Sair");
            System.out.print("Digite a opção desejada: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido: ");
                    int elemento = scanner.nextInt();
                    fila.inserir(elemento);
                    break;
                case 2:
                    int elementoRemovido = fila.remover();
                    if (elementoRemovido != -1) {
                        System.out.println("Elemento removido: " + elementoRemovido);
                    }
                    break;
                case 3:
                    fila.mostrarFila();
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
