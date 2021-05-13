import java.util.Scanner;

public class BalancoAnual {
	public static void main(String[] args) {

		var out = new Scanner(System.in);
		System.out.println("Entre com o valor de janeiro: ");
		int gastosJaneiro = out.nextInt();
		System.out.println();

		System.out.println("Entre com o valor de fevereiro: ");
		float gastosFevereiro = out.nextFloat();
		System.out.println();

		System.out.println("Entre com o valor de março: ");
		double gastosMarco = out.nextDouble();
		System.out.println();

		System.out.println("Janeiro: " + gastosJaneiro);
		System.out.println("Janeiro: " + gastosFevereiro);
		System.out.println("Janeiro: " + gastosMarco);

		out.close();
	}
}