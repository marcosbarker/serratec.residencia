programa
{
	/*
		3 - Utilize a função do exercício 1 para verificar se 5 alunos conseguiram média acima
		de 7 para passar no curso de programação. ( crie uma nova função para dizer se os
		alunos passaram ou não ) :
			Exemplo de entrada​:
				Número de alunos : 5
				Digite a nota 1 do aluno 1 : 5
				Digite a nota 2 do aluno 1 : 9
			...
			Saída esperada
				Aluno 1 passou
				Digite a nota 1 do aluno 2 :
	*/
	funcao inicio()
	{
		real nota1, nota2, media
		inteiro numAlunos
	
		escreva("Número de alunos: ")
		leia(numAlunos)

		para(inteiro i = 0; i < numAlunos; i++){
			
			escreva("Digite a nota 1 do aluno ", i+1, " : ")
			leia(nota1)		
			escreva("Digite a nota 2 do aluno ", i+1, " : ")
			leia(nota2)
	
			media = ( nota1 + nota2 ) /2
			escreva("A média do aluno é: ", media, "\n")

			alunoPassou(media, i)

		}
	}

	funcao alunoPassou(real media, inteiro i){
		
		se(media >=7){
			escreva("Aluno ", i+1, " passou!\n\n")
		}
		senao{
			escreva("Aluno ", i+1, " reprovou!\n\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 806; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */