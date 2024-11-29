public class QuickSort {
    public static void main(String[] args) {
        double totalTempo = 0;
        for (int k = 0; k < 10; k++) {
            int[] vetor = new int[100000];
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = (int) (Math.random() * vetor.length);
            }
            
            long inicio = System.nanoTime();
            quickSort(vetor, 0, vetor.length - 1);
            long fim = System.nanoTime();
            double tempoExecucao = (fim - inicio) / 1.0e6;
            totalTempo += tempoExecucao;
            System.out.printf("Tempo de execução %d: %.2f ms%n", (k + 1), tempoExecucao);
        }
        System.out.printf("Tempo médio em milisegundos: %.2f ms%n", (totalTempo / 10));
    }

    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIndex = particionar(vetor, inicio, fim);
            quickSort(vetor, inicio, pivoIndex - 1);
            quickSort(vetor, pivoIndex + 1, fim);
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim];
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++) {
            if (vetor[j] <= pivo) {
                i++;
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        return i + 1;
    }
}