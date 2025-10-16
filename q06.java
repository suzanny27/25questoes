import java.util.Scanner;

public class q06 {
    public static void main(String[] args) {
        final int NUM_TRANSACOES = 15;
        double totalAVista = 0.0;
        double totalAPrazo = 0.0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Cálculo de Transações (15) ---");

        for (int i = 1; i <= NUM_TRANSACOES; i++) {
            System.out.println("\n--- Transação " + i + "/" + NUM_TRANSACOES + " ---");

            String codigo;
            while (true) {
                System.out.print("Digite o código ('V' para à vista, 'P' para a prazo): ");
                codigo = scanner.next().trim().toUpperCase();
                if (codigo.equals("V") || codigo.equals("P")) {
                    break;
                } else {
                    System.out.println("Código inválido. Digite 'V' ou 'P'.");
                }
            }

            double valor;
            while (true) {
                try {
                    System.out.print("Digite o valor da transação: R$ ");
                    valor = scanner.nextDouble();
                    if (valor < 0) {
                        System.out.println("Valor não pode ser negativo. Tente novamente.");
                        continue;
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite um valor numérico.");
                    scanner.next();
                }
            }

            if (codigo.equals("V")) {
                totalAVista += valor;
            } else if (codigo.equals("P")) {
                totalAPrazo += valor;
            }
        }

        System.out.println("\n--- Resultados Finais ---");
        System.out.printf("O valor total das compras à vista é: R$ %.2f\n", totalAVista);
        System.out.printf("O valor total das compras a prazo é: R$ %.2f\n", totalAPrazo);
        System.out.printf("O valor total de todas as compras é: R$ %.2f\n", totalAVista + totalAPrazo);
    }
}
