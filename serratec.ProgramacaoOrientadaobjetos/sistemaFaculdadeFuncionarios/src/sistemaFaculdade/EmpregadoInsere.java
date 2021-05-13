package sistemaFaculdade;

public class EmpregadoInsere {

	public static void main(String[] args) {
		Professor p1 = new Professor("Prof01", 7000, 48);
		Professor p2 = new Professor("Prof02", 6000, 37);
		
		p1.getGastos();
		p2.getGastos();
		
		Relatorio r1 = new Relatorio();
		
		System.out.println("Relatorio\n----------------------");
		r1.relatorio(p1); 
		r1.relatorio(p2);
		r1.gastos(p1);
		r1.gastos(p2);
		System.out.println("Total Gasto:  R$ " + r1.getGastosTotais());
		
		
	}

}