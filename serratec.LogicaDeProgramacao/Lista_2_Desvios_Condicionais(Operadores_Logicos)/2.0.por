/*
Lista 2 - Desvios Condicionais, Operadores Lógicos
2 - Escreva um programa para verificar se um triângulo é Equilátero, Isósceles ou
Escaleno.
Exemplo de entrada:
50 50 60
Saída esperada:
O triângulo é isósceles

Equilatero tres angulo iquais
Escaleno tres angulo diferentes
Isoceles dois angulo iguais
*/
 
programa
{
	
	funcao inicio(){

		inteiro a1, a2, a3
		
		escreva("Entre com 1 angulo: ")
		leia(a1)
		escreva("Entre com 1 angulo: ")	
		leia(a2)	
		escreva("Entre com 1 angulo: ")	
		leia(a3)	

		se(a1 + a2 + a3 == 180 e a1 > 0 e 02 > 0 e a3 > 0){
			escreva("É triangulo")
		}
			
		se(a1 != a2 e a2 != a3 e a1 != a3){
			escreva("escaleno")						
			
		}senao{

			se(a1 == a2 e a2 == a3){
			escreva("equilatero")
					
			}senao{

			escreva("isosceles")
			
			}
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 306; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */