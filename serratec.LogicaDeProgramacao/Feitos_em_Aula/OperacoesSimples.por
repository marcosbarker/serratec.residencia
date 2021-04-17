programa
{
	
	funcao inicio()
	{
		/*
		Escreva um programa que funcione como uma calculadora simples de soma (+),
		subtração(-), multiplicação(*) e divisão(/)
		Exemplo de entrada:
		10
		2
		*
		Saída esperada:
		10 * 2 = 20
		*/
		real n1, n2, resposta
		caracter operacao
		
		escreva("Digite um numero: ")
		leia(n1)
		
		escreva("Digite um numero: ")
		leia(n2)
		
		escreva("Digite a operação desejada (+, -, *, /): ")
		leia(operacao)

		se(operacao == '+')
		{
			resposta = n1 + n2
			escreva("O resultado da soma é ", resposta)
		}
		senao
		{
			 se(operacao == '-')
			 {
			 	resposta = n1 - n2
			 	escreva("O resultado da subtraçã o é ", resposta)
			 }
			 senao
			 {
			 	se(operacao == '*')
			 	{
			 		resposta = n1 * n2
			 		escreva("O resultado da multiplicação é ", resposta)
			 	}
			 	senao
			 	{
			 		se(operacao == '/')
			 		{
			 			resposta = n1 / n2
			 			escreva("O resultado da divisão é ", resposta)
			 		}
			 		senao
			 		{
			 			escreva("Operacao inválida!")
			 		}
			 	}
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1019; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */