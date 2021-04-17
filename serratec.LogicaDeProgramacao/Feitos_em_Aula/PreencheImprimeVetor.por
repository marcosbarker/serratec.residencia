programa
{

	/*
		6 - Escreva um programa que armazene elementos em um vetor e imprima-os
		Exemplo de entrada​:
			Armazene 5 elementos em um vetor :
			Elemento - 0 : 1
			Elemento - 1 : 4
			Elemento - 2 : 3
			Elemento - 3 : 6
			Elemento - 4 : 8
		Saída esperada:
			Os elementos no vetor são : 1 4 3 6 8
	*/
	
	funcao inicio()
	{
		inteiro vetorInteiros[5]

		para(inteiro i = 0 ; i < 5; i++)
		{
			escreva("Elemento - ", i, " : ")
			leia(vetorInteiros[i])
		}
		
		escreva("Os elementos no vetor são : ")
		para(inteiro i = 0; i < 5; i++)
		{
			escreva(vetorInteiros[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 518; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */