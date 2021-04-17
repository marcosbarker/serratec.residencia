/*1. Leia dois valores e efetue a divisão do primeiro pelo segundo. O segundo valor não pode ser ZERO
ou negativo, caso isso ocorra você deve informar ao usuário que o segundo número deve ser maior
do que ZERO e solicitar um novo valor. Deverá imprimir o resultado. Ao final deve perguntar se
deseja calcular outra divisão e caso sua resposta seja positiva limpe a tela e solicite novos valores.*/

programa
{
	
	funcao inicio()
	{
		real num1, num2, divisao
		logico x = verdadeiro
		inteiro numEscolha

			enquanto(x == verdadeiro){
				escreva("Escreva o primeiro número: ")
				leia(num1)
		
				escreva("Escreva o segundo número: ")
				leia(num2)
		
			
			enquanto (num2 <= 0){
				escreva("Opção inválida.")
	               escreva(" ")
	               escreva("\nDigite um número maior que zero: ")
	               leia(num2)
	               limpa()
			}
				divisao = num1 / num2
			
			se(num2 > 0)
			{
				limpa()
				escreva("===========================================================")
				escreva("\n= A divisão do primeiro número ", num1, " pelo segundo ", num2, " é ", divisao, " =\n") 
				escreva("===========================================================")
				escreva("\n\nVocê quer realizar mais alguma divisão?\n\n[1] - Sim\n[2] - Não\n\nEscolha: ")
				leia(numEscolha)

				escreva("\n")
	
				se(numEscolha == 1){
					x = verdadeiro
					limpa()
				}
				senao{
					x = falso
					limpa()
					escreva("\nFim da operação!! ")
					
				}
			}
		}
	}
}


/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1091; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
