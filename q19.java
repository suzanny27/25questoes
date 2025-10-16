import java.util.Scanner;

public class q19 {
    public static void main(String[] args) {
        double lucroTotal = 0.0;
        int countLucroAlto = 0;
        int countLucroBaixo = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Estatísticas de Ações (Finaliza com Tipo de Ação 'F') ---");

        while (true) {
            System.out.println("\n--- Nova Ação ---");
            System.out.print("Digite o tipo da ação ('F' para finalizar): ");
            String tipoAcao = scanner.next().trim().toUpperCase();
            
            if (tipoAcao.equals("F")) {
                break;
            }

            double precoCompra;
            double precoVenda;
            
            while (true) {
                try {
                    System.out.print("Preço de compra por ação (R$): ");
                    precoCompra = scanner.nextDouble();
                    System.out.print("Preço de venda por ação (R$): ");
                    precoVenda = scanner.nextDouble();
                    if (precoCompra < 0 || precoVenda < 0) {
                        System.out.println("Preços não podem ser negativos.");
                        continue;
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada inválida para preço.");
                    scanner.next();
                }
            }

            double lucroPorAcao = precoVenda - precoCompra;
            lucroTotal += lucroPorAcao;

            System.out.printf("Lucro por ação '%s': R$ %.2f\n", tipoAcao, lucroPorAcao);

            if (lucroPorAcao > 1000.00) {
                countLucroAlto++;
            } else if (lucroPorAcao < 200.00) {
                countLucroBaixo++;
            }
        }

        System.out.println("\n--- Resultados Finais ---");
        System.out.printf("Lucro total obtido: R$ %.2f\n", lucroTotal);
        System.out.println("Quantidade de ações com lucro > R$ 1000,00: " + countLucroAlto);
        System.out.println("Quantidade de ações com lucro < R$ 200,00: " + countLucroBaixo);
        
        scanner.close();
    }
}