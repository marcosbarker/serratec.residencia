/*
Lista 1 : Operações de entrada e saída ; Variáveis e constantes
2 - Escreva um programa que leia do teclado 2 números e execute a soma, subtração,
divisão e multiplicação e apresente na tela os resultados da seguinte maneira :
Exemplo :
Entrada :
Digite um número : 20
Digite outro número : 10
Saída:
A soma de 20 com 10 é igual a 30
A subtração de 20 por 10 é igual a 10
A divisão de 20 por 10 é igual a 2
A multiplicação de 20 por 10 é 200
*/

programa
{
	
	funcao inicio(){
		
		inteiro numero1, numero2, resultado
		
		escreva("Entre com o primeiro número: ")
		leia(numero1)

		escreva("Entre com o segundo número: ")
		leia(numero2)

		resultado = numero1 + numero2

		escreva("Resultado da soma: ", resultado) 
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 448; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */