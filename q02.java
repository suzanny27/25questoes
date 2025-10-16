import java.util.Scanner;

public class q02 {
    public static void main(String[] args) {
        final double DESPESAS_FIXAS = 200.00;
        final double PRECO_INICIAL = 5.00;
        final int VENDAS_INICIAIS = 120;
        final double PASSOS_DESCONTO = 0.50;
        final int AUMENTO_VENDAS = 26;
        final double PRECO_FINAL = 1.00;

        double lucroMaximo = -Double.MAX_VALUE;
        double melhorPreco = 0.0;
        int melhoresVendas = 0;

        System.out.println("--- Tabela de Lucros do Teatro ---");
        System.out.println("Preço (R$) | Ingressos | Receita (R$) | Lucro (R$)");
        System.out.println("-------------------------------------------------");

        double preco = PRECO_INICIAL;
        
        while (preco >= PRECO_FINAL - 0.001) {
            
            double descontoTotal = PRECO_INICIAL - preco;
            
            int numDescontos = (int) Math.round(descontoTotal / PASSOS_DESCONTO); 

            int ingressos = VENDAS_INICIAIS + (numDescontos * AUMENTO_VENDAS);
            double receita = preco * ingressos;
            double lucro = receita - DESPESAS_FIXAS;

            System.out.printf("%10.2f | %9d | %12.2f | %10.2f\n", preco, ingressos, receita, lucro);

            if (lucro > lucroMaximo) {
                lucroMaximo = lucro;
                melhorPreco = preco;
                melhoresVendas = ingressos;
            }

            preco -= PASSOS_DESCONTO;
            preco = Math.round(preco * 100.0) / 100.0;
        }

        System.out.println("\n-------------------------------------------------");
        System.out.println("RESULTADO ÓTIMO:");
        System.out.printf("Lucro Máximo: R$ %.2f\n", lucroMaximo);
        System.out.printf("Preço Correspondente: R$ %.2f\n", melhorPreco);
        System.out.println("Ingressos Vendidos: " + melhoresVendas);
    }
}
