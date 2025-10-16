import java.util.Scanner;

public class q14 {
    public static void main(String[] args) {
        final int NUM_ESPECTADORES = 15;
        int somaIdadeOtimo = 0;
        int countOtimo = 0;
        int countRegular = 0;
        int countBom = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Pesquisa de Cinema (15 Espectadores) ---");
        System.out.println("Opinião: (3)Ótimo, (2)Bom, (1)Regular.");

        for (int i = 1; i <= NUM_ESPECTADORES; i++) {
            System.out.println("\n--- Espectador " + i + "/" + NUM_ESPECTADORES + " ---");

            int idade;
            while (true) {
                try {
                    System.out.print("Idade: ");
                    idade = scanner.nextInt();
                    if (idade <= 0) {
                        System.out.println("Idade inválida.");
                        continue;
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Idade inválida.");
                    scanner.next();
                }
            }

            int opiniao;
            while (true) {
                try {
                    System.out.print("Opinião (1, 2 ou 3): ");
                    opiniao = scanner.nextInt();
                    if (opiniao < 1 || opiniao > 3) {
                        System.out.println("Opinião inválida (deve ser 1, 2 ou 3).");
                        continue;
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Opinião inválida.");
                    scanner.next();
                }
            }
            
            if (opiniao == 3) {
                somaIdadeOtimo += idade;
                countOtimo++;
            } else if (opiniao == 2) {
                countBom++;
            } else if (opiniao == 1) {
                countRegular++;
            }
        }

        System.out.println("\n--- Resultados ---");

        double mediaIdadeOtimo = (countOtimo > 0) ? (double) somaIdadeOtimo / countOtimo : 0.0;
        System.out.printf("Média das idades que responderam 'ótimo': %.2f anos\n", mediaIdadeOtimo);

        System.out.println("Quantidade de pessoas que responderam 'regular': " + countRegular);

        double porcBom = (double) countBom / NUM_ESPECTADORES * 100;
        System.out.printf("Porcentagem de pessoas que responderam 'bom': %.2f%%\n", porcBom);
    }
}
