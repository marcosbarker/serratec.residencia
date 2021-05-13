package main;

import static util.Constantes.CARGO_DIRETOR;

import static util.Constantes.CARGO_GERENTE;
import static util.Constantes.CARGO_PRESIDENTE;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import conta.Conta;
import conta.MapaDasContas;
import funcionario.Funcionario;
import funcionario.MapaDeFuncionario;
import usuario.Cliente;
import util.InteracaoComUsuario;
import util.MenuDeOpcoes;

public class SistemaInterno {
	static Map<Integer, Funcionario> mapFuncionario;
	static Map<Integer, Cliente> mapCliente;
	static Map<Integer, Conta> mapConta;

	public static void main(String[] args) {
		try {
			mapFuncionario = MapaDeFuncionario.lerFuncionarios();
			mapCliente = Cliente.lerCliente(mapFuncionario);
			mapConta = MapaDasContas.lerConta();

		} catch (FileNotFoundException e) {
			System.out.println("O arquivo não foi encontrado");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println("Arquivo corrompido!");
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("Tivemos um imprevisto, tente novamente mais tarde!");
			e.printStackTrace();
		}

		int cpfLogin = InteracaoComUsuario.lerInteiros("Informe um cpf (somente números) para login: ");

		boolean clienteCadastrado = mapCliente.containsKey(cpfLogin);
		if (clienteCadastrado) {
			Cliente cliente = mapCliente.get(cpfLogin);

			int senhaLogin = InteracaoComUsuario.lerInteiros("Informe a senha (somente números) para login: ");
			if (senhaLogin == cliente.getSenha()) {
				if (cliente.getCargo() != null) {
					switch (cliente.getCargo()) {
					case CARGO_GERENTE:
						MenuDeOpcoes.menuGerente(cpfLogin, mapConta, mapCliente, mapFuncionario);
						break;
					case CARGO_DIRETOR:
						MenuDeOpcoes.menuDiretor(cpfLogin, mapConta, mapCliente, mapFuncionario);
						break;
					case CARGO_PRESIDENTE:
						MenuDeOpcoes.menuPresidente(cpfLogin, mapConta, mapCliente, mapFuncionario);
						break;

					}

				} else {
					MenuDeOpcoes.menuCliente(cpfLogin, mapConta, mapCliente, mapFuncionario);

				}

			} else {
				System.out.println("Usuario ou senha incorretos, tente novamente");
				System.out.println("\n===================================");
				System.out.println("|      ZeressemosNationalBank     |");
				System.out.println("===================================");

			}

		} else {
			System.out.println("Usuario ou senha incorretos, tente novamente");
			System.out.println("\n===================================");
			System.out.println("|      ZeressemosNationalBank     |");
			System.out.println("===================================");
		}
	}
}