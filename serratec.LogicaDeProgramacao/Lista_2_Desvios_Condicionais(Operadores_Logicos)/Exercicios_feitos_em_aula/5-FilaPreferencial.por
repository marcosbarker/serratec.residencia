programa
{
	
	funcao inicio()
	{
			/*
			* Implemente um programa tomador de decisão que considera as seguintes opções
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
			inteiro idade, condicao, sexo
			escreva("Digite sua idade: ")
			leia(idade)
			escreva("Digite seu Sexo: \n1 - Feminino \n2 - Masculino \n")
			leia(sexo)
			escreva("Possui condicao especial: \n1 - Gestante \n2 - Deficiente \n3 - Não \n")
			leia(condicao)

			se(idade >= 60 ou (condicao == 1 e sexo == 1) ou condicao == 2)
			{
				escreva("Fila preferencial!")
			}
			senao
			{
				escreva("Fila comum!")
			}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 476; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */