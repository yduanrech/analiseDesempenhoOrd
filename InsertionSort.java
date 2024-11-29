public class InsertionSort {
    public static void main(String[] args) {
        double totalTempo = 0;
        for (int k = 0; k < 10; k++) {
            int[] vetor = new int[100000];
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = (int) (Math.random() * vetor.length);
            }
            
            long inicio = System.nanoTime();
            insertionSort(vetor);
            long fim = System.nanoTime();
            double tempoExecucao = (fim - inicio) / 1.0e6;
            totalTempo += tempoExecucao;
            System.out.printf("Tempo de execução %d: %.2f ms%n", (k + 1), tempoExecucao);
        }
        System.out.printf("Tempo médio em milisegundos: %.2f ms%n", (totalTempo / 10));
    }

    public static void insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int key = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > key) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = key;
        }
    }
}