/*
Lista 5 : Vetores e Matrizes
5 - Escreva uma função que calcula a média dos números de um vetor, excluindo o
maior e o menor valor.
*/

programa
{
		
	inclua biblioteca Util
    
	funcao inicio(){
		
		inteiro vetorTamanho[5]

    		para (inteiro i = 0; i < Util.numero_elementos(vetorTamanho); i++){
    			vetorTamanho[i] = Util.sorteia(1, 100)
    			escreva(vetorTamanho[i]," ")
    			
    		}
		
		media(vetorTamanho)            
    	}

	funcao media(inteiro vetor[]){	
		
		inteiro recebe = Util.numero_elementos(vetor)
    		inteiro minimo = 100
   		inteiro maximo = 0
   		real soma = 0.0
   		real media = 0.0
                    
		para(inteiro j = recebe - 1; j >= 0; j--){
        		se (vetor[j] > maximo){
           		maximo = vetor[j]
          	
          	}senao se (vetor[j] < minimo){
          		minimo = vetor[j]
          	}                 
		}

		para(inteiro k = 0; k < recebe; k++){
	   		soma = soma + vetor[k]
	   	}
		
	  	soma = (soma - minimo - maximo)
	  	media = (soma/(recebe - 2))
	  	escreva("\nAguarde...")
		Util.aguarde(2000)
		
	  	escreva("A média dos 5 números de um vetor,excluindo o valor mínimo e o valor máximo é: ", media,"\n")
	}    
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 676; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */