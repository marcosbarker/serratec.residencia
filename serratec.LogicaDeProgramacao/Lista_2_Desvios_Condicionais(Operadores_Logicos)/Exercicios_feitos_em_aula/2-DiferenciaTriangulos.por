programa
{
	
	funcao inicio()
	{
		/*
		Escreva um programa para verificar se um triângulo é Equilátero, Isósceles ou
		Escaleno.
		Exemplo de entrada:
		50 50 60
		Saída esperada:
		O triângulo é isósceles

		Equilátero - tres angulo iguais
		Escaleno - tres angulo diferentes
		Isósceles - dois angulo iguais
		*/

		inteiro a1, a2, a3
		escreva("Entre com 1 angulo: ")
		leia(a1)
		escreva("Entre com 2 angulo: ")
		leia(a2)
		escreva("Entre com 3 angulo: ")
		leia(a3)

		se( (a1+a2+a3==180) e (a1>0) e (a2>0) e (a3>0) )
		{
			
			escreva("\nÉ um triangulo ")
			se( (a1 != a2) e (a2 != a3) e (a1 != a3) )
			{
				escreva("escaleno")
			}
			senao
			{
				se( (a1 == a2) e (a2 == a3) )
				{
					escreva("equiláreto")
				}
				senao
				{
					escreva("isosceles")
				}
			}
		}
		senao
		{
			escreva("\nNão é um triangulo!")
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 615; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */