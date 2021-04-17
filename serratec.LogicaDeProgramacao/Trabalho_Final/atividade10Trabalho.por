/*
         * Trabalho de avaliação de lógica de programação*
10. Desenvolva um programa que some duas matrizes modelo Amxn + Amxn = Amxn. 
Solicite que o usuário escolha os números de entrada de ambas as matrizes e 
apresente como resultado as duas matrizes de entrada e a matriz resultado, 
pode ser uma em baixo da outra. Identifique cada matriz ao apresentar o resultado.
*/

programa
{
	inclua biblioteca Util --> u

	funcao inicio(){
		
		inteiro matriz1[4][4], matriz2[4][4]

		inteiro i = 0
		inteiro j = 0
		
		para(i = 0; i < 4; i++){
			para(j = 0; j < 4; j++){
				matriz1[i][j] = u.sorteia(10, 49)  //entrada dos valores automatica (evita a entrada manual de 32 números
				matriz2[i][j] = u.sorteia(10, 49)	//opção com entrada manual na branch 'main'	https://github.com/Volneineves/Grupo01-turmaMarcelo/blob/main/atividade10Trabalho.por		
			}
		}
				
		limpa()
		somaMatrizes(matriz1, matriz2)
		
	}

	funcao somaMatrizes(inteiro matriz1[][], inteiro matriz2[][]){
		inteiro matrizRecebe[4][4] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}

			escreva("Matriz 1:\n")
		para(inteiro i = 0; i < 4; i++){
			para(inteiro j = 0; j < 4; j++){
				escreva(matriz1[i][j], " ")
			}
			
			escreva("\n")			
		}
			escreva("\n")
			escreva("Matriz 2:\n")
			
		para(inteiro i = 0; i < 4; i++){
			para(inteiro j = 0; j < 4; j++){
				
				escreva(matriz2[i][j], " ")
			}
			
			escreva("\n")			
		}
		
			escreva("-------------------\n")
			escreva("Matriz Resultante:\n")
			
		para(inteiro i = 0; i < 4; i++){
			para(inteiro j = 0; j < 4; j++){
				matrizRecebe[i][j] += matriz1[i][j] + matriz2[i][j]
				escreva(matrizRecebe[i][j], " ")
			}
			
			escreva("\n")	
		
		}
			escreva("-------------------\n")
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 682; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */