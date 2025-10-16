import java.util.Scanner;

public class q04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        System.out.println("--- Tabuada Simples ---");
        while (true) {
            try {
                System.out.print("Digite um número: ");
                numero = scanner.nextInt();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next();
            }
        }

        System.out.println("\nTabuada do " + numero + ":");
        for (int i = 0; i <= 10; i++) {
            int resultado = numero * i;
            System.out.printf("%d x %2d = %d\n", numero, i, resultado);
        }
    }
}
