package conta;
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapaDasContas extends Conta {

	public MapaDasContas(int cpf, int numero, int agencia, double saldo, int tipo) {
		this.cpf = cpf;
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
		this.tipo = tipo;
		
	}

	public static Map<Integer, Conta> lerConta() throws IOException, FileNotFoundException {
		String linha;

		try (BufferedReader csvReader = new BufferedReader(new FileReader("Conta.txt"))) {
			linha = csvReader.readLine();

			Map<Integer, Conta> mapConta = new HashMap<>();

			while ((linha = csvReader.readLine()) != null) {

				linha = linha.replace("\"", "");

				String[] data = linha.split(";");
				String titular = data[0];
				int cpf = Integer.parseInt(data[1]);
				int numero = Integer.parseInt(data[2]);
				int agencia = Integer.parseInt(data[3]);
				double saldo = Double.parseDouble(data[4]);
				int tipo = Integer.parseInt(data[5]);

				if (tipo == 1) {
					Conta novaConta = new ContaCorrente(titular, cpf, numero, agencia, saldo, tipo);
					mapConta.put(cpf, novaConta);
					
				} else {
					Conta novaConta = new ContaPoupanca(titular, cpf, numero, agencia, saldo, tipo);
					mapConta.put(cpf, novaConta);
					
				}
			}
			
			return mapConta;
		}
	}

	@Override
	public double seguroDeVida(double valor) {
		return 0;
		
	}

	public static void atualizaTxt(Conta conta) {
		String arquivo = "Conta.txt";
		String arquivoTmp = "Conta-tmp";

		BufferedWriter writer;
		BufferedReader reader;

		try {
			writer = new BufferedWriter(new FileWriter(arquivoTmp));
			reader = new BufferedReader(new FileReader(arquivo));
			String linha;
			while ((linha = reader.readLine()) != null) {
				
				String[] data = linha.split(";");
				
				if(data[1].equals(String.valueOf(conta.getCpfTitular()))) {
					linha = linha.replace(data[4], String.valueOf(conta.getSaldo()));
					
				}
				writer.write(linha + "\n");
			}
			writer.close();
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new File(arquivo).delete();
		new File(arquivoTmp).renameTo(new File(arquivo));
	}
}