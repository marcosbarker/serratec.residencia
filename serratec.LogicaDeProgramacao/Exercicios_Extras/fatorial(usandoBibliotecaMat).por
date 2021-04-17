programa{
  
  funcao inicio(){
    inteiro x, fat, copiaX

    faca{
      escreva("Digite um valor maior que zero: ")
      leia(x)
    }enquanto(x < 1)

    se(x == 1){
      escreva("O fatorial de 1 é 1!\n")
    }
    senao{
      copiaX = x
      fat = x
      x = x - 1

      enquanto(x > 1){
        fat = fat * x
        x--
      }
      escreva("O fatorial de ", copiaX, " é: ", fat)
    }
  }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 406; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */