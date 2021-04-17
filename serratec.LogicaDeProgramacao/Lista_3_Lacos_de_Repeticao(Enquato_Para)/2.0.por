/*
Lista 3 : Laços de Repetição ( enquanto, para até )
2 - Escreva um programa que faça a tabuada de um número n.
Exemplo de entrada :
6
Saída esperada:
6x1 = 6
6x2 = 12
6x3 = 18
6x4 = 24
...
...
6x10 = 60
*/
 
programa
{
	
	funcao inicio(){

		inteiro numero, multiplicador, resultado
	
		escreva("Entre com o número que deseja calcular a tabuada: ")
		leia(numero)

		para(multiplicador=1; multiplicador <= 10; multiplicador++){
			
	     	resultado = numero * multiplicador

	     	escreva("\n", numero, "x", multiplicador, " = ", resultado)
	      
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 206; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */