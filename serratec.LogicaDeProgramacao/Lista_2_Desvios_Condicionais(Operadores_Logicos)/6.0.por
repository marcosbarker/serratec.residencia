/*
Lista 2 - Desvios Condicionais, Operadores Lógicos
Dica : Para os exercícios a seguir, leia o código contagem_regressiva.por na pasta
: Laços de Repetição/Contagem Regressiva e utilize a estrutura “enquanto” para
resolvê-los.
6 - Escreva um programa que imprima todos os número de 1 até n.
Exemplo de entrada:
6
Saída esperada:
1 2 3 4 5 6
*/
 
programa
{
	
	funcao inicio(){
		
		inteiro numero, resultado, contador

		escreva("Informe um número: ")
		leia(numero)

		para(contador = 1; contador <= numero; contador++){
			escreva(contador, " ")
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 343; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */