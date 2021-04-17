/*
Lista 5 : Vetores e Matrizes
1 - Escreva um programa que leia 10 números inteiros do teclado e armazena no
vetor. Após isso, imprima os 10 inteiros em ordem inversa ao que foi digitado.
*/

programa
{
	
	funcao inicio(){
		
		inteiro vetoresInteiro[10]

		para(inteiro i = 0; i < 10; i++){

			escreva("numero ", i, " : ")
			leia(vetoresInteiro[i])

		}

		para(inteiro i = 0;i < 10; i++){
			escreva(vetoresInteiro[9-i], " ")
			
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 431; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */