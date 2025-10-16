import java.util.Scanner;

public class q07 {
    public static void main(String[] args) {
        final int NUM_PESSOAS = 5;
        int countIdadeSuperior50 = 0;
        double somaAltura10A20 = 0.0;
        int countAltura10A20 = 0;
        int countPesoInferior40 = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Análise de Dados Pessoais (5 Pessoas) ---");

        for (int i = 1; i <= NUM_PESSOAS; i++) {
            System.out.println("\n--- Pessoa " + i + "/" + NUM_PESSOAS + " ---");
            
            int idade;
            double altura;
            double peso;

            while (true) {
                try {
                    System.out.print("Idade: ");
                    idade = scanner.nextInt();
                    System.out.print("Altura (m): ");
                    altura = scanner.nextDouble();
                    System.out.print("Peso (kg): ");
                    peso = scanner.nextDouble();
                    
                    if (idade < 0 || altura <= 0 || peso <= 0) {
                        System.out.println("Valores inválidos. Digite novamente.");
                        continue;
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                    scanner.next(); 
                }
            }

            if (idade > 50) {
                countIdadeSuperior50++;
            }

            if (idade >= 10 && idade <= 20) {
                somaAltura10A20 += altura;
                countAltura10A20++;
            }

            if (peso < 40) {
                countPesoInferior40++;
            }
        }

        double mediaAltura10A20 = (countAltura10A20 > 0) ? (somaAltura10A20 / countAltura10A20) : 0.0;
        double porcentagemPesoInferior40 = (double) countPesoInferior40 / NUM_PESSOAS * 100;

        System.out.println("\n--- Resultados ---");
        System.out.println("Pessoas com idade superior a 50 anos: " + countIdadeSuperior50);
        System.out.printf("Média das alturas (10-20 anos): %.2f m\n", mediaAltura10A20);
        System.out.printf("Porcentagem com peso inferior a 40 kg: %.2f%%\n", porcentagemPesoInferior40);
    }
}
