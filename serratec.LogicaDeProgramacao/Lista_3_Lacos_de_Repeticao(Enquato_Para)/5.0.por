/*
Lista 3 : Laços de Repetição ( enquanto, para até )
5 - Escreva um programa que verifique se um número é um palíndromo ou não.
Exemplo de entrada :
12321
Saída esperada:
12321 é um número palíndromo
*/

programa
{
	
	funcao inicio(){
		
		inteiro numero1, numero2 = 0, auxiliar 

		escreva("\tTeste Palíndromo\n")
		escreva("Entre com uma sequência númerica: ")
		leia(numero1)
		auxiliar = numero1
		

		enquanto(numero1 > 0){
			numero2 = numero2 + numero1 % 10
			numero1 = numero1 / 10
			numero2 = numero2 * 10
		}
		
		numero2 = numero2 / 10

		se(auxiliar == numero2){
			escreva(auxiliar, " é um número palíndromo")
			
		}senao{
			escreva(auxiliar, " não é um número palíndromo")
		
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 202; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */