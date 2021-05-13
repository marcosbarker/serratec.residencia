/*
2 - Escreva um programa que leia do teclado 2 numeros e execute a soma, subtracao,
divisao e multiplicacao e apresente na tela os resultados da seguinte maneira :
Exemplo :
Entrada :
Digite um numero : 20
Digite outro numero : 10
Saida: A soma de 20 com 10 e igual a 30
A subtracao de 20 por 10 e igual a 10
A divisao de 20 por 10 e igual a 2
A multiplicacao de 20 por 10 e 200
*/

import java.util.Scanner;

public class exerc02 {
	public void main(String[] args) {

		Scanner out = new Scanner(System.in);
		int numero1, numero2, soma, subtracao;
		float divisao, multiplicacao;

		System.out.println("Digite um numero: ");
		numero1 = out.nextInt();

		System.out.println("Digite outro numero: ");
		numero2 = out.nextInt();

		soma = numero1 + numero2;
		subtracao = numero1 - numero2;
		divisao = numero1 / numero2;
		multiplicacao = numero1 * numero2;

		System.out.println("A soma de " + numero1 + " + " + numero2 + " e: " + soma);
		System.out.println("A subtracao de " + numero1 + " - " + numero2 + " e: " + subtracao);
		System.out.println("A divisao de " + numero1 + " / " + numero2 + " e: " + divisao);
		System.out.println("A multiplicacao de " + numero1 + " * " + numero2 + " e: " + multiplicacao);

		out.close();
	}

}
