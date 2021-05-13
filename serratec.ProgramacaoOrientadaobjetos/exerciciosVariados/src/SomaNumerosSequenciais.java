import java.util.Scanner;

public class SomaNumerosSequenciais {

	public void main(String[] args) {
		Scanner out = new Scanner(System.in);
		int numero;
		int carteira = 0;

		System.out.println("Entre com um numero: ");
		numero = out.nextInt();

		for (int i = 1; i <= numero; i++) {
			System.out.println(i);
			carteira = carteira + i;
		}

		System.out.println(carteira);

		out.close();
	}

}
