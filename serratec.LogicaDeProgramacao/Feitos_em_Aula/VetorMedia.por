programa
{
	/*
		2 - Escreva um programa que armazene X números em um vetor e calcule o valor
		médio do vetor.
	*/
	funcao inicio()
	{
		const inteiro X = 10
		inteiro vetorInteiros[X]
		real soma = 0.0

		para(inteiro i = 0; i < X; i++)
		{
			escreva("Digite o elemento ", i, " do vetor: ")
			leia(vetorInteiros[i])
			soma = soma + vetorInteiros[i]
		}
		escreva("\nO valor médio do vetor é ", soma/X, " !")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 163; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */