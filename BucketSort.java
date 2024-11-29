import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        double totalTempo = 0;
        for (int k = 0; k < 10; k++) {
            int[] vetor = new int[100000];
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = (int) (Math.random() * vetor.length);
            }
            
            long inicio = System.nanoTime();
            bucketSort(vetor);
            long fim = System.nanoTime();
            double tempoExecucao = (fim - inicio) / 1.0e6;
            totalTempo += tempoExecucao;
            System.out.printf("Tempo de execução %d: %.2f ms%n", (k + 1), tempoExecucao);
        }
        System.out.printf("Tempo médio em milisegundos: %.2f ms%n", (totalTempo / 10));
    }

    public static void bucketSort(int[] vetor) {
        int n = vetor.length;
        if (n <= 0) return;

        int max = getMax(vetor);
        int bucketCount = max / 10 + 1;

        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int value : vetor) {
            int bucketIndex = value / 10;
            buckets[bucketIndex].add(value);
        }

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int value : bucket) {
                vetor[index++] = value;
            }
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