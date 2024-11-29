public class RadixSort {
    public static void main(String[] args) {
        double totalTempo = 0;
        for (int k = 0; k < 10; k++) {
            int[] vetor = new int[100000];
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = (int) (Math.random() * vetor.length);
            }
            
            long inicio = System.nanoTime();
            radixSort(vetor);
            long fim = System.nanoTime();
            double tempoExecucao = (fim - inicio) / 1.0e6;
            totalTempo += tempoExecucao;
            System.out.printf("Tempo de execução %d: %.2f ms%n", (k + 1), tempoExecucao);
        }
        System.out.printf("Tempo médio em milisegundos: %.2f ms%n", (totalTempo / 10));
    }

    public static void radixSort(int[] vetor) {
        int max = getMax(vetor);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(vetor, exp);
        }
    }

    private static int getMax(int[] vetor) {
        int max = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > max) {
                max = vetor[i];
            }
        }
        return max;
    }

    private static void countSort(int[] vetor, int exp) {
        int n = vetor.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(vetor[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(vetor[i] / exp) % 10] - 1] = vetor[i];
            count[(vetor[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            vetor[i] = output[i];
        }
    }
}
