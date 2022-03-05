package Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*Dadas as seguintes informa��es sobre meus livros favoritos e seus autores,
  crie um dicion�rio e ordene este dicion�rio:
  exibindo (Nome Autor - Nome Livro);
 
  Autor = Cury, Augusto - Livro = nome: Manual para jovens estressados. p�ginas: 176
  Autor = Tolle, Eckhart - Livro = nome: O poder do agora. p�ginas: 236
  Autor = Hunter, James - Livro = nome: O monge e o executivo. p�ginas: 144
*/

public class ExemploOrdenacaoMap {

	public static void main(String[] args) {
		
		System.out.println("--\tOrdem aleat�ria\t--");
		Map<String, Livro> meusLivros = new HashMap<>() {
			private static final long serialVersionUID = 1L;

		{
			put("Cury, Augusto", new Livro("Manual para jovens estressados", 176));
			put("Tolle, Eckhart", new Livro("O poder do agora", 236));
			put("Hunter, James", new Livro("O monge e o executivo", 144));
		}};
		for (Map.Entry<String, Livro> livros  : meusLivros.entrySet() ) {
			System.out.println(livros.getKey() + " - " + livros.getValue());
		}
		
		System.out.println("--\tOrdem de Inser��o\t--");
		Map<String, Livro> meusLivros1 = new LinkedHashMap<>() {
			private static final long serialVersionUID = -1L;

		{
			put("Cury, Augusto", new Livro("Manual para jovens estressados", 176));
			put("Tolle, Eckhart", new Livro("O poder do agora", 236));
			put("Hunter, James", new Livro("O monge e o executivo", 144));
		}};
		for (Map.Entry<String, Livro> livros : meusLivros1.entrySet() ) {
			System.out.println(livros.getKey() + " - " + livros.getValue());
		}
		
		System.out.println("--\tOrdem alfab�tica autores\t--");
		
		Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
		for (Map.Entry<String, Livro> livros : meusLivros2.entrySet() ) {
			System.out.println(livros.getKey() + " - " + livros.getValue());
		}
		
		System.out.println("--\tOrdem alfab�tica nomes dos livros\t--");
		
		Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
		meusLivros3.addAll(meusLivros.entrySet());
		for (Map.Entry<String, Livro> livros : meusLivros3) {
			System.out.println(livros.getKey() + " - " + livros.getValue());
		}
		
		System.out.println("--\tOrdem n�mero de p�gina\t--");
		Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorPaginas());
		meusLivros4.addAll(meusLivros3);
		for (Map.Entry<String, Livro> livros : meusLivros4) {
			System.out.println(livros.getKey() + " - " + livros.getValue());
		}
	}

}

class Livro {
	private String nome;
	private Integer paginas;
	
	public Livro(String nome, Integer paginas) {
		this.nome = nome;
		this.paginas = paginas;	
	}
	
	public String getNome() {
	return nome;	
	}
	
	public Integer getPaginas() {
		return paginas;
	}
	
	@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;
			Livro livro = (Livro) o;
			return nome.equals(livro.nome) && paginas.equals(livro.paginas);
		}
	
	@Override
		public int hashCode() {
			return Objects.hash(nome, paginas);
	}
	

	@Override
		public String toString() {
			return "Livro{" +
					"nome='" + nome + '\'' + 
					", paginas=" + paginas +
					'}';
			}
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {
	
	@Override
	public int compare (Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
		return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
	}
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>> {
	
	@Override
	public int compare (Map.Entry<String, Livro> p1, Map.Entry<String, Livro> p2) {
		return p1.getValue().getPaginas().compareTo(p2.getValue().getPaginas());
	}
}