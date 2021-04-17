programa
{
	/*
		1 - Escreva um programa que leia 10 números inteiros do teclado e armazena no
		vetor. Após isso, imprima os 10 inteiros em ordem inversa ao que foi digitado.
	*/
	
	funcao inicio()
	{
		const inteiro tamanho = 15
		inteiro vetorInteiros[tamanho]

		para(inteiro i = 0; i < tamanho; i++)
		{
			escreva("Digite o elemento ", i, " do vetor: ")
			leia(vetorInteiros[i])
		}

		escreva("\nOs elementos na ordem digitada são: ")
		para(inteiro i = 0; i < tamanho; i++)
		{
			escreva(vetorInteiros[i], " ")
		}

		escreva("\nOs elementos na ordem inversa são: ")
		para(inteiro i = tamanho-1; i >= 0; i--)
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
 * @POSICAO-CURSOR = 604; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */