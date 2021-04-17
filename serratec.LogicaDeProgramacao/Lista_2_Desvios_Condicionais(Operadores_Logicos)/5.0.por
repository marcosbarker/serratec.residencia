/*
Lista 2 - Desvios Condicionais, Operadores Lógicos
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
	inteiro idade, condS, sexo
		
	funcao inicio(){
		
		escreva("Digite sua idade: ")
		leia(idade)

		escreva("Qual seu sexo: \n1 - Feminino \n2 - Masculino \n")
		leia(sexo)

		escreva("Possui condição especial: \n1 - Gestante \n2 - Deficiente \n3 - Não \n")
		leia(condS)

		se(idade >= 60 ou condS == 1 e sexo == 1 ou condS == 2){
			escreva("Fila preferencial")
			
		}senao{

			escreva("Fila preferencial")
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 550; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */