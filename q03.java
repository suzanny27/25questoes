import java.util.Scanner;

public class q03 {
    public static void main(String[] args) {
        final int NUM_PESSOAS = 8;
        int[] contadoresFaixa = new int[5];
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Cálculo de Faixa Etária (8 Pessoas) ---");

        for (int i = 1; i <= NUM_PESSOAS; i++) {
            int idade;
            while (true) {
                try {
                    System.out.print("Digite a idade da pessoa " + i + ": ");
                    idade = scanner.nextInt();
                    if (idade < 0) {
                        System.out.println("Idade não pode ser negativa. Tente novamente.");
                        continue;
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite um número inteiro.");
                    scanner.next();
                }
            }

            if (idade <= 15) {
                contadoresFaixa[0]++;
            } else if (idade <= 30) {
                contadoresFaixa[1]++;
            } else if (idade <= 45) {
                contadoresFaixa[2]++;
            } else if (idade <= 60) {
                contadoresFaixa[3]++;
            } else {
                contadoresFaixa[4]++;
            }
        }

        System.out.println("\n--- Resultados ---");
        System.out.println("Quantidade de pessoas em cada faixa:");
        System.out.println("1ª Faixa (Até 15 anos): " + contadoresFaixa[0] + " pessoas");
        System.out.println("2ª Faixa (16 a 30 anos): " + contadoresFaixa[1] + " pessoas");
        System.out.println("3ª Faixa (31 a 45 anos): " + contadoresFaixa[2] + " pessoas");
        System.out.println("4ª Faixa (46 a 60 anos): " + contadoresFaixa[3] + " pessoas");
        System.out.println("5ª Faixa (Acima de 60 anos): " + contadoresFaixa[4] + " pessoas");

        double total = NUM_PESSOAS;
        int primeiraFaixa = contadoresFaixa[0];
        int ultimaFaixa = contadoresFaixa[4];

        double porcentagemPrimeira = (total > 0) ? (primeiraFaixa / total) * 100 : 0.0;
        double porcentagemUltima = (total > 0) ? (ultimaFaixa / total) * 100 : 0.0;

        System.out.printf("\nPorcentagem na 1ª Faixa (Até 15 anos): %.2f%%\n", porcentagemPrimeira);
        System.out.printf("Porcentagem na 5ª Faixa (Acima de 60 anos): %.2f%%\n", porcentagemUltima);
    }
}
