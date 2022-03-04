package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
Dada os modelos dos carros e seus respectivos consumos na estrada, fa�a:
modelo = gol - consumo = 14,4km/l
modelo = uno - consumo = 15,6 km/l
modelo = mobi - consumo = 16,1 km/l
modelo = hb20 - consumo = 14,5 km/l
modelo = kwid - consumo = 15,6 km/l
*/
public class ExemploMap {

	public static void main(String[] args) {
		
		System.out.println("Crie um dicion�rio que relacione os modelos e seus respectivos consumos: ");
		Map<String, Double> carrosPopulares = new HashMap<>() {
			private static final long serialVersionUID = 1L;

		{
			put("gol", 14.4);
			put("uno", 15.6);
			put("mobi",16.1);
			put("hb20", 14.5);
			put("kwid",15.6);
		}};
		
		System.out.println(carrosPopulares.toString());
		
		System.out.println("Substitua o consumo do gol por 15,2 km/l: ");
		carrosPopulares.put("gol", 15.2);
		System.out.println(carrosPopulares);
		
		System.out.println("Confira se o modelo tucson est� no dicion�rio: " + carrosPopulares.containsKey("tucson"));
		
		System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));
	
		//System.out.println("Exiba o terceiro modelo adicionado: ");
		
		System.out.println("Exiba os modelos: ");
		System.out.println(carrosPopulares.keySet());
		
		System.out.println("Exiba os consumos dos carros: ");
		System.out.println(carrosPopulares.values());
		
		System.out.println("Exiba o modelo mais econ�mico e seu consumo: ");
		Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
		Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
		String modeloMaisEficiente = "";
		
		for (Map.Entry<String, Double> entry : entries) {
			if(entry.getValue().equals(consumoMaisEficiente)) { 
				modeloMaisEficiente = entry.getKey();
			System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
				}
		}
		
		System.out.println("Exiba o modelo menos econ�mico e seu consumo: ");
		Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
		Set<Map.Entry<String, Double>> entries2 = carrosPopulares.entrySet();
		String modeloMenosEficiente = "";
		for (Map.Entry<String, Double> entry : entries2) {
			if(entry.getValue().equals(consumoMenosEficiente)) { 
				modeloMenosEficiente = entry.getKey();
			System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
			}
		}
		
		Iterator<Double> iterator = carrosPopulares.values().iterator();
		Double soma = 0d;
		while(iterator.hasNext()) {
			soma += iterator.next();
		}
		System.out.println("Exiba a soma dos consumos: " + soma);
	
		System.out.println("Exiba a m�dia dos consumos deste dicion�rio de carros: " + (soma/carrosPopulares.size()));
	
		System.out.println("Remova os modelos com o consumo igual a 15,6 km/l: ");
		Iterator<Double> iterator1 = carrosPopulares.values().iterator();
		while(iterator1.hasNext()) {
			if(iterator1.next().equals(15.6)) iterator1.remove();
		}
		System.out.println(carrosPopulares);
		
		System.out.println("Exiba todos os carros na ordem em que foram informados: ");
		Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {
			private static final long serialVersionUID = 1L;
		{
			put("gol", 15.2);
			put("uno", 15.6);
			put("mobi", 16.1);
			put("hb20", 14.5);
			put("kwid", 15.6);
		}};
		System.out.println(carrosPopulares1.toString());
		
		System.out.println("Exiba o dicion�rio ordenado pelo modelo: ");
		Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
		System.out.println(carrosPopulares2.toString());
		
		System.out.println("Apague o conjunto de carros: ");
		carrosPopulares.clear();
		carrosPopulares1.clear();
		carrosPopulares2.clear();
		System.out.println("Confira se as listas est�o vazias: ");
		System.out.println(carrosPopulares.isEmpty() + " - " + carrosPopulares1.isEmpty() + " - " + carrosPopulares2.isEmpty());
		
		
		
	}
	
}
