import java.util.Scanner;

public class BalancoAnualRepeat {
    public static void main(String[] args) {

        Scanner out = new Scanner(System.in);
        int[] balanco = new int[12];
        int balancoAnual = 0;

        for (int i = 0; i < 12; i++) {
            System.out.println("Insira o balanço do " + (i + 1) + "ª mês: ");
            balanco[i] = out.nextInt();
        }

        for (int j = 0; j < 12; j++) {
            balancoAnual = balancoAnual + balanco[j];
        }

        System.out.println("Balanço 1ª trimestre: " + (balanco[0] + balanco[1] + balanco[2]));
        System.out.println("Balanço 2ª trimestre: " + (balanco[3] + balanco[4] + balanco[5]));
        System.out.println("Balanço 3ª trimestre: " + (balanco[6] + balanco[7] + balanco[8]));
        System.out.println("Balanço 4ª trimestre: " + (balanco[9] + balanco[10] + balanco[11]));
        System.out.println('\n' + "Balanço anual: " + balancoAnual);

        out.close();
    }
}