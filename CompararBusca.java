import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vetor NÃO ordenado (para teste da busca linear não ordenada)
        int[] vetorNaoOrdenado = {12, 5, 9, 1, 20, 7, 60, 25, 33, 81, 36, 3, 56, 99 , 21, 5, 31};

        // Vetor ORDENADO (para teste da linear ordenada e binária)
        int[] vetorOrdenado = {1, 3, 5, 7, 9, 12, 20, 26, 31, 36, 44, 56, 72, 88, 90, 99, 105};

        // Valor de entrada que vai ser procurado dentro dos vetores
        System.out.println("Digite o valor que deseja buscar:");
        int valorScanner = scanner.nextInt();

        // Testa busca linear não ordenada
        Resultado resultado1 = BuscaLinearNaoOrdenada.busca(vetorNaoOrdenado, valorScanner);
        if (resultado1.posicao != -1)
            System.out.println("Busca Linear (não ordenado): encontrado na posição " + resultado1.posicao);
        else
            System.out.println("Busca Linear (não ordenado): não encontrado");
        System.out.println("Comparações feitas: " + resultado1.comparacoes);

        // Testa busca linear ordenada
        Resultado resultado2 = BuscaLinearOrdenada.busca(vetorOrdenado, valorScanner);
        if (resultado2.posicao != -1)
            System.out.println("Busca Linear (ordenado): encontrado na posição " + resultado2.posicao);
        else
            System.out.println("Busca Linear (ordenado): não encontrado");
        System.out.println("Comparações feitas: " + resultado2.comparacoes);

        // Testa busca binária
        Resultado resultado3 = BuscaBinaria.busca(vetorOrdenado, valorScanner);
        if (resultado3.posicao != -1)
            System.out.println("Busca Binária (ordenado): encontrado na posição " + resultado3.posicao);
        else
            System.out.println("Busca Binária (ordenado): não encontrado");
        System.out.println("Comparações feitas: " + resultado3.comparacoes);
    }
}

// Classe auxiliar para guardar posição encontrada + número de comparações
class Resultado {
    int posicao;
    int comparacoes;

    Resultado(int posicao, int comparacoes) {
        this.posicao = posicao;
        this.comparacoes = comparacoes;
    }
}

// Busca Linear Vetor Não Ordenado
class BuscaLinearNaoOrdenada {
    public static Resultado busca(int[] vetor, int valorScanner) {
        int comparacoes = 0;
        for (int i = 0; i < vetor.length; i++) {
            comparacoes++;
            if (vetor[i] == valorScanner) {
                return new Resultado(i, comparacoes);
            }
        }
        return new Resultado(-1, comparacoes);
    }
}

// Busca Linear Vetor Ordenado
class BuscaLinearOrdenada {
    public static Resultado busca(int[] vetor, int valorScanner) {
        int comparacoes = 0;
        for (int i = 0; i < vetor.length; i++) {
            comparacoes++;
            if (vetor[i] == valorScanner) {
                return new Resultado(i, comparacoes);
            }
            if (vetor[i] > valorScanner) {
                break; // já passou do valor
            }
        }
        return new Resultado(-1, comparacoes);
    }
}

// Busca Binária Vetor Ordenado
class BuscaBinaria {
    public static Resultado busca(int[] vetor, int valorScanner) {
        int inicio = 0;
        int fim = vetor.length - 1;
        int comparacoes = 0;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            comparacoes++;

            if (vetor[meio] == valorScanner) {
                return new Resultado(meio, comparacoes);
            } else if (vetor[meio] < valorScanner) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return new Resultado(-1, comparacoes);
    }
}
