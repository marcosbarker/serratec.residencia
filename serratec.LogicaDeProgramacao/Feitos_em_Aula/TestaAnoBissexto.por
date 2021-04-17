programa
{
	/*
		2 - Escreva uma função que receba um ano e diga se ele é bissexto ou não e utilize
		esta função para verificar:

		Multiplo de 4 (ano % 4 == 0)
		Divisivel por 100 com resto != 0
		Divisivel por 100 com resto 0 e divisivel por 400 com resto 0
		
		
		Exemplo de entrada​:
		2017
		Saída esperada:
		O ano 2017 não é bissexto
	*/
	
	funcao inicio()
	{
		inteiro ano
		real divisao
		real mod

		escreva("Digite um ano para saber se ele é bissexto: ")
		leia(ano)

		se( (ano % 4 == 0) e ( (ano % 100 != 0) ou (ano % 400 == 0) ) ){
			escreva("O ano ", ano, " é bissexto!")
		}
		senao
		{
			escreva("O ano ", ano, " não é bissexto!")
		}
/*
		se ( ano %4 == 0 ){
			
			se (ano %100 != 0){
				escreva("O ano ", ano, " é bissexto!")
			}
			senao
			{
				se( ano %400 == 0){
					escreva("O ano ", ano, " é bissexto!")
				}
				senao
				{
					escreva("O ano ", ano, " não é bissexto!")
				}
			}
			
		}
		senao{
			escreva("O ano ", ano, " não é bissexto!")
		}
*/
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 552; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */