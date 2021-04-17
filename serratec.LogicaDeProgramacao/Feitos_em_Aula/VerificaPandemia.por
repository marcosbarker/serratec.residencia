programa
{
	
	funcao inicio()
	{
		logico acabouCoronavirus = falso
		
		inteiro diasParados = 0
		enquanto(acabouCoronavirus == falso)
		{
			acabouCoronavirus = verificaPandemia(diasParados)
			diasParados++
		}
		escreva("Vamos para a Praia!")
	}
	
	funcao logico verificaPandemia(inteiro dias)
	{
		se(dias > 15)
		{
			retorne verdadeiro
		}
		retorne falso
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 16; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {acabouCoronavirus, 6, 9, 17}-{diasParados, 8, 10, 11}-{dias, 17, 41, 4};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */