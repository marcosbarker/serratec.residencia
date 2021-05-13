package usuario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import funcionario.Diretor;
import funcionario.Funcionario;
import funcionario.Gerente;
import funcionario.Presidente;

public class Cliente {
	protected String nome;
	protected int cpf;
	protected int senha;
	protected String cargo;

	public Cliente() {

	}

	public Cliente(String nome, int senha, int cpf) {

		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;

	}

	public static Map<Integer, Cliente> lerCliente(Map<Integer, Funcionario> mapFuncionario)
			throws FileNotFoundException, IOException {
		String linha;

		try (BufferedReader csvReader = new BufferedReader(new FileReader("Cliente.txt"))) {
			linha = csvReader.readLine();

			Map<Integer, Cliente> mapCliente = new HashMap<>();

			while ((linha = csvReader.readLine()) != null) {

				linha = linha.replace("\"", "");

				String[] data = linha.split(";");

				String nome = data[0];
				int cpf = Integer.parseInt(data[1]);
				int senha = Integer.parseInt(data[2]);
				int idFuncionario = Integer.parseInt(data[3]);
				String cargo = data[3];

				if (idFuncionario == 0) {
					Cliente novoCliente = new Cliente(nome, senha, cpf);
					mapCliente.put(cpf, novoCliente);
				} else if (idFuncionario == 1) {
					Cliente novoGerente = new Gerente(nome, senha, cpf, cargo);
					mapCliente.put(cpf, novoGerente);
				} else if (idFuncionario == 2) {
					Cliente novoDiretor = new Diretor(nome, senha, cpf, cargo);
					mapCliente.put(cpf, novoDiretor);
				} else if (idFuncionario == 3) {
					Cliente novoPresidente = new Presidente(nome, senha, cpf, cargo);
					mapCliente.put(cpf, novoPresidente);

				}
			}
			return mapCliente;
		}
	}

	public String getNome() {
		return nome;

	}

	public void setNome(String nome) {
		this.nome = nome;

	}

	public int getSenha() {
		return senha;

	}

	public void setSenha(int senha) {
		this.senha = senha;

	}

	public int getCpf() {
		return cpf;

	}

	public void setCpf(int cpf) {
		this.cpf = cpf;

	}

	public String getCargo() {
		return cargo;

	}

	public void setCargo(String cargo) {
		this.cargo = cargo;

	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + "]";

	}
}