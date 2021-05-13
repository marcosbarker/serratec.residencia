package conta;

public interface ContaOnline {

	static final double LIMITE_TRANSFERENCIA = 10000;

	public void transfereViaPix();

	public void transfereViaTED();

	public void transfereViaDOC();

}