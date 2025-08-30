public class Formulas {
    public static int buscaLinearNaoOrdenado(int[] vetor, int valorBuscado) {
        int operacoes = 0; // 1
        for (int i = 0; i < vetor.length; i++) { // n
            operacoes++; // 1
            if (vetor[i] == valorBuscado) { // n
                System.out.println("Busca Linear (não ordenado): elemento encontrado na posição " + i); // 1
                System.out.println("Operações realizadas: " + operacoes); // 1
                return i; // 1
            }
        }
        return -1; // 1
    }
    /// f(n) = 2n + 6
    /// O(n) = n

    public static int buscaLinearOrdenado(int[] vetor, int valorBuscado) {
        int operacoes = 0; // 1
        for (int i = 0; i < vetor.length; i++) { // n
            operacoes++; // 1
            if (vetor[i] == valorBuscado) { // n
                System.out.println("Busca Linear (ordenado): elemento encontrado na posição " + i); // 1
                System.out.println("Operações realizadas: " + operacoes); // 1
                return i; // 1
            } else if (vetor[i] > valorBuscado){ // n
                return -1; // 1
            }
        }
        return -1; // 1
    }

    // f(n) = 3n + 7
    // O(n) = n

    // Busca Binária para vetor ordenado
    public static int buscaBinaria(int[] vetor, int valorBuscado) {
        int inicio = 0; // 1
        int fim = vetor.length - 1; // 1
        int operacoes = 0; // 1
        while (inicio <= fim) { // log n
            operacoes++; // 1
            int meio = (inicio + fim) / 2; // 1
            if (vetor[meio] == valorBuscado) { // log n
                System.out.println("Busca Binária: elemento encontrado na posição " + meio); // 1
                System.out.println("Operações realizadas: " + operacoes); // 1
                return meio; // 1
            } else if (vetor[meio] < valorBuscado) { // log n
                inicio = meio + 1; // 1
            } else { // n
                fim = meio - 1; // 1
            }
        }

        System.out.println("Busca Binária: elemento não encontrado"); // 1
        return -1; // 1
    }

    // f(n) = 12 + 3(log n)
    // O(n) = log n
}