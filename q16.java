import java.util.Scanner;

public class q16 {
    public static void main(String[] args) {
        int somaIdades = 0;
        int countIdades = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Cálculo de Média de Idades (Finaliza com idade = 0) ---");

        while (true) {
            int idade;
            try {
                System.out.print("Digite a idade (0 para finalizar): ");
                idade = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next();
                continue;
            }

            if (idade == 0) {
                break;
            }
            
            if (idade > 0) {
                somaIdades += idade;
                countIdades++;
            } else {
                System.out.println("Idade negativa inválida (use 0 para finalizar).");
            }
        }

        System.out.println("\n--- Resultados ---");
        double media = (countIdades > 0) ? (double) somaIdades / countIdades : 0.0;
        System.out.printf("Média das idades: %.2f anos\n", media);
    }
}
