programa
{
	
	funcao inicio()
	{
		inteiro vetorNumeros[10], escrita = 10, leitura = 0
		
		enquanto(escrita >= 0){
			se(leitura < 10){
				escreva("Entre com o número queu deseja armazenar no vetor: ", leitura, " : ")
				leia(vetorNumeros[leitura])
				leitura++
		
			}senao{
				escreva(vetorNumeros[escrita], " ")
				escrita--

			}
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 90; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */