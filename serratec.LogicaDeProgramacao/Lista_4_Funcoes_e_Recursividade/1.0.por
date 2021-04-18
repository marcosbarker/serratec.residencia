/*
Lista 4 : Funções e Recursividade
1 - Escreva uma função que recebe 2 números e calcule a média entre eles :
Exemplo de entrada :
Digite o primeiro número: 2
Digite o segundo número : 6
Saída esperada:
A média é : 4
*/

programa
	{

	funcao inicio(){
		
		real numero1, numero2, resultado

		escreva("Calcula média entre dois números\n")
		
		escreva("Entre com o 1ª número: ")
		leia(numero1)
		
		escreva("Entre com o 2ª número: ")
		leia(numero2)
		
		resultado = media(numero1, numero2)

		escreva("A média de ", numero1 , " e ", numero2, " é ", resultado)
	
	}
		
	funcao real media(real numero1, real numero2){
		retorne (numero1 + numero2)/2

	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 570; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */