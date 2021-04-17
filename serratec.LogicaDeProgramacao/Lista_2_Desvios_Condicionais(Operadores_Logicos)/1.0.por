/*
Lista 2 - Desvios Condicionais, Operadores Lógicos
1 - Escreva um programa para verificar se um triângulo pode ser formado pelo valor
fornecido para os ângulos.
Exemplo de entrada:
40 55 65
Saída esperada:
O triângulo não é válido
*/

programa
{
	
	funcao inicio(){
		
		inteiro ang1, ang2, ang3
		
		escreva("Digite o primeiro ângulo: ")
		leia(ang1)
		
		escreva("Digite o segundo ângulo: ")
		leia(ang2)
		
		escreva("Digite o terceiro ângulo: ")
		leia(ang3)

		se(ang1 + ang2 + ang3 == 180 e ang1 != 0 e ang2 != 0 e ang3 != 0){
			escreva("É triangulo")
		
		}senao{

			escreva("Não é triangulo")
		}
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