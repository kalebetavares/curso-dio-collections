package Set;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;


/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/
public class Exercicio2 {

	public static void main(String[] args) {
		Set<LinguagemFavorita> minhasLinguagens = new LinkedHashSet<>() {{
			add(new LinguagemFavorita("JavaScript", 1995, "JetBrains"));
			add(new LinguagemFavorita("Java", 1991 , "Eclipse"));
			add(new LinguagemFavorita("Python", 1991 , "Jupyter"));
		}};
			
		System.out.println("--\tOrdem de inserção\t--");
		for (LinguagemFavorita linguagemFavorita : minhasLinguagens) {
			System.out.println(linguagemFavorita.getNome() + " - " + linguagemFavorita.getAnoDeCriacao() + " - " + linguagemFavorita.getIde());
		}
		
		System.out.println("--\tOrdem natural\t--");
		Set<LinguagemFavorita> minhasLinguagens2 = new TreeSet<>(minhasLinguagens); 
		for (LinguagemFavorita linguagemFavorita : minhasLinguagens2) {
			System.out.println(linguagemFavorita);
		}
		
		System.out.println("--\tOrdem IDE\t--");
		Set<LinguagemFavorita> minhasLinguagens3 = new TreeSet<>(new ComparatoIde()) {{
			add(new LinguagemFavorita("JavaScript", 1995, "JetBrains"));
			add(new LinguagemFavorita("Java", 1991 , "Eclipse"));
			add(new LinguagemFavorita("Python", 1991 , "Jupyter"));
		}};
		for (LinguagemFavorita linguagemFavorita : minhasLinguagens3) {
			System.out.println(linguagemFavorita.getNome() + " - " + linguagemFavorita.getAnoDeCriacao() + " - " + linguagemFavorita.getIde());
		}
		
		System.out.println("--\tOrdem Ano de Criação/Nome");
		Set<LinguagemFavorita> minhasLinguagens4 = new TreeSet<>(new ComparatoAnoNome()) {{
			add(new LinguagemFavorita("JavaScript", 1995, "JetBrains"));
			add(new LinguagemFavorita("Java", 1991 , "Eclipse"));
			add(new LinguagemFavorita("Python", 1991 , "Jupyter"));
		}};
		for (LinguagemFavorita linguagemFavorita : minhasLinguagens4) {
			System.out.println(linguagemFavorita.getNome() + " - " + linguagemFavorita.getAnoDeCriacao() + " - " + linguagemFavorita.getIde());
		}
		
		System.out.println("--\tOrdem Nome/Ano/Ide\t--");
		Set<LinguagemFavorita> minhasLinguagens5 = new TreeSet<>(new ComparatoNomeAnoIde()) {{
			add(new LinguagemFavorita("JavaScript", 1995, "JetBrains"));
			add(new LinguagemFavorita("Java", 1991 , "Eclipse"));
			add(new LinguagemFavorita("Python", 1991 , "Jupyter"));
		}};
		for (LinguagemFavorita linguagemFavorita : minhasLinguagens5) {
			System.out.println(linguagemFavorita.getNome() + " - " + linguagemFavorita.getAnoDeCriacao() + " - " + linguagemFavorita.getIde());
		}
 	}

}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {
	private String nome;
	private Integer anoDeCriacao;
	private String ide;
	
	public LinguagemFavorita (String nome, Integer anoDeCriacao, String ide) {
		this.nome = nome;
		this.anoDeCriacao = anoDeCriacao;
		this.ide = ide;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getAnoDeCriacao() {
		return anoDeCriacao;
	}
	
	public String getIde() {
		return ide;
	}
	
	@Override
	public String toString() {
		return "{" +
				"Nome ='" + nome + '\'' + 
				", Ano de criação = '" + anoDeCriacao + '\'' +
				", Ide = " + ide +
				'}';
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LinguagemFavorita linguagemFavorita = (LinguagemFavorita) o;
		return nome.equals(linguagemFavorita.nome) && anoDeCriacao.equals(linguagemFavorita.anoDeCriacao) && ide.equals(linguagemFavorita.ide);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome, anoDeCriacao, ide);
	}
	
	@Override
	public int compareTo(LinguagemFavorita linguagemFavorita) {
		return this.getNome().compareToIgnoreCase(linguagemFavorita.getNome());
	}
}

class ComparatoIde implements Comparator <LinguagemFavorita> {
	
	@Override 
	public int compare(LinguagemFavorita s1, LinguagemFavorita s2) {
		int ide = s1.getIde().compareTo(s2.getIde());
		return ide;
	}
}

class ComparatoAnoNome implements Comparator <LinguagemFavorita> {
	
	@Override
	public int compare(LinguagemFavorita s1, LinguagemFavorita s2) {
		int anoDeCriacao = s1.getAnoDeCriacao().compareTo(s2.getAnoDeCriacao());
		if(anoDeCriacao != 0) return anoDeCriacao;
		int nome = s1.getNome().compareTo(s2.getNome());
		return nome;
	}
}

class ComparatoNomeAnoIde implements Comparator <LinguagemFavorita> {
	
	@Override
	public int compare(LinguagemFavorita s1, LinguagemFavorita s2) {
		int nome = s1.getNome().compareTo(s2.getNome());
		if(nome != 0 ) return nome;
		int anoDecriacao = s1.getAnoDeCriacao().compareTo(s2.getAnoDeCriacao());
		if(anoDecriacao != 0) return anoDecriacao;
		int ide = s1.getIde().compareTo(s2.getIde());
		return ide;
	}
}