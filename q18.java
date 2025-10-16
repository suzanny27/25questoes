import java.util.Scanner;

public class q18 {
    public static void main(String[] args) {
        double somaSalarios = 0.0;
        int countPessoas = 0;
        int maiorIdade = -1;
        int menorIdade = Integer.MAX_VALUE;
        int countMulheresSalarioBaixo = 0;
        double menorSalario = Double.MAX_VALUE;
        String dadosMenorSalario = "N/A";
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Coleta de Dados Pessoais e Salário (Finaliza com Idade Negativa) ---");

        while (true) {
            System.out.println("\n--- Nova Pessoa ---");
            int idade;
            
            try {
                System.out.print("Idade (negativa para finalizar): ");
                idade = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Idade inválida.");
                scanner.next();
                continue;
            }

            if (idade < 0) {
                break;
            }
            
            String sexo;
            while (true) {
                System.out.print("Sexo (M/F): ");
                sexo = scanner.next().trim().toUpperCase();
                if (sexo.equals("M") || sexo.equals("F")) {
                    break;
                }
                System.out.println("Sexo inválido.");
            }

            double salario;
            while (true) {
                try {
                    System.out.print("Salário (R$): ");
                    salario = scanner.nextDouble();
                    if (salario >= 0) {
                        break;
                    }
                    System.out.println("Salário não pode ser negativo.");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Salário inválido.");
                    scanner.next();
                }
            }

            somaSalarios += salario;
            countPessoas++;

            if (idade > maiorIdade) {
                maiorIdade = idade;
            }
            if (idade < menorIdade) {
                menorIdade = idade;
            }

            if (sexo.equals("F") && salario <= 200.00) {
                countMulheresSalarioBaixo++;
            }

            if (salario < menorSalario) {
                menorSalario = salario;
                dadosMenorSalario = String.format("Idade: %d, Sexo: %s, Salário: R$ %.2f", idade, sexo, salario);
            }
        }

        System.out.println("\n--- Resultados ---");

        double mediaSalarios = (countPessoas > 0) ? somaSalarios / countPessoas : 0.0;
        System.out.printf("Média dos salários: R$ %.2f\n", mediaSalarios);

        System.out.println("Maior idade do grupo: " + (maiorIdade != -1 ? maiorIdade : "N/A"));
        System.out.println("Menor idade do grupo: " + (menorIdade != Integer.MAX_VALUE ? menorIdade : "N/A"));

        System.out.println("Quantidade de mulheres com salário até R$ 200,00: " + countMulheresSalarioBaixo);

        System.out.println("\nDados da Pessoa com o Menor Salário:");
        System.out.println("  " + dadosMenorSalario);
    }
}