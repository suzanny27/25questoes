import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        final int NUM_PESSOAS = 6;
        int countCrit1 = 0;
        int somaIdadeAlturaMenor150 = 0;
        int countAlturaMenor150 = 0;
        int countOlhosAzuis = 0;
        int countRuivoNaoAzul = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Análise Demográfica (6 Pessoas) ---");
        System.out.println("Cor dos Olhos: (A)zul, (P)reto, (V)erde, (C)ast.");
        System.out.println("Cor dos Cabelos: (P)reto, (C)ast., (L)oiro, (R)uivo.");

        for (int i = 1; i <= NUM_PESSOAS; i++) {
            System.out.println("\n--- Pessoa " + i + "/" + NUM_PESSOAS + " ---");
            
            int idade;
            double peso;
            double altura;
            String olhos;
            String cabelos;

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
            scanner.nextLine(); 

            while (true) {
                System.out.print("Cor dos Olhos (A, P, V, C): ");
                olhos = scanner.nextLine().trim().toUpperCase();
                if (olhos.equals("A") || olhos.equals("P") || olhos.equals("V") || olhos.equals("C")) {
                    break;
                }
                System.out.println("Opção inválida para olhos.");
            }
            
            while (true) {
                System.out.print("Cor dos Cabelos (P, C, L, R): ");
                cabelos = scanner.nextLine().trim().toUpperCase();
                if (cabelos.equals("P") || cabelos.equals("C") || cabelos.equals("L") || cabelos.equals("R")) {
                    break;
                }
                System.out.println("Opção inválida para cabelos.");
            }

            if (idade > 50 && peso < 60) {
                countCrit1++;
            }

            if (altura < 1.50) {
                somaIdadeAlturaMenor150 += idade;
                countAlturaMenor150++;
            }

            if (olhos.equals("A")) {
                countOlhosAzuis++;
            }

            if (cabelos.equals("R") && !olhos.equals("A")) {
                countRuivoNaoAzul++;
            }
        }

        double mediaIdadeAlturaMenor150 = (countAlturaMenor150 > 0) ? 
            ((double) somaIdadeAlturaMenor150 / countAlturaMenor150) : 0.0;
        double porcentagemOlhosAzuis = (double) countOlhosAzuis / NUM_PESSOAS * 100;

        System.out.println("\n--- Resultados ---");
        System.out.println("Pessoas com idade > 50 e peso < 60 kg: " + countCrit1);
        System.out.printf("Média das idades (altura < 1,50 m): %.2f anos\n", mediaIdadeAlturaMenor150);
        System.out.printf("Porcentagem de pessoas com olhos azuis: %.2f%%\n", porcentagemOlhosAzuis);
        System.out.println("Pessoas ruivas que não possuem olhos azuis: " + countRuivoNaoAzul);
    }
}
