import java.util.Scanner;

public class q13 {
    public static void main(String[] args) {
        final int NUM_PESSOAS = 15;

        double[] somaPeso = new double[4];
        int[] countPessoas = new int[4];
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--- Média de Peso por Faixa Etária (15 Pessoas) ---");

            for (int i = 1; i <= NUM_PESSOAS; i++) {
                System.out.println("\n--- Pessoa " + i + "/" + NUM_PESSOAS + " ---");
                
                int idade;
                double peso;

                while (true) {
                    try {
                        System.out.print("Idade: ");
                        idade = scanner.nextInt();
                        System.out.print("Peso (kg): ");
                        peso = scanner.nextDouble();
                        
                        if (idade <= 0 || peso <= 0) {
                            System.out.println("Valores inválidos.");
                            continue;
                        }
                        break;
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Entrada numérica inválida.");
                        scanner.next();
                    }
                }

                if (idade >= 1 && idade <= 10) {
                    somaPeso[0] += peso;
                    countPessoas[0]++;
                } else if (idade >= 11 && idade <= 20) {
                    somaPeso[1] += peso;
                    countPessoas[1]++;
                } else if (idade >= 21 && idade <= 30) {
                    somaPeso[2] += peso;
                    countPessoas[2]++;
                } else {
                    somaPeso[3] += peso;
                    countPessoas[3]++;
                }
            }
        }

        System.out.println("\n--- Resultados ---");

        double media1 = (countPessoas[0] > 0) ? somaPeso[0] / countPessoas[0] : 0.0;
        System.out.printf("Média de peso (1 a 10 anos): %.2f kg\n", media1);

        double media2 = (countPessoas[1] > 0) ? somaPeso[1] / countPessoas[1] : 0.0;
        System.out.printf("Média de peso (11 a 20 anos): %.2f kg\n", media2);

        double media3 = (countPessoas[2] > 0) ? somaPeso[2] / countPessoas[2] : 0.0;
        System.out.printf("Média de peso (21 a 30 anos): %.2f kg\n", media3);

        double media4 = (countPessoas[3] > 0) ? somaPeso[3] / countPessoas[3] : 0.0;
        System.out.printf("Média de peso (Acima de 31 anos): %.2f kg\n", media4);
    }
}
