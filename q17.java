import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class q17 {
    public static void main(String[] args) {
        Map<Integer, Integer> audiencia = new HashMap<>();
        audiencia.put(4, 0);
        audiencia.put(5, 0);
        audiencia.put(7, 0);
        audiencia.put(12, 0);
        int totalTelespectadores = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Cálculo de Porcentagem de Audiência (Finaliza com canal = 0) ---");

        while (true) {
            int canal;
            try {
                System.out.print("Digite o número do canal (4, 5, 7, 12) ou 0 para finalizar: ");
                canal = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next();
                continue;
            }

            if (canal == 0) {
                break;
            }

            if (audiencia.containsKey(canal)) {
                int telespectadores;
                while (true) {
                    try {
                        System.out.printf("Digite a quantidade de telespectadores do canal %d: ", canal);
                        telespectadores = scanner.nextInt();
                        if (telespectadores >= 0) {
                            break;
                        }
                        System.out.println("Quantidade deve ser não negativa.");
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Entrada inválida.");
                        scanner.next();
                    }
                }

                audiencia.put(canal, audiencia.get(canal) + telespectadores);
                totalTelespectadores += telespectadores;
            } else {
                System.out.println("Canal inválido. Digite 4, 5, 7 ou 12.");
            }
        }

        System.out.println("\n--- Resultados de Audiência ---");

        if (totalTelespectadores > 0) {
            for (Map.Entry<Integer, Integer> entry : audiencia.entrySet()) {
                int canal = entry.getKey();
                int count = entry.getValue();
                double porcentagem = (double) count / totalTelespectadores * 100;
                System.out.printf("Canal %d: %.2f%% (%d telespectadores)\n", canal, porcentagem, count);
            }
        } else {
            System.out.println("Nenhuma audiência registrada.");
        }
    }
}
