/*
Lista 1 : Operações de entrada e saída ; Variáveis e constantes
3 - Uma empresa paga R$10.00 por hora normal trabalhada e R$ 15.00 por hora extra.
Escreva um algoritmo que leia o total de horas normais e o total de horas extras
trabalhadas por um empregado em um ano e calcule o salário anual deste trabalhador.
Exemplo :
Entrada :
Digite o número de horas trabalhadas no ano : 1760
Digite o número de horas extras trabalhadas no ano : 400
Saída :
Seu salário anual é de : R$ 23600 
*/
 
programa
{
	
	funcao inicio(){

		inteiro horaN, horaE, resultado

		escreva("Digite o número de horas trabalhadas no ano: ")
		leia(horaN)

		escreva("Digite o número de horas extras trabalhadas no ano: ")
		leia(horaE)

		horaE = horaE * 15
		horaN = horaN * 10

		resultado = horaE + horaN

		escreva("Seu salário anual é de R$ " + resultado)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 841; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */