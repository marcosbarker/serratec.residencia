programa
{
/*Faça um programa que mostre um menu contendo 2 opções: 1. Fibonacci 2. Fatorial. Ao escolher o 
numero 1 solicite que o usuário escolha a quantidade de números da série de Fibonacci ele quer 
imprimir e execute a função recursivamente. Ao escolher a opção 2 solicite ao usuário que escolha 
o número que deseja para o cálculo do Fatorial e execute a função recursivamente.
	 * 
	 */
	inteiro a = 1, b = 0
	
	funcao inicio()
	{
		inteiro opcao, num

		escreva("Escolha a operação desejada\n")
            escreva("====================\n")
            escreva("| 1 - Fibonacci |\t\n")
            escreva("| 2 - Fatorial  |\t\n")
            escreva("====================\n")
            leia(opcao)

            se(opcao == 1)
            {
            		escreva("Digite a quantidade de números da serie de Fibonacci: ")
            		leia(num)
            		escreva("\nA serie de Fibonacci é: \n", b, "  ", a, " ")
            		loopFibonacci(num)
            }
            se(opcao == 2){
            	escreva("Digite um número para calcular seu fatorial: ")
            	leia(num)
            	escreva("\nO fatorial de ", num, " é: ", loopFatorial(num), "\n")
            }
	}
	
	inteiro indiceFibonacci = 0
	funcao loopFibonacci(inteiro num){
		inteiro aux

		se(indiceFibonacci < num - 2){
			aux = b + a
			b = a
			a = aux
			escreva(" ", aux," ")
			indiceFibonacci++
			loopFibonacci(num)
		}
		}
	inteiro indiceFatorial = 0
	funcao inteiro loopFatorial(inteiro num){
		se(indiceFatorial < num){
			retorne num * loopFatorial(num - 1)
		}
		senao{
			retorne 1
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1177; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */