import java.util.Scanner;

public class q25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int codigoCliente;
        int tipoInvestimento = -1;
        double valorInvestido;
        double totalInvestidoGeral = 0.0;
        double totalJurosGeral = 0.0;
        double taxa = 0.0;
        String nomeInvestimento = "";

        System.out.println("--- Rendimento Mensal de Investimentos ---");
        System.out.println("Tipos: 1 (Poupança), 2 (Plus), 3 (Renda Fixa). 0 no código do cliente para encerrar.");

        while (true) {
            try {
                System.out.print("\nCódigo do Cliente (0 para sair): ");
                codigoCliente = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida para o código. Digite um número inteiro.");
                scanner.next();
                continue;
            }

            if (codigoCliente == 0) {
                break;
            }
            
            while (true) {
                try {
                    System.out.print("Tipo de Investimento (1, 2 ou 3): ");
                    tipoInvestimento = scanner.nextInt();
                    if (tipoInvestimento >= 1 && tipoInvestimento <= 3) {
                        break;
                    }
                    System.out.println("Tipo inválido. Digite 1, 2 ou 3.");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite um número inteiro.");
                    scanner.next();
                }
            }
            
            while (true) {
                try {
                    System.out.print("Valor Investido (R$): ");
                    valorInvestido = scanner.nextDouble();
                    if (valorInvestido > 0) {
                        break;
                    }
                    System.out.println("Valor deve ser positivo.");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite um valor numérico.");
                    scanner.next();
                }
            }

            switch (tipoInvestimento) {
                case 1:
                    taxa = 0.015;
                    nomeInvestimento = "Poupança";
                    break;
                case 2:
                    taxa = 0.020;
                    nomeInvestimento = "Plus";
                    break;
                case 3:
                    taxa = 0.040;
                    nomeInvestimento = "Renda Fixa";
                    break;
            }

            double rendimento = valorInvestido * taxa;

            System.out.printf("Cliente %d: Investimento em %s (%.1f%%)\n", codigoCliente, nomeInvestimento, taxa * 100);
            System.out.printf("Rendimento Mensal: R$ %.2f\n", rendimento);

            totalInvestidoGeral += valorInvestido;
            totalJurosGeral += rendimento;
        }

        System.out.println("\n--- Relatório Final ---");
        System.out.printf("Total Geral Investido: R$ %.2f\n", totalInvestidoGeral);
        System.out.printf("Total Geral de Juros (Rendimento): R$ %.2f\n", totalJurosGeral);
    }
}
