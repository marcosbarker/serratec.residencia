package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import conta.ContaCorrente;
import conta.ContaPoupanca;
import enums.ContaTipoEnum;
import enums.UsuarioTipoEnum;
import pessoal.Cliente;
import pessoal.Diretor;
import pessoal.Usuario;

public class LeituraEscrita {
	
	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";

	public static void leitor(String path) throws IOException {
		
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO+path));
			String linha = "";
			
			while (true) {
				linha = buffRead.readLine();
				if (linha != null) {
					String[] pp = linha.split(";");
					if(pp[0].equalsIgnoreCase(ContaTipoEnum.CORRENTE.getTipo())) {
						ContaCorrente cc = new ContaCorrente(pp[0], Integer.parseInt(pp[1]), Integer.parseInt(pp[2]), Double.parseDouble(pp[3]), Integer.parseInt(pp[4]), Integer.parseInt(pp[5]), Integer.parseInt(pp[6]));
						System.out.println(cc);
					}
					else if(pp[0].equalsIgnoreCase(ContaTipoEnum.POUPANCA.getTipo())) {
						ContaPoupanca cp = new ContaPoupanca(pp[0], Integer.parseInt(pp[1]), Integer.parseInt(pp[2]), Double.parseDouble(pp[3]), Integer.parseInt(pp[4]), Integer.parseInt(pp[5]), Integer.parseInt(pp[6]));
						System.out.println(cp);
					}
					else if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.DIRETOR.getTipo())) {
						Diretor d = new Diretor(pp[0], pp[1], Integer.parseInt(pp[2]), pp[3], pp[4], Integer.parseInt(pp[5]), Double.parseDouble(pp[6]), Integer.parseInt(pp[7]));
						System.out.println(d);
					}
					else if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.CLIENTE.getTipo())) {
						//String tipo, String nome, Integer id, String cpf, String senha, Integer agencia, Integer numeroConta
						Cliente cli = new Cliente(pp[0], pp[1], Integer.parseInt(pp[2]), pp[3], pp[4], Integer.parseInt(pp[5]), Integer.parseInt(pp[6].trim()) );
						//String tipo, String nome, Integer id, String cpf, String senha, Integer agencia, Integer numeroConta
						System.out.println(cli);
						LeituraEscrita.comprovanteDeposito(PATH_BASICO+cli.getNome()+"_"+cli.getCpf()+EXTENSAO, cli, cli.getNumeroConta(), 1250.00);
					}
					
				} else
					break;
			}
			buffRead.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado no path informado: " + PATH_BASICO+path);
		}
	}
	
	public static void escritor(String path) throws IOException {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo: ");
		String nome = in.next();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO+nome+EXTENSAO));
		String linha = "";
		System.out.println("Escreva algo: ");
		linha = in.next();
		buffWrite.append(linha + "\n");
		buffWrite.close();
	}
	
	public static void comprovanteDeposito(String path, Usuario usuario, Integer NumConta, double vlrDeposito) throws IOException {
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "**********Deposito**********";
		buffWrite.append(linha + "\n");
		
		linha = "Agencia: "+usuario.getAgencia();
		buffWrite.append(linha + "\n");
		
		linha = "Conta: "+NumConta;
		buffWrite.append(linha + "\n");
		
		linha = "Depósito: R$"+vlrDeposito;
		buffWrite.append(linha + "\n");
		
		linha = "**********Fim do Deposito**********";
		buffWrite.append(linha + "\n");
		
		buffWrite.close();
	}
	
}
