package test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {
		
		List<String> nomes = Arrays.asList("João","Pedro","Maria","Jose");
		Set<String>nomesConjunto = new HashSet<>(Arrays.asList("João","Pedro","Maria","Jose"));
		Collection<String> nomesCollection = new LinkedList<>();
		List<String> nomesLista = new LinkedList<>();
		nomesLista.get(0);
		//nomesCollection
		for (String string : nomesConjunto) {
			if("Maria".equals(string)) {
				System.out.println("Maria");
			}
		}
		
		System.out.println(nomes.get(2));
		
	}
}
