import java.util.Scanner;

public class Coet {

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();

        Scanner sc = new Scanner(System.in);
        int potencia = -1;

        while (potencia != 0) {
            if (sc.hasNextInt()) {
                potencia = sc.nextInt();
                coet.passaAPotencia(potencia);
            } else {
                sc.next();
            }
        }
        sc.close();
    }
}