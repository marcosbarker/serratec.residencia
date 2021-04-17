/*
Lista 3 : Laços de Repetição ( enquanto, para até )
Exercícios sobre o próximo tema :
Dica : Para o exercício a seguir, leia o código p rocedimento_funcao.po r na pasta
: Subrotinas/Procedimento e Função e utilize a estrutura “enquanto” para
resolvê-los.
7 - Escreva uma função que insere um nome em uma mensagem automática :
Exemplo de entrada :
Digite um nome : Fulano
Saída esperada:
Bom dia Fulano!
*/
 
 programa
{
	
	funcao inicio(){
		
		cadeia nome
		
		escreva("Qual o seu nome? ")
		leia(nome)
		limpa()

		nomeNaMensagem(nome)
	}
	
	funcao nomeNaMensagem(cadeia nome){
		escreva("Bom dia ", nome, "!")
				
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 258; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */