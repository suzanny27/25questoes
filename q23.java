import java.util.Scanner;

public class q23 {

    public static double lerSalario(Scanner scanner) {
        double salario = -1.0;
        while (salario < 0) {
            try {
                System.out.print("Digite o Salário Atual (R$): ");
                salario = scanner.nextDouble();
                if (salario < 0) {
                    System.out.println("O salário não pode ser negativo.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico.");
                scanner.next();
                salario = -1.0;
            }
        }
        return salario;
    }

    public static void novoSalario(Scanner scanner) {
        double salario = lerSalario(scanner);
        double reajuste;

        if (salario <= 400.00) {
            reajuste = 0.15;
        } else if (salario <= 800.00) {
            reajuste = 0.12;
        } else if (salario <= 1200.00) {
            reajuste = 0.10;
        } else if (salario <= 2000.00) {
            reajuste = 0.07;
        } else {
            reajuste = 0.04;
        }

        double novoSalario = salario * (1 + reajuste);
        System.out.printf("Novo Salário (Reajuste de %.0f%%): R$ %.2f\n", reajuste * 100, novoSalario);
    }

    public static void calcularFerias(Scanner scanner) {
        double salario = lerSalario(scanner);
        double valorFerias = salario + (salario / 3.0);
        System.out.printf("Valor Bruto das Férias (Salário + 1/3): R$ %.2f\n", valorFerias);
    }

    public static void calcularDecimoTerceiro(Scanner scanner) {
        double salario = lerSalario(scanner);
        int meses = 0;

        while (meses < 1 || meses > 12) {
            try {
                System.out.print("Digite a quantidade de meses trabalhados no ano (1-12): ");
                meses = scanner.nextInt();
                if (meses < 1 || meses > 12) {
                    System.out.println("Mês deve ser entre 1 e 12.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next();
            }
        }

        double valorDecimo = salario * (meses / 12.0);
        System.out.printf("Valor do Décimo Terceiro (Proporcional a %d meses): R$ %.2f\n", meses, valorDecimo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n--- Menu de Cálculos Salariais ---");
            System.out.println("1. Novo Salário (com reajuste)");
            System.out.println("2. Férias (Salário + 1/3)");
            System.out.println("3. Décimo Terceiro (proporcional)");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1:
                        novoSalario(scanner);
                        break;
                    case 2:
                        calcularFerias(scanner);
                        break;
                    case 3:
                        calcularDecimoTerceiro(scanner);
                        break;
                    case 4:
                        System.out.println("Saindo do programa.");
                        break;
                    default:
                        System.out.println("Opção inválida. Digite 1, 2, 3 ou 4.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro para a opção.");
                scanner.next();
                opcao = 0;
            }
        } while (opcao != 4);
    }
}
