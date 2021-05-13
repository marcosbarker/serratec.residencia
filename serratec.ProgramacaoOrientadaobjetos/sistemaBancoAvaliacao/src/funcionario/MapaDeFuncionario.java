package funcionario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import funcionario.Funcionario;
import funcionario.MapaDeFuncionario;

public class MapaDeFuncionario extends Funcionario {
	
	public MapaDeFuncionario(String cargo) {
		this.cargo = cargo;
		
	}
	
	public static Map<Integer, Funcionario> lerFuncionarios() throws FileNotFoundException, IOException {

		Map<Integer, Funcionario> mapFuncionario = new HashMap<>();

		String linha1;

		try (BufferedReader csvReader1 = new BufferedReader(new FileReader("Funcionario.txt"))) {
			linha1 = csvReader1.readLine();

			while ((linha1 = csvReader1.readLine()) != null) {

				linha1 = linha1.replace("\"", "");

				String[] data = linha1.split(";");

				String cargo = data[1];
				int id = Integer.parseInt(data[0]);

				Funcionario novoFuncionario = new MapaDeFuncionario(cargo);

				mapFuncionario.put(id, novoFuncionario);

			}
			
			return mapFuncionario;
		}
	}
}