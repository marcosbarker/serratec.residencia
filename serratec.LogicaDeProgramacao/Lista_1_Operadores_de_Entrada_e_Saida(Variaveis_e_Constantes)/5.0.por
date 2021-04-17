/*
Lista 1 : Operações de entrada e saída ; Variáveis e constantes
Exercícios sobre o próximo tema :
Dica : Para os exercícios a seguir, leia o código m aioridade_penal.po r na pasta :
Algoritmos Sequenciais/Maioridade Penal e utilize a estrutura “se/senão” para
resolvê-los
5 - Escreva um programa que encontre o valor máximo entre 2 números
Exemplo :
Entrada:
Digite um número: 2
Digite outro número: 1
Saída:
O número 2 é maior que o número 1
*/

programa
{
	
	funcao inicio(){

		inteiro numero1, numero2

		escreva("Digite um número: ")
		leia(numero1)

		escreva("Digite outro número: ")
		leia(numero2)



		se(numero1 > numero2){
			escreva("O número ", numero1, " é maior que o número ", numero2) 

			
		}senao{

			escreva("O número ", numero2, " é maior que o número ", numero1) 
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 479; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */