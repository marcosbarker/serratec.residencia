/*
4 - Escreva um programa que receba a temperatura em Celsius e retorne o valor
em Fahrenheit Exemplo:
Entrada​: Digite o valor da temperatura em Celsius: 10 
Saída​: 10 graus Celsius é o mesmo que 50 graus Fahrenheit
*/

import java.util.Scanner;

public class exerc04 {
	public void main(String[] args) {

		Scanner out = new Scanner(System.in);
		double celsius, fahrenheit;

		System.out.println("Digite a tempetatura em Celsius: ");
		celsius = out.nextDouble();
		fahrenheit = celsius * 1.8 + 32;

		System.out.println(celsius + " graus Celsius é o mesmo que " + fahrenheit + " graus Fahrenheit");

		out.close();
	}
}
