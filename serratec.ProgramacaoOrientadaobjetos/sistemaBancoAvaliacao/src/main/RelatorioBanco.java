package main;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

	public class RelatorioBanco extends Conta{
		public static void main(String[] args) throws IOException {
			String textoQueSeraEscrito = “Texto que sera escrito.”;
		
		try {
			FileWriter arquivo = new FileWriter(new File("Relatorio.txt"));
			arquivo.write(textoQueSeraEscrito);
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}