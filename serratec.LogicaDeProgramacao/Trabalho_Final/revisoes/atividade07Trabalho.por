programa
{	
	funcao inicio()
	{
		inteiro quantidadeNumPrimos 
		inteiro i = 0
		inteiro contador 
		inteiro numPrimos = 2
		
		escreva("Digite a quantidade desejada de números primos: ")
		leia(quantidadeNumPrimos)
				
		escreva("1 ")
		enquanto (i < quantidadeNumPrimos){
			contador = 0
				para (inteiro j = 1; j <= 9; j++){
					se(numPrimos%j == 0){
						contador++
					}
				}
				se(numPrimos > 10 e numPrimos%numPrimos == 0){
					contador++
				}
				se(contador == 2){
					escreva(numPrimos, " ")
					i++
				}
				contador = 0
				numPrimos++
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 488; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */