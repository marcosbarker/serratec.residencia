/*
         * Trabalho de avaliação de lógica de programação*
9. Elabore um programa que calcule uma equação do 2° Grau modelo ax2+bx+c.
Solicite a entrada das variáveis a, b, c e calcule as raízes. 
Apresente no final do cálculo a equação composta pelas variáveis lidas e o resultado. 
Ex. Entrada a=1, b=-5, c=6. Saída 1x2 - 5x – 6 =0 -> X1=3 X2=2
*/

programa
{
    inclua biblioteca Matematica --> mat
    
    inteiro a, b, c, x1, x2, delta
    
	funcao inicio(){

		escreva("Calcula equação de 2ª grau (ax² + bx + c)\n")
    	
     	escreva("Entre com valor de 'a': ")
		leia (a)
          escreva("Entre com valor de 'b': ")
          leia (b)
          escreva("Entre com valor de 'c': ")
          leia (c)
          
          delta = mat.potencia(b, 2) - (4*a*c)
          
          limpa()
        
		se ((delta < 0) ou (a==0)){
            escreva("Delta menor que 0 ou 'a' igual a 0", "\n") 
            escreva("Não é possivel calcular/n")
       
		}senao{
	            x1 = (-b + mat.raiz(delta, 2)) /(2*a)
	            x2 = (-b - mat.raiz(delta, 2)) /(2*a)

		       escreva("Entrada a= ", a, ", b= ", b, ", c= ", c, "\n") 
	            escreva("Saída ", a, "x² ", b, "x - ", c, " = 0\n") 
	            //escreva("Delta = ", delta, "\n")
	            escreva("x' = ", x1, "\nx''= ", x2, "\n")
	
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1188; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */