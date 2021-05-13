import java.util.Scanner;

public class TabuadaEspecial {
	public void main(String[] args) {
		inicio();
	}

	public void inicio() {
		Scanner out = new Scanner(System.in);
		int i, numeroEscolhido, quantidade;
		final int multiplicador = 10;
		char linha;

		System.out.println("Entre com um numero da tabuada: ");
		numeroEscolhido = out.nextInt();

		System.out.println("Entre com um caracter: ");
		linha = out.next().charAt(0);

		System.out.println("Entre com a quantidade de caracteres: ");
		quantidade = out.nextInt();

		escreveLinha(linha, quantidade);

		System.out.println("\nNumeros entre 1 e 5");

		escreveLinha(linha, quantidade);

		out.close();

		for (i = 1; i <= multiplicador; i++) {
			multiplicacao(i, multiplicador);
			System.out.print("\n" + i + " x " + numeroEscolhido + " = " + i * numeroEscolhido);
		}

		System.out.println();
		escreveLinha(linha, quantidade);

	}

	public void escreveLinha(char linha, int repeticao) {
		int i;
		for (i = 0; i < repeticao; i++) {
			System.out.print(linha);
		}
	}

	public int multiplicacao(int num1, int num2) {
		int calculo = num1 * num2;
		return calculo;
	}
}