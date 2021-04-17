/*
				* Trabalho de avaliação de lógica de programação *
7. Elabora um programa que solicita ao usuário a quantidade de números primos que ele quer que 
seja impresso. Após imprima na tela a quantidade de números primos escolhida. Ex. Entrada 4
Saída 1 2 3 5
*/

programa
{

    funcao inicio(){
    	
        inteiro quantidadeNumPrimos 
        inteiro i = 0
        inteiro contador
        inteiro numPrimos = 2

        escreva("Digite a quantidade desejada de números primos: ")
        leia(quantidadeNumPrimos)

        enquanto (i < quantidadeNumPrimos){ //Laço para realização do cálculo da quantidade solicitada de números primos.
            contador = 0
            
                para (inteiro j = 1; j <= 9; j++){
                    se(numPrimos%j == 0){
                        contador++
                    }
                }
                
                se(numPrimos > 10 e numPrimos%numPrimos == 0){
                    contador++
                }
                
                se(contador == 2){ //Condição para destacar os números primos.
                    escreva(numPrimos, " ")
                    i++
                }
                
                numPrimos++
        }
    }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1220; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */