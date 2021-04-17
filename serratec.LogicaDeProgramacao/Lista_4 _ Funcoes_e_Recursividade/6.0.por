/*
Lista 4 : Funções e Recursividade
*Exercícios sobre o próximo tema :
Dica : Para os exercícios a seguir, leia o código p reence_vetorpo r na pasta :
Vetores e Matrizes/Preenche e Exibe Vetor e utilize a estrutura do vetor “ [ ] “
para resolvê-los.
6 - Escreva um programa que armazene elementos em um vetor e imprima-os
Exemplo de entrada :
Armazene 5 elementos em um vetor :
Elemento - 0 : 1
Elemento - 1 : 4
Elemento - 2 : 3
Elemento - 3 : 6
Elemento - 4 : 8
Saída esperada:
Os elementos no vetor são : 1 4 3 6 8
*/

programa
{
	
	funcao inicio(){
		
		inteiro vetorEntrada[5]

		para(inteiro i = 0; i < 5; i++){
			escreva("Elemento - " , i, " : ")
			leia(vetorEntrada[i])
			
		}

		escreva("Os elementos no vetor são: ")

		para(inteiro i = 0; i < 5; i++){
			escreva(vetorEntrada[i], " ")
			
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 555; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */