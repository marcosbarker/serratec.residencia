/*
Lista 5 : Vetores e Matrizes
2 - Escreva um programa que armazene X números em um vetor e calcule o valor
médio do vetor.
*/

programa
{
	funcao inicio(){
		
		const inteiro tamanhoVetor=2
		inteiro vetor[tamanhoVetor], i
		real media

		escreva("Entre com números para serem registrados no vetor e obter a média\n")
		
		para(i = 0; i < tamanhoVetor; i++){
			escreva("Entre com um número para o índice ", i + ": ")
			leia(vetor[i])
			
		}

		media = mediaFun(vetor, tamanhoVetor, i)
			escreva("A média dos valores registrados é ", media)
	}

	funcao real mediaFun(inteiro vetor[], inteiro tamanhoVetor, inteiro i){
		real numero=0
		para( i = 0; i < tamanhoVetor; i++){
			numero = numero + vetor[i]
		
		}

	retorne numero / tamanhoVetor

	}
}
	

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 716; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */