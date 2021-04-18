/*
Lista 4 : Funções e Recursividade
2 - Escreva uma função que receba um ano e diga se ele é bissexto ou não e utilize
esta função para verificar 5 :
Exemplo de entrada :
2017
Saída esperada:
O ano 2017 não é bissexto
*/

programa
{
	
    funcao inicio(){
	
    inteiro ano
    logico bissexto
     
    escreva("Teste ano bissexto\n") 	
    escreva("Ano: ")
    leia(ano)
	
    se( ano % 400 == 0 ){
        bissexto = verdadeiro
         escreva("O ano ", ano, " é bissexto")
    	
    	}senao{
     	se(ano % 4 == 0 e ano % 100 != 0){ 
          	bissexto = verdadeiro
          	 escreva("O ano ", ano, " é bissexto")
    			
    			}senao{
             		bissexto = falso
				escreva("O ano ", ano, " não é bissexto")

			}
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 221; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */