programa
{
	
	funcao inicio(){
		
		logico acabouCoronaVirus = falso

		inteiro diasParados = 0

		enquanto(acabouCoronaVirus == falso){
			acabouCoronaVirus = verificaPandemia(diasParados)
			diasParados++
			
		}
		
		escreva("Vamos para a Residência de Sofware!")

	}

	

	funcao logico verificaPandemia(inteiro dias){
		se(dias > 15){
			retorne verdadeiro
		}

		retorne falso
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 386; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */