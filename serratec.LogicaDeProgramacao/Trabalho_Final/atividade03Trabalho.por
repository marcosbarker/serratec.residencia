/*
				* Trabalho de avaliação de lógica de programação *
3. Escreva um programa que leia 10 nomes de alunos e duas notas de avaliações para cada aluno. 
Calcule e escreva a média de cada aluno, seguido da informação se foi aprovado ou reprovado. 
Considere como média para aprovação 6. Dica: Utilize quantos vetores precisar. Ex. Saída: Fulano 
de tal P1= 8.0, P2=6.0, Media=7.0, aprovado!
*/

programa
{
	
	funcao inicio(){
		
		const inteiro tamanho = 10
		cadeia vetorAluno[tamanho]
		real vetormedia[tamanho], vetNota1[tamanho], vetNota2[tamanho]

		escreva("===================================================\n")
		escreva("|                                                 |\n")
		escreva("|Esse programa irá verificar a média de cada aluno|\n")
		escreva("|                                                 |\n")
		escreva("===================================================\n")
		
		
		para(inteiro i = 0; i < tamanho; i++){      //Laço utilizado para entrada das notas nos respectivos vetores.
		
			escreva("\nAluno ", i + 1, ": ")
			leia(vetorAluno[i])
			escreva("Digite a nota da AV1: ")
			leia(vetNota1[i])
			escreva("Digite a nota da AV2: ")
			leia(vetNota2[i])
			vetormedia[i] = (vetNota1[i] + vetNota2[i]) /2
			limpa()
		}
		
		para(inteiro j = 0; j < tamanho; j++){     // laço realizando a saída das notas e médias dos alunos.
		
			escreva(vetorAluno[j])
			escreva(" AV1 = ", vetNota1[j]) 
			escreva(", AV2 = ", vetNota2[j])
			escreva("\nMédia = ", vetormedia[j])
			
			se(vetormedia[j] >= 6){               // Condição para aprovação do aluno.
				escreva("\nAprovado!!\n\n")
				escreva("--------------\n")
			
			}senao{                               // Condição para reprovação do aluno.
				escreva("\nReprovado!!\n\n" )
				escreva("--------------\n")
			}			
		}		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 940; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */