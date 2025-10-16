import java.util.Scanner;

public class q10 {
    
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
        int somaPares = 0;
        int somaPrimos = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--- Soma de Pares e Primos (10 Números) ---");

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

                if (num % 2 == 0) {
                    somaPares += num;
                }

                if (isPrime(num)) {
                    somaPrimos += num;
                }
            }
        }

        System.out.println("\n--- Resultados ---");
        System.out.println("Soma dos números pares: " + somaPares);
        System.out.println("Soma dos números primos: " + somaPrimos);
    }
}
