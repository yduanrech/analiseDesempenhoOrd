public class CountingSort {
    public static void main(String[] args) {
        double totalTempo = 0;
        for (int k = 0; k < 10; k++) {
            int[] vetor = new int[100000];
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = (int) (Math.random() * vetor.length);
            }
            
            long inicio = System.nanoTime();
            countingSort(vetor);
            long fim = System.nanoTime();
            double tempoExecucao = (fim - inicio) / 1.0e6;
            totalTempo += tempoExecucao;
            System.out.printf("Tempo de execução %d: %.2f ms%n", (k + 1), tempoExecucao);
        }
        System.out.printf("Tempo médio em milisegundos: %.2f ms%n", (totalTempo / 10));
    }

    public static void countingSort(int[] vetor) {
        int max = getMax(vetor);
        int[] count = new int[max + 1];
        int[] output = new int[vetor.length];

        for (int i = 0; i < vetor.length; i++) {
            count[vetor[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = vetor.length - 1; i >= 0; i--) {
            output[count[vetor[i]] - 1] = vetor[i];
            count[vetor[i]]--;
        }

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = output[i];
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
}