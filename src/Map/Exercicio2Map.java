package Map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*Faça um programa que simule um lançamento de dados.
  Lance o dado 100 vezes e armazene.
  Depois, mostre quantas vezes cada valor foi inserido.
 */
public class Exercicio2Map {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite quantas vezes o dado deve ser lançado: ");
		int dado = entrada.nextInt();
		
		Random gerador = new Random();
		
		Map<Integer, Integer> numDados = new LinkedHashMap<>() {
			private static final long serialVersionUID = 1L;
		{
		
		for(int i = 0; i < dado; i++) {
			put(i,gerador.nextInt(6)+1);
		}
		
		}};
		
		Integer Dado1 = 0;
		Integer Dado2 = 0;
		Integer Dado3 = 0;
		Integer Dado4 = 0;
		Integer Dado5 = 0;
		Integer Dado6 = 0;
		
		
		for (Map.Entry<Integer, Integer> dados : numDados.entrySet()) {
		/*System.out.println(dados.getKey() + " - " + dados.getValue());*/
			if(dados.getValue() == 1) Dado1++;
			if(dados.getValue() == 2) Dado2++;
			if(dados.getValue() == 3) Dado3++;
			if(dados.getValue() == 4) Dado4++;
			if(dados.getValue() == 5) Dado5++;
			if(dados.getValue() == 6) Dado6++;
		}	
		
		System.out.println("Número 1 foi jogado: " + Dado1);
		System.out.println("Número 2 foi jogado: " + Dado2);
		System.out.println("Número 3 foi jogado: " + Dado3);
		System.out.println("Número 4 foi jogado: " + Dado4);
		System.out.println("Número 5 foi jogado: " + Dado5);
		System.out.println("Número 6 foi jogado: " + Dado6);
		
		entrada.close();
	}
		
}


