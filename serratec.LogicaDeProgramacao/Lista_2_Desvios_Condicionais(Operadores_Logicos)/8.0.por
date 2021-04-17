/*
Lista 2 - Desvios Condicionais, Operadores Lógicos
8 - Escreva um programa que encontre a soma de dígitos de um número.
Exemplo de entrada:
2020
Saída esperada:
4
*/

programa
{
	
	funcao inicio(){
		
		inteiro n, soma=0

		escreva("Digite um número: ")
		leia(n)

		enquanto(n != 0){
			soma += n % 10

			n = n /10
		}

		escreva(soma)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 166; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */