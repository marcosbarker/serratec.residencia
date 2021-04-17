/*
Lista 5 : Vetores e Matrizes
3 - Escreva uma função que retorna todos os valores duplicados de um array
*/

programa
{	
	funcao inicio(){
		
		inteiro  vetorTamanho[5]
		escreva("Informe os números: ")
		
		para(inteiro i = 0; i < 5; i++){
			leia(vetorTamanho[i])
		}
		
		limpa()	
		
		verificarDuplicidade(vetorTamanho)
	}
	
	funcao verificarDuplicidade (inteiro vetor[]){
		escreva("Valores duplicados do array: ")
		para(inteiro auxiliar = 0; auxiliar < 5; auxiliar++){
			para(inteiro i = auxiliar + 1; i < 5; i++){
				se (vetor[i] == vetor[auxiliar]){
					escreva(vetor[i], " ")
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
 * @POSICAO-CURSOR = 271; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */