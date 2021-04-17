programa
{
	
	/*
		7 - Escreva um programa que armazene elementos em um vetor​e encontra o valor
		mínimo e máximo
		Exemplo de entrada​:
			Armazene 5 elementos em um vetor :
			Elemento - 0 : 1
			Elemento - 1 : 4
			Elemento - 2 : 3
			Elemento - 3 : 8
			Elemento - 4 : 6
		Saída esperada:
			Elemento maior : 8
			Elemento menor : 1
	*/
	funcao inicio()
	{
		inteiro vetorInteiros[5]
		inteiro maior, menor

		para(inteiro i = 0 ; i < 5; i++)
		{
			escreva("Elemento - ", i, " : ")
			leia(vetorInteiros[i])
		}
		// 0 1 2 3 4
		// 1 4 3 6 8
		maior = vetorInteiros[0]
		menor = vetorInteiros[0]
		inteiro i = 1
		enquanto( i < 5 ){
			
			se(vetorInteiros[i] > maior){
				maior = vetorInteiros[i]
			}

			se(vetorInteiros[i] < menor){
				menor = vetorInteiros[i]
			}
			
			i++
		}

		escreva("Elemento máximo :", maior)
		escreva("\nElemento minimo :", menor)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 622; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */