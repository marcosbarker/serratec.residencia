/*
Lista 4 : Funções e Recursividade
3 - Utilize a função do exercício 1 para verificar se 5 alunos conseguiram média acima
de 7 para passar no curso de programação. ( crie uma nova função para dizer se os
alunos passaram ou não ) :
Exemplo de entrada:
Número de alunos : 5
Digite a nota 1 do aluno 1 : 5
Digite a nota 2 do aluno 1 : 9
...
Saída esperada
Aluno 1 passou
Digite a nota 1 do aluno 2 :
*/

programa
{
	
	funcao inicio(){

		real nota1, nota2, media
		inteiro alunos

		escreva("Quantidade de alunos: ")
		leia(alunos)

		para(inteiro i = 1; i <= alunos; i++){
			escreva("Entre com a 1ª nota do aluno ", i, " : ")
			leia(nota1)
			
			escreva("Entre com a 2ª nota do aluno ", i, " : ")
			leia(nota2)

			media = (nota1 + nota2) /2
			escreva("A média do alunor é: ", media, "\n")

		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 799; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */