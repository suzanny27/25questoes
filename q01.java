import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class q01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUM_GRUPOS = 5;

        System.out.println("Início do Exercício 1: Ordenação de Valores");

        for (int i = 1; i <= NUM_GRUPOS; i++) {
            System.out.println("\n***** Grupo " + i + "/" + NUM_GRUPOS + " *****");
            
            Integer[] valores = new Integer[4];
            
            while (true) {
                try {
                    System.out.print("Digite 4 valores inteiros (A B C D): ");
                    for (int j = 0; j < 4; j++) {
                        valores[j] = scanner.nextInt();
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite apenas números inteiros.");
                    scanner.nextLine();
                }
            }
            
            System.out.println("Ordem lida: " + Arrays.toString(valores));

            Arrays.sort(valores);
            System.out.println("Ordem crescente: " + Arrays.toString(valores));

            Arrays.sort(valores, Collections.reverseOrder());
            System.out.println("Ordem decrescente: " + Arrays.toString(valores));
        }
        
        System.out.println("Fim do Exercício 1");
    }
}
