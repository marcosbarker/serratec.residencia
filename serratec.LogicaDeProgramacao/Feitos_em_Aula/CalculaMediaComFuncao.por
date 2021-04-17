programa
{


	/*
		1 - Escreva uma função que recebe 2 números e calcule a média entre eles :
		Exemplo de entrada​:
		Digite o primeiro número: 2
		Digite o segundo número : 6
		Saída esperada:
		A média é : 4
	 */
	
	funcao inicio()
	{
		real num1, num2, resultado
		escreva("Digite um numero: ")
		leia(num1)
		escreva("Digite outro numero: ")
		leia(num2)
		resultado = media(num1, num2)

		escreva("A média de ", num1 , " e ", num2, " é ", resultado)
	}
	funcao apresentacao(){
		
	}
	
	funcao real media(real num1, real num2)
	{
		retorne (num1 + num2)/2
	}
	
	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 567; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */