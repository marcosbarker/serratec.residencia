programa
{
	
	funcao inicio()
	{
		
		/*
		Escreva um programa para verificar se um caractere é uma vogal ou consoante.
		Exemplo de entrada:
		k
		Saída esperada:
		k é uma consoante
		*/

		caracter entrada
		escreva("Digite uma letra do alfabeto: ")
		leia(entrada)

		se( 	entrada == 'a' ou entrada == 'e' ou entrada == 'i' ou entrada == 'o' ou entrada == 'u' ou 
			entrada == 'A' ou entrada == 'E' ou entrada == 'I' ou entrada == 'O' ou entrada == 'U')
		{
			escreva("O caracter digitado é uma vogal!")
		}
		senao
		{
			escreva("O caracter digitado é uma consoante!")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 257; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */