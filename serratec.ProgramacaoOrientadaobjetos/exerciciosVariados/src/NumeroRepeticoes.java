import java.util.Scanner;

public class NumeroRepeticoes {
	public static void main(String[] args) {

		Scanner out = new Scanner(System.in);
		int n;
		System.out.println("Entre com o numero de repetições: ");
		n = out.nextInt();// 6

		for (int i = 1; i <= n; i = i + 1) {
			System.out.println(i);
		}
		out.close();
	}
}
