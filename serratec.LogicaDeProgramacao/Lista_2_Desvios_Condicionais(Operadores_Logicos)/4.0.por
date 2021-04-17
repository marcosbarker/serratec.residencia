/*
Lista 2 - Desvios Condicionais, Operadores Lógicos
4 - Escreva um programa que funcione como uma calculadora simples de soma (+),
subtração(-), multiplicação(*) e divisão(/)
Exemplo de entrada:
10
2
*
Saída esperada:
10 * 2 = 20
*/
 
programa
{
	
	funcao inicio(){
		
		real n1, n2, resposta
		caracter operador
	
		escreva("Digite um número: ")
		leia(n1)
		
		escreva("Digite um número: ")
		leia(n2)
		
		escreva("Digite a operação desejada (+, -, *, /): ")
		leia(operador)


		se(operador == '+'){
			resposta = n1 + n2
			escreva(resposta)
			
		}senao{

			se(operador == '-'){
				resposta = n1 - n2
				escreva(resposta)

			}senao{

				se(operador == '*'){
					resposta = n1 * n2
					escreva(resposta)
					
				}senao{

					se(operador == '/'){
						resposta = n1 / n2
						escreva(resposta)
						
					}senao{

						escreva("Operador inválido")
		
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
 * @POSICAO-CURSOR = 232; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */