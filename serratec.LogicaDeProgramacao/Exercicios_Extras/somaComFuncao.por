programa
{
	
	funcao inicio(){

		inteiro numero1, numero2, somaFinal
		
		escreva("Entre como 1ª número: ")
		leia(numero1)

		escreva("Entre como 2ª número: ")
		leia(numero2)
		
		somaFinal = soma(numero1, numero2)

		escreva("\nA soma entre os números ", numero1, " e ", numero2, " é ", somaFinal, "\n")
	
	}

	funcao inteiro soma(inteiro numero1, inteiro numero2){
		retorne numero1 + numero2
		
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 239; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */