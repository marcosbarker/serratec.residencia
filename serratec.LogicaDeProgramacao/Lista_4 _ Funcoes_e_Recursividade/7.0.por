/*
Lista 4 : Funções e Recursividade
*Exercícios sobre o próximo tema :
Dica : Para os exercícios a seguir, leia o código p reence_vetorpo r na pasta :
Vetores e Matrizes/Preenche e Exibe Vetor e utilize a estrutura do vetor “ [ ] “
para resolvê-los.
7 - Escreva um programa que armazene elementos em um vetor e encontra o valor
mínimo e máximo
Exemplo de entrada :
Armazene 5 elementos em um vetor :
Elemento - 0 : 1
Elemento - 1 : 4
Elemento - 2 : 3
Elemento - 3 : 8
Elemento - 4 : 6
Saída esperada:
Elemento máximo : 1
Elemento minimo : 8
*/

programa
{
	
	funcao inicio(){
	
		const inteiro vetorTamanho = 5
	       	 inteiro numerosEntrada[vetorTamanho], numero, maximo, minimo, media
			
	       	 escreva("Entre com "+ vetorTamanho +" números no vetor \n")
		 
		para(inteiro i = 0; i < vetorTamanho; i++){
		  	escreva("Elemento "+ i +": ")
			leia(numero)
			numerosEntrada[i]=numero
		}

		 maximo = numerosEntrada[0]
		 minimo = numerosEntrada[0]
		
		 para (inteiro j = 0 ; j < vetorTamanho; j++){   //pega maior e menor valor
		  	se(numerosEntrada[j] > maximo){
				maximo = numerosEntrada[j]
			}
			
			senao se(numerosEntrada[j] < minimo){
				minimo = numerosEntrada[j]
			}
		}

		escreva("Elemento máximo: " + maximo)
		escreva("\nElemento minimo: " + minimo)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 938; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */