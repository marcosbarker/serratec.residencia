/*
Lista 3 : Laços de Repetição ( enquanto, para até )
3 - Escreva um programa que imprima o seguinte padrão de número em formato de
triângulo dado um número n.
Exemplo de entrada :
4
Saída esperada:
1
12
123
1234
*/
 
programa
{
	               
	funcao inicio(){
		
		inteiro N, contador1, contador2 	
		 
		escreva("Entre com o número para base da pirâmide: ")
		leia(N)
			
		para(contador1 = 1; contador1 <= N; contador1++){
										
			para(contador2 = 1; contador2 <= contador1; contador2++){	
				escreva(contador2, " ")
					
			}
				escreva("\n")
				
		}			 
	}
}	

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 214; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {contador1, 19, 13, 9}-{contador2, 19, 24, 9};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */