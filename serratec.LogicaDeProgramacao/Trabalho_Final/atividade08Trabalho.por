/*
	     *Trabalho de avaliação de lógica de programação*
8. Elabora um programa que peça ao usuário que entre com 10 números. 
Após solicite que o usuário escolha se quer que sejam impressos os 
números em ordem crescente ou decrescente e conforme a escolha do usuário e 
faça a impressão da série.
*/

programa
{
	
	funcao inicio(){
		
		inteiro vetoresInteiro[10], opcao=0 

		para(inteiro i = 0; i < 10; i++){

			escreva("numero ", i, " : ")
			leia(vetoresInteiro[i])
			limpa()
		}

		escreva("Digite 1 para crescente e 2 para decrescente: ") //a interpretação do grupo foi de ordenação pelo indice crescente ou descrecente do vetor
		leia(opcao)                                           
		limpa()

	     se(opcao != 1){
			escreva("Ordem decrescente: ")
			para(inteiro i = 0;i < 10; i++)     //imprime decrescente 
			escreva(vetoresInteiro[9-i], " ") 

		}senao{
			escreva("Ordem crescente: ")
				
			para(inteiro i = 0;i < 10; i++){    //imprime crescente 
			escreva(vetoresInteiro[i], " ")

			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 584; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */