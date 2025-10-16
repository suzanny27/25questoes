import java.util.Scanner;

public class q15 {
    public static void main(String[] args) {
        final int NUM_PESSOAS = 10;
        int countSim = 0;
        int countNao = 0;
        int countMulheresSim = 0;
        int countHomens = 0;
        int countHomensNao = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Pesquisa de Mercado (10 Pessoas) ---");
        System.out.println("Sexo: M/F. Resposta: S/N.");

        for (int i = 1; i <= NUM_PESSOAS; i++) {
            System.out.println("\n--- Pessoa " + i + "/" + NUM_PESSOAS + " ---");

            String sexo;
            while (true) {
                System.out.print("Sexo (M/F): ");
                sexo = scanner.next().trim().toUpperCase();
                if (sexo.equals("M") || sexo.equals("F")) {
                    break;
                }
                System.out.println("Sexo inválido.");
            }

            String resposta;
            while (true) {
                System.out.print("Resposta (S/N): ");
                resposta = scanner.next().trim().toUpperCase();
                if (resposta.equals("S") || resposta.equals("N")) {
                    break;
                }
                System.out.println("Resposta inválida.");
            }

            if (sexo.equals("M")) {
                countHomens++;
            }
            
            if (resposta.equals("S")) {
                countSim++;
                if (sexo.equals("F")) {
                    countMulheresSim++;
                }
            } else if (resposta.equals("N")) {
                countNao++;
                if (sexo.equals("M")) {
                    countHomensNao++;
                }
            }
        }

        System.out.println("\n--- Resultados ---");

        System.out.println("Número de pessoas que responderam 'sim': " + countSim);
        System.out.println("Número de pessoas que responderam 'não': " + countNao);
        System.out.println("Número de mulheres que responderam 'sim': " + countMulheresSim);

        double porcHomensNao = (countHomens > 0) ? (double) countHomensNao / countHomens * 100 : 0.0;
        System.out.printf("Porcentagem de homens que responderam 'não' entre todos os homens: %.2f%%\n", porcHomensNao);
    }
}
