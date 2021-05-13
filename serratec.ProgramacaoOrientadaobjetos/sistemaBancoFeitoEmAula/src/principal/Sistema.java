package principal;

import java.util.Scanner;

public class Sistema {

	Scanner sc = new Scanner(System.in);
	
	public void menuFuncionario() {
		
		int op = 0;
		
		do {
			limpaTela();
			System.out.println("1 - Abertura de Contas");
			System.out.println("2 - QQ coisa");
			System.out.println("3 - QQ outra coisa");
			System.out.println("4 - Sair");
			op = sc.nextInt();
			switch (op) {
			case 1:
				abrirConta();
				break;
			case 2:
				System.out.println("Qualquer coisa");
				break;
			case 3:
				System.out.println("Qualquer coisa");
				break;
			default:
				break;
			}
			
		}while(op != 4);
	}

	public void abrirConta() {
		String op = null;
		do {
			
			Scanner sc = new Scanner(System.in);
			String teste1, teste2;
			System.out.println("Digite um nome: ");
			teste1 = sc.next();
			System.out.println("Digite um nome: ");
			teste2 = sc.next();
			System.out.println("Teste1 " + teste1 + " Teste2 "+teste2);
			
			System.out.println("Deseja abrir outra conta? (S ou N)");
			op = sc.next();
			
		}while(op.equalsIgnoreCase("N"));
	}
	
	public void limpaTela() {
		for(int i=0; i<10; i++) {
			System.out.println();
		}
	}
}
