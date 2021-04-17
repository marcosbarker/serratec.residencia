programa
{
	
	funcao inicio()
	{
		inteiro i

		imprimeLinha() //chama funcao

		escreva("\nNúmeros entre linhas\n")
		leia(i) 
				
		imprimeLinha()

		para(i = 1; i <= 5; i++){
			escreva("\n", i)
		}
		
		escreva("\n")
		imprimeLinha() //chama funcao
	}

	funcao imprimeLinha(){

		para(inteiro i = 0; i < 20; i++){
			escreva("*")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 128; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */