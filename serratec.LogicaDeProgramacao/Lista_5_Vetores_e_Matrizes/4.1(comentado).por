/*
Lista 5 : Vetores e Matrizes
4 - Escreva uma função que ordena um vetor com 20 números.
Dica : Pesquisar por Bubble Sort

**Esta com entrada manual para 5 números, para um teste mais rápido.

****ATENÇÂO*****
Primeiramente entenda o que é ordenação por flutuação (metodo Bubble Sort).
Links referência:
https://pt.wikipedia.org/wiki/Bubble_sort
https://medium.com/@henriquebraga_18075/algoritmos-de-ordena%C3%A7%C3%A3o-i-bubble-sort-c162a67261ef
****************
*/

programa
{
  
	funcao inicio(){
  	
		inteiro vetor[5], i, armazenaTroca, ordena = 1  //'vetor[5]' esta com 5 indices
											   //'i' usado para chamar a posição do indice
											   //'armazenaTroca'
											   //'ordena' 	

 	     escreva("Ordenação por método Bubble Sort\n")  //apenas para fins de organização e (beleza) rs
    
   	     para(i = 0; i < 5; i++){				       //'i' indice iniciando em 0(primeiro "espaço" de um vetor) e 5 representado o maior indice	  	
       		escreva("Entre com o ", i, "ª número: ")  //entrada manual dos números a serem ordenados, seram armazenado nos incides 0 até n (no nosso caso n é iqual a 5)
          	leia(vetor[i])						  //quando o i(0) for menor que o último indice(tamanho do vetor) o para termina e pula para o próximo	
       	}

          escreva("\nSequência de entrada: ")
     
          para(i = 0; i < 5; i++){					//esse 'para' é apenas para imprimir na tela o vetor(sequencia de entrada) 					
      		escreva(vetor[i], " ")				
          }
    
      	enquanto(ordena == 1){					//'ordena' ordena a troca, enquanto o 'para' trocar um elemento, o código entra no 'enquanto'
      		ordena = 0						//'ordena' é reatribuido com 0, para poder receber a mensagem de troca no final
     
      		para(i = 0; i < 5 - 1 ; i++){          //o '5-1' é pq não existe o incice 5 e sim a posição 5, tambem funcionaria i < 4.
      			se(vetor[i] > vetor[i + 1]){      //compara a posição atual com a proxima(a celula visinha)
      
          			armazenaTroca = vetor[i]     //'armazenaTroca' recebe a troca, caso a condição a cima seja verdadeira
          			vetor[i] = vetor[i + 1]      //faz a troca, sobre o número maior
         				vetor[i + 1] = armazenaTroca //recebe o número da troca e passa para o proximo
         				
         				ordena = 1                   //se uma troca for feita o 'ordena' recebe um e, o 'enquanto' volta a acontece
        			}						    //se não existir troca o 'ordena' continua 0 e, o codigo não entra no 'enquanto'	
			}
		}
    
  	     escreva("\nSequência ordenada: ")
    
   	     para(i = 0; i < 5; i++){                   //imprime a sequencia (vetor[i]) ordenado.
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
 * @POSICAO-CURSOR = 1470; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 21, 10, 5}-{i, 21, 20, 1}-{armazenaTroca, 21, 23, 13}-{ordena, 21, 38, 6};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */