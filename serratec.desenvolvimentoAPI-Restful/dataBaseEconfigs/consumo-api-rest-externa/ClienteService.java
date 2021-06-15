@Service
public class ClienteService {
  public ReceitaWsDadosCnpjVO consultarDadosPorCnpj(String cnpj) {
	RestTemplate restTemplate = new RestTemplate();
	String uri = "https://www.receitaws.com.br/v1/cnpj/{cnpj}";	
	Map<String, String> params = new HashMap<String, String>();
	params.put("cnpj", cnpj);
		
	ReceitaWsDadosCnpjVO receitaWsDadosCnpjVO = restTemplate.getForObject(uri, ReceitaWsDadosCnpjVO.class, params);
		
	return receitaWsDadosCnpjVO;
  }
}
