public class BubbleSortMelhorado {
    public static void main(String[] args) {
        double totalTempo = 0;
        for (int k = 0; k < 10; k++) {
            int[] vetor = new int[50000];
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = (int) (Math.random() * vetor.length);
            }
            
            long inicio = System.nanoTime();
            bubbleSortMelhorado(vetor);
            long fim = System.nanoTime();
            double tempoExecucao = (fim - inicio) / 1.0e6;
            totalTempo += tempoExecucao;
            System.out.printf("Tempo de execução %d: %.2f ms%n", (k + 1), tempoExecucao);
        }
        System.out.printf("Tempo médio em milisegundos: %.2f ms%n", (totalTempo / 10));
    }

    public static void bubbleSortMelhorado(int[] vetor) {
        int n = vetor.length;
        int temp;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }
}