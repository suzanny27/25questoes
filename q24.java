import java.util.Scanner;

public class q24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int num = -1;
        boolean primeiroValorValido = false;

        System.out.println("--- Maior e Menor Valor Positivo ---");
        System.out.println("Digite 0 para encerrar. Valores negativos serão ignorados.");

        while (true) {
            try {
                System.out.print("Digite um valor (0 para sair): ");
                num = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next();
                continue;
            }

            if (num == 0) {
                break;
            }
            
            if (num > 0) {
                primeiroValorValido = true;
                
                if (num > maior) {
                    maior = num;
                }
                if (num < menor) {
                    menor = num;
                }
            } else if (num < 0) {
                System.out.println("Valor negativo ignorado.");
            }
        }

        System.out.println("\n--- Resultado ---");
        if (primeiroValorValido) {
            System.out.println("Maior valor positivo digitado: " + maior);
            System.out.println("Menor valor positivo digitado: " + menor);
        } else {
            System.out.println("Nenhum valor inteiro e positivo foi digitado.");
        }
    }
}
