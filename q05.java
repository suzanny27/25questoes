public class q05 {
    public static void main(String[] args) {
        System.out.println("--- Tabuadas de 1 a 10 ---");

        for (int numero = 1; numero <= 10; numero++) {
            System.out.println("\n*** Tabuada do " + numero + " ***");

            for (int i = 0; i <= 10; i++) {
                int resultado = numero * i;
                System.out.printf("%d x %2d = %d\n", numero, i, resultado);
            }
        }
    }
}
