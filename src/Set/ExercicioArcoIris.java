package Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/*Exercicio proposto na aula de Set:
  	Crie um conjunto contendo as cores do arco-íris e:
  	A. Exiba todas as cores uma abaixo da outra.
  	B. A quantida de cores que o arco-íris tem
  	C. Exiba as cores em ordem alfabética.
  	D. Exiba as cores na ordem inversa da que foi informada.
  	E. Exiba todas as cores que começam com a letra "v".
  	F. Removas todas as cores que não começam com a letra "v".
  	G. Limpe o conjunto.
  	H. Verifique se o conjunto está vazio.
 */
public class ExercicioArcoIris {
	public static void main(String[] args) {
		System.out.println("--\tTodas as cores do Arco-Íris\t--");
		Set<ArcoIris> meuArcoIris = new LinkedHashSet<>() {{
			add(new ArcoIris("vermelho"));
			add(new ArcoIris("laranja"));
			add(new ArcoIris("amarelo"));
			add(new ArcoIris("verde"));
			add(new ArcoIris("azul"));
			add(new ArcoIris("anil"));
			add(new ArcoIris("violeta"));
		}};
		
		for (ArcoIris arcoIris : meuArcoIris) {
			System.out.println(arcoIris);
		}
		
		System.out.println("--\tQuantidade de cores do Arco-Íris\t--");
		System.out.println("Cores = " + meuArcoIris.size());
		
		System.out.println("--\tOrdem alfabética\t--");
		Set<ArcoIris> meuArcoIris1 = new TreeSet<>() {{
			add(new ArcoIris("vermelho"));
			add(new ArcoIris("laranja"));
			add(new ArcoIris("amarelo"));
			add(new ArcoIris("verde"));
			add(new ArcoIris("azul"));
			add(new ArcoIris("anil"));
			add(new ArcoIris("violeta"));
		}};
		
		for (ArcoIris arcoIris : meuArcoIris1) {
			System.out.println(arcoIris.getCor());
		}
		
		System.out.println("--\tOrdem Inversa\t--");
		List<String> meuArcoIris2 = new ArrayList<>() {{
			add(new String("vermelho"));
			add(new String("laranja"));
			add(new String("amarelo"));
			add(new String("verde"));
			add(new String("azul"));
			add(new String("anil"));
			add(new String("violeta"));
		}};
		Collections.reverse(meuArcoIris2);
		for (String arcoIris : meuArcoIris2) {
			System.out.println(arcoIris);
		}
		
		System.out.println("--\tTodas as cores com a letra inicial V\t--");
		for (String arcoIris : meuArcoIris2) {
			if(arcoIris.startsWith("v")) {
				System.out.println(arcoIris);
			}
		}
		
		System.out.println("--\tRemova todas as cores que não começam com a letra V\t--");
		Iterator<String> iterator = meuArcoIris2.iterator();
		while(iterator.hasNext()) {
			if(!iterator.next().startsWith("v")) iterator.remove();
		}
		System.out.println(meuArcoIris2);
		
		System.out.println("--\tLimpe os conjuntos\t--");
		meuArcoIris.clear();
		meuArcoIris1.clear();
		meuArcoIris2.clear();
		System.out.println("--\tVerifique se os conjuntos estão vazios\t--");
		System.out.println(meuArcoIris.isEmpty());
		System.out.println(meuArcoIris1.isEmpty());
		System.out.println(meuArcoIris2.isEmpty());
	}
}


class ArcoIris implements Comparable<ArcoIris> {
	private String cor;
	
	public ArcoIris (String cor) {
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}
	
	@Override
	public String toString() {
		return "{" +
				"Cor = " + cor +
				'}';
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cor);
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		ArcoIris arcoIris = (ArcoIris) o;
		return cor.equals(arcoIris.cor);
	}

	@Override
	public int compareTo(ArcoIris arcoIris) {
		return this.getCor().compareTo(arcoIris.getCor());
	}
}

	
