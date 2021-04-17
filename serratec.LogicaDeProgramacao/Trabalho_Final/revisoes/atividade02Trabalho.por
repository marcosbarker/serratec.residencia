programa
{
	inclua biblioteca Util --> u
	
	funcao inicio()
	{
		inteiro opcao = 0
		real variavel, n1, n2, n3
		logico x = verdadeiro

		faca
		{
			escreva ("Digite um numero: ")
			leia (n1)
	
			escreva ("\nDigite outro numero: ")
			leia (n2)

			escreva("Escolha a operação desejada\n")
			escreva("====================\n")
			escreva("1 - Soma \n")
			escreva("2 - Subtração \n")
			escreva("3 - Multiplicação \n")
			escreva("4 - Divisão \n")
			escreva("9 - Cancelar \n")
			escreva("====================\n")
			leia(opcao)

			
			se(opcao<=4 e opcao>0)
			{
				se(opcao == 1)
					soma(n1, n2)
				senao se(opcao==2)
					subtracao(n1, n2)
				senao se(opcao==3)
					multiplicacao(n1, n2)
				senao se(opcao==4)
					divisao(n1, n2)

				escreva("\nVocê quer realizar mais alguma operação? 1 - Sim ou 2 - Não \n")
				leia(n3)
	
				se(n3 == 1)
				{
					x = verdadeiro

					limpa()
					escreva("Reiniciando...")
					u.aguarde(1000)
					limpa()
				}
				senao
				{
					x = falso
			
				}
				
			}

			senao
			{
				x = falso
			}

		}enquanto (x == verdadeiro)
		
			limpa()
			escreva("Desligando...")
			u.aguarde(1000)
			limpa()
			escreva(";)")
			
	}
	
	funcao soma(real n1, real n2)
	{
		limpa()
		escreva("A soma de ", n1, " e ", n2," é: ",n1+n2,"\n\n")
	}
	funcao subtracao(real n1, real n2)
	{
		limpa()
		escreva("A subtração de ", n1, " e ", n2," é: ",n1-n2,"\n\n")
	}
	funcao multiplicacao(real n1, real n2)
	{
		limpa()
		escreva("A multiplicação de ", n1, " por ", n2," é: ",n1*n2,"\n\n")
	}
	funcao divisao(real n1, real n2)
	{
		limpa()
		escreva("A divisão de", n1, " por ", n2," é: ",n1/n2,"\n\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1390; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
