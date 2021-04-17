/*                           
Lista 1 : Operações de entrada e saída ; Variáveis e constantes0
6 - Escreva um programa que diga se o número é par ou ímpar
Dica : o operador % calcula a divisão de um número X por um número Y e retorna o
resto da divisão
Exemplo :
Entrada:
Digite um número : 2
Saída:
O número 2 é par
*/

programa
{
	
	funcao inicio(){
		
		inteiro num

		escreva("Entre com um numero: ")
		leia(num)

		se (num % 2 == 0){ // Módulo é o restante da divisão (operador %)
					   //num(numero) divide por 2, o perador modulo %, tras o resto nessa divisao e compara com 0	
					   //retorno 0 é par   	
			escreva(num, " é par")
			
		}senao{
			
			escreva(num, " é impar")
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 354; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */