import java.util.Scanner;

public class q09 {
    public static void main(String[] args) {
        final int NUM_PESSOAS = 10;
        int somaIdades = 0;
        int countPesoCrit = 0;
        int countAlturaAcima190 = 0;
        int countCritFinal = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Estatísticas de Grupo (10 Pessoas) ---");

        for (int i = 1; i <= NUM_PESSOAS; i++) {
            System.out.println("\n--- Pessoa " + i + "/" + NUM_PESSOAS + " ---");
            
            int idade;
            double peso;
            double altura;

            while (true) {
                try {
                    System.out.print("Idade: ");
                    idade = scanner.nextInt();
                    System.out.print("Peso (kg): ");
                    peso = scanner.nextDouble();
                    System.out.print("Altura (m): ");
                    altura = scanner.nextDouble();
                    
                    if (idade < 0 || peso <= 0 || altura <= 0) {
                        System.out.println("Valores inválidos.");
                        continue;
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada numérica inválida.");
                    scanner.next(); 
                }
            }

            somaIdades += idade;

            if (peso > 90 && altura < 1.50) {
                countPesoCrit++;
            }

            if (altura > 1.90) {
                countAlturaAcima190++;
                if (idade >= 10 && idade <= 30) {
                    countCritFinal++;
                }
            }
        }

        double mediaIdades = (double) somaIdades / NUM_PESSOAS;
        double porcCritFinal = (countAlturaAcima190 > 0) ? 
            ((double) countCritFinal / countAlturaAcima190 * 100) : 0.0;

        System.out.println("\n--- Resultados ---");
        System.out.printf("Média das idades: %.2f anos\n", mediaIdades);
        System.out.println("Pessoas com peso > 90 kg e altura < 1,50 m: " + countPesoCrit);
        System.out.printf("Porcentagem de pessoas com idade entre 10 e 30 anos entre as que medem mais de 1,90 m: %.2f%%\n", porcCritFinal);
    }
}