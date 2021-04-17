programa
{

	inclua biblioteca Matematica --> mat
	
	funcao inicio(){
		
		real radicando = 0,  indice = 0, raiz
		inteiro casasDecimais
		
		escreva("    Calcula Raiz\n")
		escreva("(radicando^(indice)\n\n")
		
		escreva("Radicando: ")
		leia(radicando)

		escreva("Índice: ")
		leia(indice)

		escreva("Quantidade de casas decimais: ")
		leia(casasDecimais)

		raiz = mat.arredondar(mat.raiz(radicando, indice), casasDecimais) 

		limpa()
		
		escreva("\nA raiz de ", radicando, " elevada ao índice ", indice, " é ", raiz, "\n")
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 545; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */