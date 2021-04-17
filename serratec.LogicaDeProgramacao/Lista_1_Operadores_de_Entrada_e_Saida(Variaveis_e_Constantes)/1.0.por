/*
Lista 1 : Operações de entrada e saída ; Variáveis e constantes
1 - Escreva um programa que receba do teclado seu nome e seu sobrenome
separadamente e escreva na tela seu nome completo como no exemplo abaixo:
Exemplo:
Entrada:
Digite seu nome : Fulano
Digite seu sobrenome : de Tal
Saída:
Meu nome é : Fulano de Tal
*/

programa
{
	
	funcao inicio(){
		
		cadeia nome, sobrenome

		escreva("Qual seu primeiro nome? \n>")
		leia(nome)

		escreva("Qual seu sobrenome? \n>")
		leia(sobrenome)

		escreva(nome, " ",sobrenome)
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 319; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */