package test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {

		Map<String, String> nomesPorCpf = new HashMap<String, String>();

		nomesPorCpf.put("12345", "Jo�o Alberto");
		nomesPorCpf.put("35478", "Alberto Jo�o");
		nomesPorCpf.put("7458", "Jo�o Gilberto");
		nomesPorCpf.put("88747", "Maria de Lurdes");
		nomesPorCpf.put("36547", "Guilhermina ");

		if (nomesPorCpf.containsKey("12345")) {
			System.out.println("existe");
		} else {
			System.out.println("N�o existe");
		}
		System.out.println(nomesPorCpf.get("7458"));
	}
}
