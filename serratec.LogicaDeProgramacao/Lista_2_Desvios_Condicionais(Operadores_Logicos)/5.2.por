/*
5 - Implemente um programa tomador de decisão que considera as seguintes opções
para determinar se o usuário usará a fila preferencial ou a fila comum.
O usuário usa a fila preferencial caso :
● Possui mais de 60 anos : Usa fila preferencial
● É deficiente físico : Usa fila preferencial
● É mulher gestante : Usa fila preferencial
O programa recebe como entrada a Idade, Sexo e a condição especial do usuário, se
houver.
Exemplo de entrada:
22
homem
deficiente
Saída esperada:
Fila preferencial
*/

programa
{
	
	funcao inicio(){

		inteiro idade
		cadeia sexo, deficienteFisico, gestante, condicaoEspecial

		escreva("Tomador de desisão para fila preferencial \n")

		escreva("Qual sua idade: ")
		leia(idade)

		escreva("Qual seu gênero? Responda M ou F: ")
		leia(sexo)

		escreva("Possui alguma condição especial? Responda sim ou não: ")
		leia(condicaoEspecial)

		escreva("É deficiente físico? Responda sim ou não: ")
		leia(deficienteFisico)

		escreva("É gestante? Responda sim ou não: ")
		leia(gestante)


		se(idade > 60 ou condicaoEspecial == "sim" ou deficienteFisico == "sim" ou gestante == "sim" e sexo == "F"){

		escreva("Fila preferencial")
		
		}senao{

		escreva("Fila comum")

	
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 553; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */