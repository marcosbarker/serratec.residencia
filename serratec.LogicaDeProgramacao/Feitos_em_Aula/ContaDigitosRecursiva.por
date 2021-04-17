programa
{
	/*
		5 - Escreva um programa que calcule o número de dígitos de um dado número usando
		recursão:
			Exemplo de entrada​:
				100
			Saída esperada:
				O número de dígitos do número é : 3
	*/
	
	funcao inicio()
	{
		inteiro numero, divisao, contador = 0
		
		escreva("Digite um numero: ") //100
		leia (numero)

		contador = contaDigitosRecursiva(numero, contador)

		escreva("O numero ", numero, " tem ", contador, " digitos.")
	}
	
	funcao inteiro contaDigitosRecursiva(inteiro divisao, inteiro contador)
	{
		se(divisao == 0)
		{
			retorne contador
		}
		senao
		{
			contador++
			retorne contaDigitosRecursiva(divisao / 10, contador)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 601; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {numero, 14, 10, 6}-{divisao, 14, 18, 7}-{contador, 14, 27, 8}-{divisao, 24, 46, 7};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */