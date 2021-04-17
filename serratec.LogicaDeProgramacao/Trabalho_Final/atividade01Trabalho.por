/*
				* Trabalho de avaliação de lógica de programação *
1. Leia dois valores e efetue a divisão do primeiro pelo segundo. O segundo valor não pode ser ZERO
ou negativo, caso isso ocorra você deve informar ao usuário que o segundo número deve ser maior
do que ZERO e solicitar um novo valor. Deverá imprimir o resultado. Ao final deve perguntar se
deseja calcular outra divisão e caso sua resposta seja positiva limpe a tela e solicite novos valores.
*/

programa
{
	
	funcao inicio(){
		
		real num1, num2, divisao
		logico x = verdadeiro
		inteiro numEscolha

			enquanto(x == verdadeiro){ //Tipo lógico indicado para possibilitar divisões contínuas. Aguardando verdadeiro ou falso.
				escreva("Escreva o primeiro número: ")
				leia(num1)
		
				escreva("Escreva o segundo número: ")
				leia(num2)
		
			
			enquanto (num2 <= 0){ // Se igual ou menor que "0", o comando será inválido, solicitando um novo valor.
				escreva("Opção inválida.")
	               escreva(" ")
	               escreva("\nDigite um número maior que zero: ")
	               leia(num2)
	               limpa()
			}
				divisao = num1 / num2
			
			se(num2 > 0){ // Se maior que "0", o comando seguirá para a realização da operação.
				
				limpa()
				escreva("===========================================================")
				escreva("\n= A divisão do primeiro número ", num1, " pelo segundo ", num2, " é ", divisao, " =\n") 
				escreva("===========================================================")
				escreva("\n\nVocê quer realizar mais alguma divisão?\n\n[1] - Sim\n[2] - Não\n\nEscolha: ")
				leia(numEscolha)

				escreva("\n")
	
				se(numEscolha == 1){
					x = verdadeiro //Se verdadeiro, o x retornará ao enquanto, possibilitando uma nova operação.
					limpa()
				
				}senao{
					x = falso //Se falso, o x irá encerrar a operação.
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
 * @POSICAO-CURSOR = 452; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */