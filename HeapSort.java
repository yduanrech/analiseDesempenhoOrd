public class HeapSort {
    public static void main(String[] args) {
        double totalTempo = 0;
        for (int k = 0; k < 10; k++) {
            int[] vetor = new int[100000];
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = (int) (Math.random() * vetor.length);
            }
            
            long inicio = System.nanoTime();
            heapSort(vetor);
            long fim = System.nanoTime();
            double tempoExecucao = (fim - inicio) / 1.0e6;
            totalTempo += tempoExecucao;
            System.out.printf("Tempo de execução %d: %.2f ms%n", (k + 1), tempoExecucao);
        }
        System.out.printf("Tempo médio em milisegundos: %.2f ms%n", (totalTempo / 10));
    }

    public static void heapSort(int[] vetor) {
        int n = vetor.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(vetor, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;

            heapify(vetor, i, 0);
        }
    }

    private static void heapify(int[] vetor, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && vetor[esquerda] > vetor[maior]) {
            maior = esquerda;
        }

        if (direita < n && vetor[direita] > vetor[maior]) {
            maior = direita;
        }

        if (maior != i) {
            int swap = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = swap;

            heapify(vetor, n, maior);
        }
    }
}
