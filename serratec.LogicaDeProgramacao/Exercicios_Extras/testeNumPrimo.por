programa{
  
  funcao inicio(){
    inteiro x, valor = 1, divisores = 0

    escreva("Digite um valor: ")
    leia(x)

    se(x > 0){
      enquanto(valor <= x){
        se(x % valor == 0){
          divisores++
        }
        valor++
      }

      se(divisores == 2){
        escreva("O número ", x, " é primo!\n")
      }
      senao{
        escreva("O número ", x, " não é primo!\n")
      }
    }
    senao{
      escreva("Valor negativo ou igual a zero!\n")
    }
  }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 479; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */