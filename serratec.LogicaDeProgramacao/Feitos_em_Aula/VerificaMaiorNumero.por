programa
{
	
	funcao inicio()
	{
		inteiro n1, n2
		escreva("\nDigite um número: ")
		leia(n1)
		
		escreva("\nDigite outro número: ")
		leia(n2)
		
		se(n1 > n2)
		{
			escreva("O numero ", n1, " é maior do que ", n2)
		}
		senao
		{
			se(n1 < n2)
			{
				escreva("O numero ", n2, " é maior do que ", n1)
			}
			senao
			{
				escreva("Os numeros ", n1, " é ", n2, " são iguais.")
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 331; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */