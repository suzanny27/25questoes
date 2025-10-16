import java.util.Scanner;

public class q20 {

    public static void mediaAritmetica(Scanner scanner) {
        System.out.println("\n--- Média Aritmética ---");
        try {
            System.out.print("Digite a primeira nota: ");
            double n1 = scanner.nextDouble();
            System.out.print("Digite a segunda nota: ");
            double n2 = scanner.nextDouble();

            double media = (n1 + n2) / 2.0;
            System.out.printf("A Média Aritmética é: %.2f\n", media);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida. Tente novamente.");
            scanner.nextLine();
        }
    }

    public static void mediaPonderada(Scanner scanner) {
        System.out.println("\n--- Média Ponderada ---");
        try {
            System.out.print("Digite a primeira nota: ");
            double n1 = scanner.nextDouble();
            System.out.print("Digite o peso da primeira nota: ");
            double p1 = scanner.nextDouble();

            System.out.print("Digite a segunda nota: ");
            double n2 = scanner.nextDouble();
            System.out.print("Digite o peso da segunda nota: ");
            double p2 = scanner.nextDouble();

            System.out.print("Digite a terceira nota: ");
            double n3 = scanner.nextDouble();
            System.out.print("Digite o peso da terceira nota: ");
            double p3 = scanner.nextDouble();

            double numerador = (n1 * p1) + (n2 * p2) + (n3 * p3);
            double denominador = p1 + p2 + p3;
            
            if (denominador > 0) {
                double media = numerador / denominador;
                System.out.printf("A Média Ponderada é: %.2f\n", media);
            } else {
                System.out.println("Soma dos pesos é zero. Não é possível calcular a média.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida. Tente novamente.");
            scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n--- Menu de Opções ---");
            System.out.println("1. Média Aritmética");
            System.out.println("2. Média Ponderada");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1:
                        mediaAritmetica(scanner);
                        break;
                    case 2:
                        mediaPonderada(scanner);
                        break;
                    case 3:
                        System.out.println("Saindo do programa.");
                        break;
                    default:
                        System.out.println("Opção inválida. Digite 1, 2 ou 3.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro para a opção.");
                scanner.next();
                opcao = 0;
            }
        } while (opcao != 3);
    }
}
