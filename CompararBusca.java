import java.util.Random;
import java.util.Arrays;

public class CompararBusca {

    // Busca Linear para vetor não ordenado
    public static int buscaLinearNaoOrdenado(int[] vetor, int valorBuscado) {
        //Contador de operações
        int operacoes = 0;
        //Laço for até encontrar o valor procurado.
        for (int i = 0; i < vetor.length; i++) {
            operacoes++;
            if (vetor[i] == valorBuscado) {
                System.out.println("Busca Linear (não ordenado): elemento encontrado na posição " + i);
                System.out.println("Operações realizadas: " + operacoes);
                return i;
            }
        }
        //Caso não seja encontrado no vetor
        return -1;
    }

    // Busca Linear para vetor ordenado
    public static int buscaLinearOrdenado(int[] vetor, int valorBuscado) {
        //Contador de operações
        int operacoes = 0;
        //Laço for até encontrar o valor procurado.
        for (int i = 0; i < vetor.length; i++) {
            operacoes++;
            if (vetor[i] == valorBuscado) {
                System.out.println("Busca Linear (ordenado): elemento encontrado na posição " + i);
                System.out.println("Operações realizadas: " + operacoes);
                return i;
            }
        }
        //Caso não seja encontrado no vetor
        return -1;
    }

    // Busca Binária para vetor ordenado
    public static int buscaBinaria(int[] vetor, int valorBuscado) {
        //Definir posição inicial e final do vetor
        int inicio = 0;
        int fim = vetor.length - 1;

        //Contador de operações
        int operacoes = 0;

        //Loop até encontrar o valor procurado
        while (inicio <= fim) {
            operacoes++;
            int meio = (inicio + fim) / 2;

            /*
            Condicional para o valor buscado mover dentro do vetor
            -Caso
             */
            if (vetor[meio] == valorBuscado) {
                System.out.println("Busca Binária: elemento encontrado na posição " + meio);
                System.out.println("Operações realizadas: " + operacoes);
                return meio;
            } else if (vetor[meio] < valorBuscado) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        System.out.println("Busca Binária: elemento não encontrado");
        System.out.println("Operações realizadas: " + operacoes);
        return -1;
    }

    //Main
    public static void main(String[] args) {

        //Tamanho e criação do vetor
        int tamanho = 1000;
        int[] vetorNaoOrdenado = new int[tamanho];
        Random random = new Random();

        // Cria um vetor com valores de 1 a 1000 que não repete valores
        for (int i = 0; i < tamanho; i++) {
            int numero;
            boolean repetido;
            do {
                numero = random.nextInt(1000) + 1;
                repetido = false;
                //Percorre todo o vetor para verificar se existe algum valor repetido
                for (int j = 0; j < i; j++) {
                    if (vetorNaoOrdenado[j] == numero) {
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);
            vetorNaoOrdenado[i] = numero;
        }

        // Cria vetor ordenado a partir do vetor não ordenado
        int[] vetorOrdenado = vetorNaoOrdenado.clone();
        Arrays.sort(vetorOrdenado);

        //Teste
        /*
        Vão ser utilizados três posições diferentes para mostrar o comportamento de diferentes tipos de buscas.
        Os vetores tem o tamanho 1000 e serão utilizados a posição 0 do vetor, (vetor.length/2) -1  e vetor.length.
         */
        int valorInicio = vetorOrdenado[0];                // menor valor
        int indiceMeio  = (0 + (tamanho - 1)) / 2;        // índice do meio inicial da busca binária
        int valorMeio   = vetorOrdenado[indiceMeio];      // valor que será encontrado em 1 operação na binária
        int valorFim    = vetorOrdenado[tamanho - 1];     // maior valor

        System.out.println("\nBuscar o menor valor do vetor.");
        buscaLinearNaoOrdenado(vetorNaoOrdenado, valorInicio);      //Melhor caso (primeiro valor)
        buscaLinearOrdenado(vetorOrdenado, valorInicio);
        buscaBinaria(vetorOrdenado, valorInicio);

        System.out.println("\nBuscar o valor médio do vetor");
        buscaLinearNaoOrdenado(vetorNaoOrdenado, valorMeio);
        buscaLinearOrdenado(vetorOrdenado, valorMeio);                  //Caso médio
        buscaBinaria(vetorOrdenado, valorMeio);                         //Melhor caso (valor médio)

        System.out.println("\nBuscar o valor final do vetor");
        buscaLinearNaoOrdenado(vetorNaoOrdenado, valorFim);             //Pior caso (último valor)
        buscaLinearOrdenado(vetorOrdenado, valorFim);
        buscaBinaria(vetorOrdenado, valorFim);


        //Melhores, Piores e Caso Médio
        //Mostrar os melhores casos para cada tipo de busca
        System.out.println("\nMelhor caso de cada busca:");
        System.out.println("\nBusca Linear Não Ordenado:");
        //Mostra o valor que está na posição 0 do vetor não ordenado
        int valorMelhorCasoNaoOrdenado = vetorNaoOrdenado[0];
        System.out.print("O valor procurado seria: "+ valorMelhorCasoNaoOrdenado + ", Posição " + (valorInicio - 1));
        System.out.println("\nBusca Linear Ordenado:");
        System.out.println("O valor procurado seria: " + valorInicio + ", Posição " + (valorInicio - 1));
        System.out.println("Busca Binária Ordenado:");
        System.out.println("O valor procurado seria: " + valorMeio + ", Posição " + (valorMeio - 1));


        //Mostrar os piores casos para cada tipo de busca (ignorando inexistente)
        System.out.println("\nPior caso de cada busca:");
        System.out.println("\nBusca Linear Não Ordenado:");
        //Mostra o valor que está na posição 0 do vetor não ordenado
        int valorPiorCasoNaoOrdenado = vetorNaoOrdenado[0];
        System.out.print("O valor procurado seria: "+ valorPiorCasoNaoOrdenado + ", Posição " + valorFim);
        System.out.println("\nBusca Linear Ordenado:");
        System.out.println("O valor procurado seria: " + valorInicio + ", Posição " + valorFim);
        System.out.println("Busca Binária Ordenado:");
        System.out.println("O valor procurado seria: " + valorInicio + " ou " +
                valorFim + ", Posição " + (valorInicio - 1) + " ou " + (valorFim - 1));


        //Mostrar os casos médios
        System.out.println("\nCaso médio de cada busca:");
        System.out.println("\nBusca Linear Não Ordenado:");
        //Mostra o valor que está na posição 0 do vetor não ordenado
        int valorMedioCasoNaoOrdenado = vetorNaoOrdenado[vetorNaoOrdenado.length - 1];
        System.out.print("O valor procurado seria: "+ valorMedioCasoNaoOrdenado + ", Posição " + valorMeio);
        System.out.println("\nBusca Linear Ordenado:");
        System.out.println("O valor procurado seria: " + valorMeio + ", Posição " + (valorMeio - 1));
        System.out.println("Busca Binária Ordenado:");
        System.out.println("O valor procurado não seria exato entretanto é possível estimar:\n");
        System.out.println("Usar O(log n): Log2(1000) aproximadamente 8.997");
    }
}
