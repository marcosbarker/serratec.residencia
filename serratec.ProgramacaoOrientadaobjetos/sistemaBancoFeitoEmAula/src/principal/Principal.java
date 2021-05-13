package principal;

import java.io.IOException;
import java.text.ParseException;

import IO.LeituraEscrita;
import conta.ContaCorrente;
import exception.ContaException;
import exception.PessoalException;

public class Principal {
	
	public static void main(String[] args) throws PessoalException, ContaException, ParseException, IOException {
//		Sistema sistema =  new Sistema();
//		sistema.menuFuncionario();
		
		LeituraEscrita.leitor("teste2.txt");
		
		
		
		//LeituraEscrita.escritor(null);
		
		
	}

	
		
		
		
		
		
		
		
		
		
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//		System.out.println("Digite uma data: ");
//		String data = sc.next();
//		
//		//Date date = new Date();
//		System.out.println("Data sem formatação: "+data);
//		System.out.println("Data com formatação: " + simpleDateFormat.format( simpleDateFormat.parse(data) ) );

//		Scanner sc = new Scanner(System.in);
		
//		GregorianCalendar gc = new GregorianCalendar();
//		System.out.println(simpleDateFormat.format(gc.getTime()));
//		//Mostra qual o dia da semana 1 = domingo, 2=segunda, etc
//		System.out.println(gc.get(gc.DAY_OF_WEEK));
//		//Adiciona 2 meses à data atual
//		gc.add(gc.DAY_OF_MONTH, 78);
//		System.out.println(simpleDateFormat.format(gc.getTime()));
//		//Imprime falso. 2009 não é bissexto.
//		System.out.println(gc.isLeapYear(1996));
//		//Atribui a data do GregorianCalendar à uma variável Date
//		Date d1 = gc.getTime(); 
//		//Armazena a data de d1 para o GregorianCalendar gc.
//		gc.setTime(d1); 
		
////		LocalDate hoje = LocalDate.now();
////		System.out.println("LocalDate antes de formatar: " + hoje);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
////		String hojeFormatado = hoje.format(formatter);
////		System.out.println("LocalDate depois de formatar: " + hojeFormatado);
//		
//		LocalDateTime agora = LocalDateTime.now();
//		System.out.println("LocalDateTime antes de formatar: " + agora);
//		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//		String agoraFormatado = agora.format(formatter);
//		System.out.println("LocalDateTime depois de formatar: " + agoraFormatado);
		
		
//		Map<Integer, Usuario> mapUsuarios = new HashMap<>();
//		String liDoArquivo = "PRESIDENTE";
//
//		if(liDoArquivo.equalsIgnoreCase(UsuarioTipoEnum.PRESIDENTE.getNome())) {
//			Presidente p = new Presidente();
//			p.setId(1);
//			mapUsuarios.put(1, p);
//		}
//		else if(liDoArquivo.equalsIgnoreCase(UsuarioTipoEnum.DIRETOR.getNome())) {
//			Diretor p = new Diretor();
//			p.setId(1);
//			mapUsuarios.put(1, p);
//		}
//		else if(liDoArquivo.equalsIgnoreCase(UsuarioTipoEnum.GERENTE.getNome())) {
//			Gerente p = new Gerente();
//			p.setId(1);
//			mapUsuarios.put(1, p);
//		}
//		else if(liDoArquivo.equalsIgnoreCase(UsuarioTipoEnum.CLIENTE.getNome())) {
//			Cliente p = new Cliente();
//			p.setId(1);
//			mapUsuarios.put(1, p);
//		}
//
//		
//		for(int i = 0; i< mapUsuarios.size(); i++) {
//			Usuario u = mapUsuarios.get(i);
//			if(liDoArquivo.equalsIgnoreCase(UsuarioTipoEnum.PRESIDENTE.getNome())) {
//				Presidente presidente = (Presidente)mapUsuarios.get(i);
//			}
//			else if(liDoArquivo.equalsIgnoreCase(UsuarioTipoEnum.DIRETOR.getNome())) {
//				Diretor diretor = (Diretor)mapUsuarios.get(i);
//			}
//			else if(liDoArquivo.equalsIgnoreCase(UsuarioTipoEnum.GERENTE.getNome())) {
//				Gerente gerente = (Gerente)mapUsuarios.get(i);
//			}
//			else if(liDoArquivo.equalsIgnoreCase(UsuarioTipoEnum.CLIENTE.getNome())) {
//				Cliente cliente = (Cliente)mapUsuarios.get(i);
//			}
//		}
		
		//LeituraEscrita.leitor(null);

//		Map<Integer, ContaCorrente> mapaDeContas = new HashMap<>();
//		
//		List<ContaCorrente> listaDeContas = new ArrayList<>();
//
//		for(int i = 1; i<1000; i++) {
//			ContaCorrente cCorrente = new ContaCorrente();
//			cCorrente.setNumero(i);
//			cCorrente.setCPF("789.456.123-99");
//			cCorrente.setNome("Fulano");          
//			cCorrente.setSobrenome("da silva");
//			cCorrente.setInvestimento(200);
//			cCorrente.setTarifa(1);
//			cCorrente.depositar(i*10);
//			
//			mapaDeContas.put(i, cCorrente);
//			listaDeContas.add(cCorrente);
//		}
//		
//		ContaCorrente contaLista = null;
//		for(int i=0; i< listaDeContas.size(); i++) {
//			if(listaDeContas.get(i).getNumero() == 548) {
//				contaLista = listaDeContas.get(i);
//				break;
//			}
//		}
//		
//		ContaCorrente contaMap = mapaDeContas.get(548);
//		
//		System.out.println(contaMap.toString());
//		System.out.println(contaLista);
//	}
		
//		boolean inseriu;
//		Set<String> cargos = new HashSet<>();
//		inseriu = cargos.add("Gerente");
//		inseriu = cargos.add("Diretor");
//		inseriu = cargos.add("Presidente");
//		inseriu = cargos.add("Secretaria");
//		inseriu = cargos.add("Funcionario");
//		inseriu = cargos.add("Diretor"); // repetido!
//		inseriu = cargos.add("Funcionario"); // repetido!
//		inseriu = cargos.add("Presidente"); // repetido!
//		// imprime na tela todos os elementos
//		System.out.println(cargos);
//
//	}
		
//		Gerente g = new Gerente();
//		g.setSalario(5000);
//		g.setNome("Marcelo");
//		Estagiario e = new Estagiario();
//		e.setSalario(1500);
//		e.setNome("Aline");
//		Diretor d = new Diretor();
//		d.setSalario(2000);
//		d.setNome("Yan");
//		List<Funcionario> listaF = new ArrayList<>();
//		listaF.add(g);
//		listaF.add(e);
//		listaF.add(d);
//		System.out.println("Lista Antes: \n\t" + listaF);
//		Collections.sort(listaF); // qual seria o critério para esta ordenação?
//		
//		System.out.println("Lista Crescente: \n\t" + listaF);
//		Collections.reverse(listaF); // qual seria o critério para esta ordenação?
//		
//		System.out.println("Lista Decrescente: \n\t" + listaF);
//
//	}

//		List<String> nomes = new ArrayList<>();
//		nomes.add("Dayane");
//		nomes.add("Yan");
//		nomes.add("Gustavo");
//		nomes.add("Lilica");
//		nomes.add("Igor");
//		nomes.add("Robson");
//		nomes.add("Daniel");
//
//		System.out.println(nomes);
//		Collections.sort(nomes);
//		System.out.println(nomes);
//
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//		try {
//			
//			Gerente gerente = new Gerente();
//			gerente.setNome("Gerente");
//			gerente.setCpf("123.456.789-10");
//			gerente.setSalario(5000.00);
//			gerente.setNumFuncionarios(2);
//			
//			Estagiario estagiario = new Estagiario();
//			estagiario.setNome("Estagiario");
//			estagiario.setCpf("123.456.789-11");
//			estagiario.setSalario(1000.00);
//			estagiario.setFuncionarioAssistido("Gerente");
//			
//			Diretor diretor = new Diretor();
//			diretor.setNome("Diretor");
//			diretor.setCpf("123.456.789-12");
//			diretor.setSalario(9000.00);
//			diretor.setParticipacaoLucros(1000.00);
//			
//			OperadorCaixa opCaixa = new OperadorCaixa();
//			opCaixa.setNome("OperadorCaixa");
//			opCaixa.setCpf("123.456.789-13");
//			opCaixa.setSalario(2000.00);
//			opCaixa.setTerminalCaixa(1);
//			
//			ContaCorrente cCorrente = new ContaCorrente();
//			cCorrente.setNumero(1);
//			cCorrente.setCPF("789.456.123-99");
//			cCorrente.setNome("Fulano");
//			cCorrente.setSobrenome("da silva");
//			cCorrente.setInvestimento(200);
//			cCorrente.setTarifa(1);
//			
//			ContaPoupanca cPoupanca = new ContaPoupanca();
//			cPoupanca.setNumero(2);
//			cPoupanca.setCPF("789.456.123-99");
//			cPoupanca.setNome("Bentrano");
//			cPoupanca.setSobrenome("da silva");
//			cPoupanca.setVencimento(2);
//			cPoupanca.setRendimento(30);
//			
//			FolhaPagamento fp = new FolhaPagamento();
//			System.out.println("Despesa com Diretor: "+fp.calculaPagamento(diretor));
//			System.out.println("Despesa com Gerente: "+fp.calculaPagamento(gerente));
//			System.out.println("Despesa com Estagiario: "+fp.calculaPagamento(estagiario));
//			System.out.println("Despesa com Operador de Caixa: "+fp.calculaPagamento(opCaixa));
//			
//		}
//		catch (PessoalException e) {
//			System.out.println("Popup para o Usuário: " + e);
//		}
//		catch (ContaException e) {
//			System.out.println("Popup para o Usuário: " + e);
//		}
//		catch (FinanceiroException e) {
//			System.out.println("Popup para o Usuário: " + e);
//		}
//		catch (Exception e) {
//			System.out.println("Ocorreu um erro inesperado: " + e);
//		}
//		
//		
//	}

	
	
	
	
	
	
	
	
	
	

		
		
//		double numero1 = 10;
//		System.out.println("numero1 "+numero1);
//		int numero2 = (int) numero1;
//		System.out.println("numero2 "+numero2);
//		System.out.println("numero1 "+(double)numero2);
		
		
				
//		Gerente gerente = new Gerente();
//		Funcionario funcionario = new Gerente();
//		funcionario.setSalario(5000.0);
//		((Gerente) funcionario).getNumFuncionarios();

//		Funcionario funcionario = new Gerente();
//		funcionario.setSalario(5000.0);


//		Código de exemplo de uso de assistente e gerente		
//		Assistente a1 = new Assistente();
//		a1.setNome("Dayane");
//		a1.setCpf("456");
//		a1.setSalario(1000);
//				
//		Gerente g1 = new Gerente();
//		g1.setNome("Marcelo");
//		g1.setCpf("123");
//		g1.setSalario(1000);
//		
//		Diretor d1 = new Diretor();
//		d1.setNome("Fred");
//		d1.setCpf("789");
//		d1.setSalario(1000);
//		
//		Funcionario f = a1;
//		
//		FolhaPagamento folha = new FolhaPagamento();
//		System.out.println("Pagamento Assistente: " + folha.calculaPagamento(a1));
//		System.out.println("Pagamento Gerente: "    + folha.calculaPagamento(g1));
//		System.out.println("Pagamento Diretor: "    + folha.calculaPagamento(d1));
		
//		Implementação de exemplo de uso das contas		
//		Conta conta = new Conta();
//		conta.setNome("Marcelo");
//		conta.setSobrenome("Collares");
//		conta.depositar(1000);
//		System.out.println(conta.toString() + "\n");
//		
//		Conta conta1 = new Conta();
//		conta1.setNome("Yan");
//		conta1.setSobrenome("Tedesco");
//		conta1.depositar(1000);
//		System.out.println(conta1.toString() + "\n");
//		
//		ContaPoupanca conta2 = new ContaPoupanca();
//		conta2.setNome("Bryan");
//		conta2.setSobrenome("Valadares");
//		conta2.depositar(1000);
//		System.out.println(conta2.toString() + "\n");
//		
//		System.out.println("O numero de contas criadas é: " + conta.getTotalContas());
		

//	}

}
