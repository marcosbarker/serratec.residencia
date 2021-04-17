/*
Lista 3 : Laços de Repetição ( enquanto, para até )
5 - Escreva um programa que verifique se um número é um palíndromo ou não.
Exemplo de entrada :
12321
Saída esperada:
12321 é um número palíndromo
*/

programa
{
	
	funcao inicio(){
		
		inteiro sequencia, comparacao = 0, auxGuardaSequencia  // 'sequencia' é o número de entrada a ser avaliado
													//'comparação' vai pegar cada numero da sequencia e passar pelo enquanto
		escreva("\tTeste Palíndromo\n")					//'auxQuardaSequencia' guarda a 'sequencia' original para comparar com 'comparacao' no final	
		escreva("Entre com uma sequência númerica: ")
		leia(sequencia)
		auxGuardaSequencia = sequencia			          // 'auxGuardaSequencia' recebe numero da 'sequencia'
		

		enquanto(sequencia > 0){                              // o 'enquanto' vai rodar 'sequencia' enquanto for maior que 0 
			
			comparacao = comparacao + sequencia % 10        /*'sequencia' divide por 10 e manda o resto (% modulo) para 'comparacao'. 
			                                                   Na prática será colocado um ponto (.) entre o penultimo e ultimo numero. 
			                                                   Tranformando a 'sequencia em decimal e, pegando apenas o numero depois do ponto (resto)*/ 
			
			comparacao = comparacao * 10				  /*'comparacao' aqui esta com o resto da operação enterior, ao ser multiplicado por 10, 
													vira numero inteiro e 'comparacao' passa a ser inteiro	*/
			
			sequencia = sequencia / 10                     /* 'sequencia' divide por 10 e pega apenas o interiro, retirando o ultimo número.
													depois retorna para o 'enquanto' com menos um numero, 
													ísso é feito até a 'sequencia acabar e chegar a 0  ( sequencia > 0). */               
			
		}
		
		comparacao = comparacao / 10					 //'comparacao' é divida por 10 para retornar como inteiro (anteriormente 'comparacao' foi multiplicada)					
  
		se(auxGuardaSequencia == comparacao){              /*compara a sequencia na 'comparacao' com 'auxGuardaSequencia'. 
											        'auxGuardaSequencia' tem o numero da 'sequencia' atribuido no inicio.*/
			escreva(auxGuardaSequencia, " é um número palíndromo")   
			
		}senao{
			escreva(auxGuardaSequencia, " não é um número palíndromo")
		
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 475; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {sequencia, 15, 10, 9}-{comparacao, 15, 21, 10};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */