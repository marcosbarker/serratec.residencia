programa
{
	
	funcao inicio()
	{
	/*
	 * 1 - Escreva um programa para verificar se um triângulo pode ser formado pelo valor
		fornecido para os ângulos.
		Exemplo de entrada:
		40 55 65
		Saída esperada:
		O triângulo não é válido
		*/
		inteiro angulo1, angulo2, angulo3
		
		escreva("\nEntre com o primeiro ângulo: ")
		leia(angulo1)
		
		escreva("\nEntre com o segundo ângulo: ")
		leia(angulo2)
		
		escreva("\nEntre com o terceiro ângulo: ")
		leia(angulo3)
		
		se( (angulo1+angulo2+angulo3 == 180) e (angulo1!=0) e (angulo2!=0) e (angulo3!=0) )
		{
			escreva("\nÉ um triangulo!")
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
 * @POSICAO-CURSOR = 554; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */