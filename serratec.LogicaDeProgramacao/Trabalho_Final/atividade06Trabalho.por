/*
           * Trabalho de avaliação de lógica de programação *
Elabore um programa em que o usuário informa dois números (n1 e n2) O primeiro número (n1) 
indica o início do laço de repetição e o segundo número (n2) o fim do laço de repetição.
O programa deverá imprimir a soma de todos os números pares no intervalo entre n1 e n2.
*/

programa
{

    funcao inicio(){
    	
        inteiro n1, n2, soma

        escreva ("Digite o número que indique o início do laço: ")
        leia (n1)

        escreva ("Digite o número que indique o fim do laço: ")
        leia (n2)

            se (n1 > n2){
            	funcaoDecrescente(n1, n2)
           
            }senao se (n2 > n1){
            	funcaoCrescente(n1, n2)
            	
            }senao{
            	escreva(n1," e ", n2, " são valores iguais")
            }

	}

    
    funcao funcaoDecrescente(inteiro n1, inteiro n2){
    		inteiro soma=0
	 	
	 	para(inteiro i = n1; i >= n2; i--){
               se (i % 2 == 0 e i >= n2){
                   soma= soma+i
               }
               
         }
         
         escreva ("A soma de todos os números pares: ", soma)
    }
    
    funcao funcaoCrescente(inteiro n1, inteiro n2){
    		  inteiro soma=0
		
		para (inteiro i = n1; i <= n2; i++){
               se (i % 2 == 0 e i <= n2){
                  soma= soma+i
               }
               
          }
          
          escreva ("A soma de todos os números pares: ", soma)
    }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1403; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */