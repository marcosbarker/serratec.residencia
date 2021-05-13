import java.util.Scanner;

public class VerificaTrianguloEspecial {
	Scanner out = new Scanner(System.in);
	int angulo1 = 0;
	int angulo2 = 0;
	int angulo3 = 0;

	public void main(String[] args) {

		int verificaTriangulo;
		do {
			menu();
		} while ((angulo1 <= 0) || (angulo2 <= 0) || (angulo3 <= 0));

		verificaTriangulo = angulo1 + angulo2 + angulo3;
		if (verificaTriangulo == 180) {
			System.out.println("\nÉ um triangulo!");

		} else {
			System.out.println("\nNão é um triangulo!");
		}

		out.close();
	}

	public void menu() {

		System.out.println("\nDigite o angulo 1: ");
		angulo1 = out.nextInt();

		System.out.println("Digite o angulo 2: ");
		angulo2 = out.nextInt();

		System.out.println("Digite o angulo 3: ");
		angulo3 = out.nextInt();

		if ((angulo1 <= 0) || (angulo2 <= 0) || (angulo3 <= 0)) {
			System.out.println("Um dos angulos é negativo ou igual a zero");
		}
	}
}