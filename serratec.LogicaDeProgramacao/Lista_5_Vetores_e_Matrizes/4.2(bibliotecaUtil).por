/*
Lista 5 : Vetores e Matrizes
4 - Escreva uma função que ordena um vetor com 20 números.
Dica : Pesquisar por Bubble Sort
*/

programa
{
    inclua biblioteca Util
    funcao inicio(){

    inteiro vet[15], i, auxiliar, ordena = 1

	    para(i = 0; i < 15; i++){
	         vet[i] = Util.sorteia(1, 20)
    	    }

	    escreva("Vetor gerado: ")
	
	    para(i = 0; i < 15; i++){
	         escreva(vet[i], " ")
    	    }

	    escreva("\n")

	    enquanto(ordena == 1){
		    ordena = 0
         
	         para(i = 0; i < 15 - 1 ; i++){
		         se(vet[i] > vet[i+1]){
	      	  	  auxiliar = vet[i]
	                 vet[i] = vet[i+1]
	                 vet[i+1] = auxiliar
	                 ordena = 1
     	        }
		    }
         }

	    escreva("\nSequência ordenada: ")
   
	    para(i = 0; i < 15; i++){
		    escreva(vet[i], " ")
    	    }

	    escreva("\n")
  	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 878; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */