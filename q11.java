import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

public class q11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double valorCarro;

        System.out.println("--- Financiamento de Carro ---");

        while (true) {
            try {
                System.out.print("Digite o valor do carro: R$ ");
                valorCarro = scanner.nextDouble();
                if (valorCarro <= 0) {
                    System.out.println("Valor deve ser positivo.");
                    continue;
                }
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico.");
                scanner.next(); 
            }
        }

        Map<Integer, Double> tabelaAcrescimo = new LinkedHashMap<>();
        tabelaAcrescimo.put(6, 0.03); 
        tabelaAcrescimo.put(12, 0.06);
        tabelaAcrescimo.put(18, 0.09);
        tabelaAcrescimo.put(24, 0.12);
        tabelaAcrescimo.put(30, 0.15);
        tabelaAcrescimo.put(36, 0.18);
        tabelaAcrescimo.put(42, 0.21);
        tabelaAcrescimo.put(48, 0.24);
        tabelaAcrescimo.put(54, 0.27);
        tabelaAcrescimo.put(60, 0.30);

        System.out.println("\n--- Tabela de Preços e Parcelas ---");
        System.out.println("Parcelas | Acréscimo | Preço Final (R$) | Valor da Parcela (R$)");
        System.out.println("---------------------------------------------------------------");

        double valorAvista = valorCarro * 0.80;
        System.out.printf("%8s | %9s | %16.2f | %21s\n", "À Vista", "-", valorAvista, "-");

        for (Map.Entry<Integer, Double> entry : tabelaAcrescimo.entrySet()) {
            int parcelas = entry.getKey();
            double acrescimoPercentual = entry.getValue();
            
            double precoFinal = valorCarro * (1 + acrescimoPercentual);
            double valorParcela = precoFinal / parcelas;
            String acrescimoDisplay = String.format("%.0f%%", acrescimoPercentual * 100);
            
            System.out.printf("%8d | %9s | %16.2f | %21.2f\n", parcelas, acrescimoDisplay, precoFinal, valorParcela);
        }
    }
}
