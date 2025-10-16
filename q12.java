import java.util.Scanner;

public class q12 {
    
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        final int NUM_NUMEROS = 10;
        int countPrimos = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Contagem de Números Primos (10 Números) ---");

        for (int i = 1; i <= NUM_NUMEROS; i++) {
            int num;
            while (true) {
                try {
                    System.out.print("Digite o número " + i + ": ");
                    num = scanner.nextInt();
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite um número inteiro.");
                    scanner.next(); 
                }
            }

            if (isPrime(num)) {
                countPrimos++;
            }
        }

        System.out.println("\n--- Resultados ---");
        System.out.println("Quantidade de números primos digitados: " + countPrimos);
    }
}
