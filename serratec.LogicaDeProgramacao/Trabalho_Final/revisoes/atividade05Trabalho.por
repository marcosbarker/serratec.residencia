programa{
    //Desenvolva um programa no qual o usuário informa 10 números e programa responde qual é o 
    //menor, o maior e a média dos valores.

        const inteiro tamanho = 10
        inteiro vetorInteiros[tamanho]
        inteiro maior, menor 
        real media = 0.0

    funcao inicio()
    {

        para(inteiro i = 0 ; i < tamanho; i++)
        {
            escreva("Informe o ", i+1,"º número : ")
            leia(vetorInteiros[i])
            limpa()
            media += vetorInteiros[i]
        }

        maior = vetorInteiros[0]
        menor = vetorInteiros[0]
        inteiro i = 1


        enquanto( i < tamanho ){

            se(vetorInteiros[i] > maior){
                maior = vetorInteiros[i]
            }

            se(vetorInteiros[i] < menor){
                menor = vetorInteiros[i]
            }

            i++
        }
        escreva("======================")
        escreva("\nElemento minimo :", menor)
        escreva("\nElemento máximo :", maior)
        escreva("\nMédia :", media/tamanho)
        escreva("\n======================")
    }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1097; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */