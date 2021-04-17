/*
Lista 5 : Vetores e Matrizes
4 - Escreva uma função que ordena um vetor com 20 números.
Dica : Pesquisar por Bubble Sort

**Esta com entrada manual para 5 números, para um teste mais rápido.

****ATENÇÂO*****
Primeiramente entenda o que é ordenação por flutuação (metodo Bubble Sort)
Links referência:
https://pt.wikipedia.org/wiki/Bubble_sort
https://medium.com/@henriquebraga_18075/algoritmos-de-ordena%C3%A7%C3%A3o-i-bubble-sort-c162a67261ef
****************
*/

programa
{
  
	funcao inicio(){
  	
		inteiro vetor[5], i, armazenaTroca, ordena = 1

 	     escreva("Ordenação por método Bubble Sort\n")
    
   	     para(i = 0; i < 5; i++){
       		escreva("Entre com o ", i, "ª número: ")
          	leia(vetor[i])
       	}

          escreva("\nSequência de entrada: ")
     
          para(i = 0; i < 5; i++){
      		escreva(vetor[i], " ")
          }
    
      	enquanto(ordena == 1){
      		ordena = 0
     
      		para(i = 0; i < 5 - 1 ; i++){
      			se(vetor[i] > vetor[i + 1]){
      
          			armazenaTroca = vetor[i]
          			vetor[i] = vetor[i + 1]
         				vetor[i + 1] = armazenaTroca
         				ordena = 1
        			}
			}
		}
    
  	     escreva("\nSequência ordenada: ")
    
   	     para(i = 0; i < 5; i++){
  	     	escreva(vetor[i], " ")
		}
    
          escreva("\n")
  	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 286; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 21, 10, 5}-{i, 21, 20, 1}-{armazenaTroca, 21, 23, 13}-{ordena, 21, 38, 6};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */