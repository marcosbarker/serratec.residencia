programa
{
	
	funcao inicio()
	{
		inteiro opcao = 0
		faca
		{
			escreva("Escolha a operação desejada\n")
			escreva("====================\n")
			escreva("1 - Opção 1\n")
			escreva("2 - Opção 2\n")
			escreva("3 - Opção 3\n")
			escreva("4 - Opção 4\n")
			escreva("9 - Opção 9\n")
			escreva("====================\n")
			leia(opcao)
			
			se(opcao == 1)
				soma()
			senao se(opcao==2)
				subtracao()
			senao se(opcao==3)
				multiplicacao()
			senao se(opcao==4)
				divisao()
		}
		enquanto(opcao != 9)
	}
	funcao soma()
	{
		escreva("Somei!!!!!\n")
	}
	funcao subtracao()
	{
		escreva("Subtrai!!!!!\n")
	}
	funcao multiplicacao()
	{
		escreva("Multipliquei!!!!!\n")
	}
	funcao divisao()
	{
		escreva("Dividi!!!!!\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 476; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */