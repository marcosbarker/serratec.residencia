import java.util.Scanner;

public class VerificaTriangulo {
	public static void main(String[] args) {
		Scanner out = new Scanner(System.in);

		int angulo2 = 0;
		int angulo1 = 0;
		int angulo3 = 0;
		int verificaTriangulo;

		System.out.println("\nEntre com o angulo 1: ");
		angulo1 = out.nextInt();

		System.out.println("Entre com o angulo 2: ");
		angulo2 = out.nextInt();

		System.out.println("Entre com o angulo 3: ");
		angulo3 = out.nextInt();

		verificaTriangulo = angulo1 + angulo2 + angulo3;

		if ((verificaTriangulo == 180) && ((angulo1 > 0) && (angulo2 > 0) && (angulo3 > 0))) {
			System.out.println("\nÉ um triangulo");

		} else {
			System.out.println("\nNão é um triangulo");
		}

		out.close();
	}
}