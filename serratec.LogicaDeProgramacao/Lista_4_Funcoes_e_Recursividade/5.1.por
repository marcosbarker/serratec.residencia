/*
Lista 4 : Funções e Recursividade
5 - Escreva um programa que calcule o número de dígitos de um dado número usando
recursão:
Exemplo de entrada :
100
Saída esperada:
O número de dígitos do número é : 2
*/

programa
{
	
	funcao inicio(){

		inteiro numero, contador=0

		escreva("Entre com um número: ")
		leia(numero)

		contador = contadorRecursivo(numero, contador)

		escreva("O numero ", numero, " tem ", contador, " digitos.")
	
	}

	funcao inteiro contadorRecursivo(inteiro numero, inteiro contador){
		se(numero == 0){
			retorne contador
				
		}senao{
			contador++
			retorne contadorRecursivo(numero /10, contador)
		
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 528; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */