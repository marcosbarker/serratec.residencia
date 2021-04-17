programa
{
	/*
	3 - Escreva uma função que retorna todos os 
	valores duplicados de um array
	*/
	funcao inicio()
	{
		const inteiro tamanho = 6
		const inteiro tamanhoDuplicados = 3
		inteiro k = 0
		logico temValor = falso
		
		inteiro vetorInteiros[tamanho] = {1, 7, 5, 1, 7, 5}
		inteiro vetorDuplicados[tamanhoDuplicados] = {-1, -1, -1}

//		para(inteiro i = 0; i < tamanho; i++)
//		{
//			escreva("Digita a posição ", i, " do vetor: ")
//			leia(vetorInteiros[i])
//		}
		
		para(inteiro i = 0; i<tamanho; i++)
		{
			para(inteiro j = i + 1; j < tamanho; j++)
			{
				se(vetorInteiros[i] == vetorInteiros[j])
				{
					escreva(vetorInteiros[j], " ")
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
 * @POSICAO-CURSOR = 285; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {k, 11, 10, 1}-{temValor, 12, 9, 8}-{vetorInteiros, 14, 10, 13}-{vetorDuplicados, 15, 10, 15}-{i, 23, 15, 1}-{j, 25, 16, 1};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */