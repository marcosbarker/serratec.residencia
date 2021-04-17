/*
Lista 2 - Desvios Condicionais, Operadores Lógicos
3 - Escreva um programa para verificar se um caractere é uma vogal ou consoante.
Exemplo de entrada:
k
Saída esperada:
k é uma consoante
*/

programa
{
	
	funcao inicio(){
		
		caracter entrada

		escreva("Digite uma letra: ")
		leia(entrada)

		se(entrada == 'a' ou entrada == 'e' ou entrada == 'i' ou entrada == 'o' ou entrada == 'u' 
		   ou entrada == 'A' ou entrada == 'E' ou entrada == 'I' ou entrada == 'O' ou entrada == 'U'){
			escreva("A letra é uma vogal")
		
		}senao{
			
			escreva("A letra não é vogal")
			
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 406; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */