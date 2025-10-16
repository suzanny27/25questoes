import java.util.Scanner;

public class q22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double somaAltura = 0.0;
        int countPessoas = 0;
        int idade = -1;

        System.out.println("--- Média de Altura (Maiores de 50 Anos) ---");
        System.out.println("Digite idade <= 0 para encerrar.");

        while (true) {
            try {
                System.out.print("Idade: ");
                idade = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro para a idade.");
                scanner.next();
                continue;
            }

            if (idade <= 0) {
                break;
            }

            double altura;
            try {
                System.out.print("Altura (m): ");
                altura = scanner.nextDouble();
                if (altura <= 0) {
                    System.out.println("Altura deve ser positiva. Pessoa ignorada.");
                    continue;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico para a altura. Pessoa ignorada.");
                scanner.next();
                continue;
            }
            
            if (idade > 50) {
                somaAltura += altura;
                countPessoas++;
            }
        }

        System.out.println("\n--- Resultado ---");
        double media = (countPessoas > 0) ? somaAltura / countPessoas : 0.0;
        
        System.out.println("Total de pessoas com mais de 50 anos: " + countPessoas);
        if (countPessoas > 0) {
            System.out.printf("Média das alturas dessas pessoas: %.2f m\n", media);
        } else {
            System.out.println("Não há pessoas com mais de 50 anos para calcular a média de altura.");
        }
    }
}
