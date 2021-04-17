/*
Lista 3 : Laços de Repetição ( enquanto, para até )
Exercícios sobre o próximo tema :
Dica : Para o exercício a seguir, leia o código p rocedimento_funcao.po r na pasta
: Subrotinas/Procedimento e Função e utilize a estrutura “enquanto” para
resolvê-los.
6 - Reescreva o código da calculadora e transforme cada uma das operações ( + - * / )
em uma função.
*/

programa
{

	funcao inicio(){
		
		real numero1, numero2, resultado
		cadeia operacao 

		escreva("Entre com o 1ª número: ")
		leia(numero1)

		escreva("Entre com o 2º número: ")
		leia(numero2)

		escreva("Entre com o operador +, -, *, /: ")
		leia(operacao)

		resultado=0.0
		resultado = calculadora(numero1,numero2,operacao,resultado)
		escreva("Resultado: ", calculadora(numero1,numero2,operacao,resultado))
	
	}	

	funcao real calculadora(real numero1, real numero2, cadeia operacao,real resultado){
		se (operacao == "+"){
			retorne soma(numero1,numero2,resultado)
		
		}se (operacao == "-"){
			retorne sub(numero1,numero2,resultado)
		
		}se (operacao == "*"){
			retorne mult(numero1,numero2,resultado)
		
		}se (operacao == "/"){
			retorne div(numero1,numero2,resultado)
		
		}senao{
			retorne 0.0
		}
	}
			
		funcao real soma(real numero1,real numero2,real resultado){
			resultado = numero1 + numero2
            	retorne resultado
		}
		
		funcao real sub(real numero1,real numero2,real resultado){	
            	resultado= numero1 - numero2
               retorne resultado
          }
		
		funcao real mult(real numero1,real numero2,real resultado){
               resultado= numero1 * numero2
               retorne resultado
          }
		
		funcao real div(real numero1,real numero2,real resultado){
               resultado= numero1 / numero2
            	retorne resultado
         }
}            
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 358; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */