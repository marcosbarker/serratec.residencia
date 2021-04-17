programa
{
	funcao inicio()
	{
		inteiro numero
		inteiro soma = 0
		escreva("Digite um numero: ")
		leia(numero)
		
		enquanto(numero != 0)
		{
			escreva("\n\nsoma antes = ", soma)
			escreva("\nResto = ", numero % 10)
			soma = soma + numero % 10
			escreva("\nsoma depois = ", soma)
			escreva("\nnumero antes = ", numero)
			numero = (numero / 10)
			escreva("\nnumero depois = ", numero)
		}
		escreva("\n\nA soma é ", soma)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 69; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {numero, 5, 10, 6}-{soma, 6, 10, 4};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */