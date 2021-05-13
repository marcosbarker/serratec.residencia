/*
1 - Escreva um programa que receba do teclado seu nome e seu sobrenome
separadamente e escreva na tela seu nome completo como no exemplo abaixo:
Exemplo:
Entrada: Digite seu nome : Fulano
Saida: Digite seu sobrenome : de Tal
Meu nome é: Fulano de Tal
*/

import java.util.Scanner;

public class exerc01 {
	public void main(String args[]) {

		Scanner out = new Scanner(System.in);
		String nome, sobrenome;

		System.out.println("Digite seu nome");
		nome = out.nextLine();
		System.out.println("Digite seu sobrenome");
		sobrenome = out.nextLine();

		System.out.println("Meu nome é " + nome + " " + sobrenome);

		out.close();
	}
}