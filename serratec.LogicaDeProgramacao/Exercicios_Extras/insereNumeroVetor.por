programa
{
	
	funcao inicio()
	{
		inteiro vetorNumeros[10]

		para(inteiro i = 0; i < 10; i++){
			escreva("Entre com o número queu deseja armazenar no vetor: ", i, " : ")
			leia(vetorNumeros[i])
		}

		escreva("Os números armazenados são:\n")

		para(inteiro i = 9; i > 0; i--){
			escreva(vetorNumeros[i], " ")
			
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 85; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */