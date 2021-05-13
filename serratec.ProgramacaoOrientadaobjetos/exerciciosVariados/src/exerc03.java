/*
3 - Uma empresa paga R$10.00 por hora normal trabalhada e R$ 15.00 por hora
extra. Escreva um algoritmo que leia o total de horas normais e o total de
horas extras trabalhadas por um empregado em um ano e calcule o sal�rio anual
deste trabalhador.
Exemplo: 
Entrada: Digite o numero de horas trabalhadas no ano: 1760 
Digite o numero de horas extras trabalhadas no ano: 400 
Saida: Seu salario anual e de : R$ 23600
*/

import java.util.Scanner;

public class exerc03 {
	public void main(String[] args) {

		final double horaNormal = 10.00;
		final double horaExtra = 15.00;

		Scanner out = new Scanner(System.in);
		int horasNormais, horasExtras;

		System.out.println("Entre com o total de horas normais: ");
		horasNormais = out.nextInt();
		System.out.println("Entre com o total de horas extras: ");
		horasExtras = out.nextInt();

		double valorHn = horasNormais * horaNormal;
		double valorHe = horasExtras * horaExtra;
		double salarioAnual = valorHn + valorHe;

		System.out.println("Seu salario anual e de: " + salarioAnual);

		out.close();
	}
}