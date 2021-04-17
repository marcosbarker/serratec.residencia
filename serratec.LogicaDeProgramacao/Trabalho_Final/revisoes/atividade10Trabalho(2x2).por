/*
         * Trabalho de avaliação de lógica de programação*
10. Desenvolva um programa que some duas matrizes modelo Amxn + Amxn = Amxn. 
Solicite que o usuário escolha os números de entrada de ambas as matrizes e 
apresente como resultado as duas matrizes de entrada e a matriz resultado, 
pode ser uma em baixo da outra. Identifique cada matriz ao apresentar o resultado.
*/

programa
{

	funcao inicio(){
		
		inteiro matriz1[2][2], matriz2[2][2]

		para(inteiro i = 0; i < 2; i++){
			para(inteiro j = 0; j < 2; j++){
				escreva("Entre com os números da 1ª Matriz: ")
				leia(matriz1[i][j])
				escreva("Entre com os números da 2ª Matriz: ")
				leia(matriz2[i][j])
			}
		}
		
		limpa()
		
		somaMatrizes(matriz1, matriz2)
	}

	funcao somaMatrizes(inteiro matriz1[][], inteiro matriz2[][]){
		inteiro matrizRecebe[2][2] = {{0,0},{0,0}}
		
		para(inteiro i = 0; i < 2; i++){
			para(inteiro j = 0; j < 2; j++){
				
				matrizRecebe[i][j] += matriz1[i][j] + matriz2[i][j]			
				escreva(matrizRecebe[i][j], " ")
			}
			
			escreva("\n")
			
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 822; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {matriz1, 14, 10, 7}-{matriz2, 14, 25, 7}-{matrizRecebe, 31, 10, 12};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */