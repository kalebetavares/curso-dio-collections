package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/*Dada a população estimada de alguns estados do Nordeste brasileiro, faça:
 Estado = PE - População = 9.616.621
 Estado = AL - População = 3.351.543
 Estado = CE - Popualção = 9.187.103
 Estado = RN - População = 3.534.265
 
1 - Crie um dicionário e relacione os estados e suas populações;
2 - Substitua a população do estado do RN por 3.534.165;
3 - Confira se o estado PB está no dicionário, caso não, adicione: PB - 4.039.277;
4 - Exiba a população de PE;
5 - Exiba todos os estados e suas populações na ordem que foi informado;
6 - Exiba os estados e suas populações em ordem alfabética;
7 - Exiba o estado com a menor população e sua quantidade;
8 - Exiba o estado com a maior população e sua quantidade;
9 - Exiba a soma da população desses estados;
10 - Exiba a média da população deste dicionário de estados;
11 - Remova os estados com a população menor que 4.000.000;
12 - Apague o dicionário de estados;
13 - Confira se o dicionário está vazio.	
*/
public class Exercicio1Map {

	public static void main(String[] args) {
		System.out.println("--\tDesafio 1\t--");
		Map<String, Nordeste> estadosNE = new HashMap<>() {
			private static final long serialVersionUID = 1L;

		{
			put("Pernambuco", new Nordeste("PE", 9616621));
			put("Alagoas", new Nordeste("AL", 3351543));
			put("Ceará", new Nordeste("CE", 9187103));
			put("Rio Grande do Norte", new Nordeste("RN", 3534265));
		}};
		for (Map.Entry<String, Nordeste> estado : estadosNE.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("--\tDesafio 2\t--");
		estadosNE.replace("Rio Grande do Norte", new Nordeste("RN", 3534165));
		for (Map.Entry<String, Nordeste> estado : estadosNE.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("--\tDesafio 3\t---");
		System.out.println(estadosNE.containsKey("PB"));
		estadosNE.put("Paraíba", new Nordeste("PB", 4039277));
		
		System.out.println("--\tDesafio 4\t--");
		System.out.println(estadosNE.get("Pernambuco"));
		
		System.out.println("--\tDesafio 5\t--");
		Map<String, Nordeste> estadosNE1 = new LinkedHashMap<>() {
			private static final long serialVersionUID = 1L;

		{
			put("Pernambuco", new Nordeste("PE", 9616621));
			put("Alagoas", new Nordeste("AL", 3351543));
			put("Ceará", new Nordeste("CE", 9187103));
			put("Rio Grande do Norte", new Nordeste("RN", 3534165));
			put("Paraíba", new Nordeste("PB", 4039277));
		}};
		for (Map.Entry<String, Nordeste> estado : estadosNE1.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("--\tDesafio 6\t--");
		Map<String, Nordeste> estadosNE2 = new TreeMap<>(estadosNE1);
		for (Map.Entry<String, Nordeste> estado : estadosNE2.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("--\tDesafio 7\t--");
		Map<String, Integer> estadosNE3 = new HashMap<>() {
			private static final long serialVersionUID = 1L;

		{ 
			put("PE", 9616621);
			put("AL", 3351543);
			put("CE", 9187103);
			put("RN", 3534165);
			put("PB", 4039277);
		}};
		Integer menorPopulacao = Collections.min(estadosNE3.values());
		Set<Map.Entry<String, Integer>> entries = estadosNE3.entrySet();
		String menorEstado = "";
		
		for (Map.Entry<String, Integer> entry : entries) {
			if(entry.getValue().equals(menorPopulacao)) {
				menorEstado = entry.getKey();
			System.out.println("Menor População: " + menorEstado + " - " + menorPopulacao);
			}
		}
		
		System.out.println("--\tDesafio 8\t--");
		Integer maiorPopulacao = Collections.max(estadosNE3.values());
		Set<Map.Entry<String, Integer>> entries1 = estadosNE3.entrySet();
		String maiorEstado = "";
		
		for (Map.Entry<String, Integer> entry : entries1) {
			if(entry.getValue().equals(maiorPopulacao)) {
				maiorEstado = entry.getKey();
				System.out.println("Maior População: " + maiorEstado + " - " + maiorPopulacao);
			}
		}
		
		System.out.println("--\tDesafio 9\t--");
		Iterator<Integer> iterator = estadosNE3.values().iterator();
		Integer soma = 0;
		while(iterator.hasNext()) {
			soma += iterator.next();
		}
		System.out.println("Soma das populações de todos estados: " + soma);
		
		System.out.println("--\tDesafio 10\t--");
		System.out.println("Média das populações: " + soma/estadosNE3.size());
		
		System.out.println("--\tDesafio 11\t--");
		Iterator<Integer> iterator1 = estadosNE3.values().iterator();
		while(iterator1.hasNext()) {
			if(iterator1.next().equals(4000000)) iterator.remove();
		}
		System.out.println(estadosNE3);
		
		System.out.println("--\tDesafio 12\t--");
		estadosNE.clear();
		estadosNE1.clear();
		estadosNE2.clear();
		estadosNE3.clear();
		
		System.out.println("--\tDesafio 13\t--");
		System.out.println("Conferir se os dicionários estão vazios: " + estadosNE.isEmpty() + " - " + estadosNE1.isEmpty() + " - " + estadosNE2.isEmpty() + " - " + estadosNE3.isEmpty());
	}
	

}

class Nordeste {
	private String estado;
	private Integer populacao;
	
	public Nordeste (String estado, Integer populacao) {
		this.estado = estado;
		this.populacao = populacao;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public Integer getPopulacao() {
		return populacao;
	}
	
	@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;
			Nordeste nordeste = (Nordeste) o;
			return estado.equals(nordeste.estado) && populacao.equals(nordeste.populacao);
	}
	
	@Override
		public int hashCode() {
		return Objects.hash(estado, populacao);
	}
	
	@Override
		public String toString() {
			return "Nordeste{" +
					"estado=" + estado + '\'' +
					", população=" + populacao +
					'}';
		}
}