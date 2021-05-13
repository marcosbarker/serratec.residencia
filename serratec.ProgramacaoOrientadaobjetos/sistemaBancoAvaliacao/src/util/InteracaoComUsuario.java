package util;

import javax.swing.JOptionPane;

public class InteracaoComUsuario {
	public static String lerString(String mensagem) {
		return JOptionPane.showInputDialog(mensagem);

	}

	public static Integer lerInteiros(String mensagem) {
		try {

			String entrada = JOptionPane.showInputDialog(mensagem);
			return Integer.parseInt(entrada);

		} catch (NumberFormatException e) {
			System.out.println("Valor informado diferente do esperado(Inteiro)");
			e.printStackTrace();
			return null;

		}
	}

	public static Double lerDoubles(String mensagem) {
		try {
			String entrada = JOptionPane.showInputDialog(mensagem);
			return Double.parseDouble(entrada);
		} catch (NumberFormatException e) {
			System.out.println("Valor informado diferente do esperado(decimal)");
			e.printStackTrace();
			return null;

		}
	}
}