import java.util.Scanner;

public class q21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] votosCandidato = new int[4];
        int votosNulos = 0;
        int votosBrancos = 0;
        int totalVotos = 0;
        int voto = -1;

        System.out.println("--- Contabilização de Votos ---");
        System.out.println("Códigos: 1-4 (Candidatos), 5 (Nulo), 6 (Branco), 0 (Fim)");

        while (voto != 0) {
            try {
                System.out.print("Digite seu voto: ");
                voto = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Voto inválido. Digite um número inteiro.");
                scanner.next();
                continue;
            }

            if (voto >= 1 && voto <= 4) {
                votosCandidato[voto - 1]++;
                totalVotos++;
            } else if (voto == 5) {
                votosNulos++;
                totalVotos++;
            } else if (voto == 6) {
                votosBrancos++;
                totalVotos++;
            } else if (voto != 0) {
                System.out.println("Voto fora dos códigos válidos. Ignorado.");
            }
        }

        System.out.println("\n--- Resultado Final ---");
        
        for (int i = 0; i < 4; i++) {
            System.out.println("Total de votos para o Candidato " + (i + 1) + ": " + votosCandidato[i]);
        }
        System.out.println("Total de votos Nulos (5): " + votosNulos);
        System.out.println("Total de votos Brancos (6): " + votosBrancos);
        System.out.println("Total Geral de Votos: " + totalVotos);

        if (totalVotos > 0) {
            double porcNulos = ((double) votosNulos / totalVotos) * 100;
            double porcBrancos = ((double) votosBrancos / totalVotos) * 100;
            
            System.out.printf("Porcentagem de votos Nulos: %.2f%%\n", porcNulos);
            System.out.printf("Porcentagem de votos Brancos: %.2f%%\n", porcBrancos);
        } else {
            System.out.println("Nenhum voto foi contabilizado.");
        }
    }
}
