/*
Lista 3 : Laços de Repetição ( enquanto, para até )
1 - Modifique o exercício 6 da lista anterior para imprimir os números de 1 até n e
também realizar sua soma.
Exemplo de entrada :
6
Saída esperada:
1 2 3 4 5 6
21
*/
 
programa
{
	
	funcao inicio(){
		
		inteiro numero, contador, soma=0

		escreva("Informe um número: ")
		leia(numero)

		para(contador = 1; contador <= numero; contador++){
			escreva(" ", contador)

			soma = soma + contador

		}
		
		escreva("\nA soma da sequência de números é ", soma)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 514; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */