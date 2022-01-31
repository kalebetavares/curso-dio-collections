package List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Utilizando listas, fa�a um programa que fa�a 5 perguntas para uma pessoa sobre um crime. As perguntas s�o:
1. "Telefonou para a v�tima?"
2. "Esteve no local do crime?"
3. "Mora perto da v�tima?"
4. "Devia para a v�tima?"
5. "J� trabalhou com a v�tima?"
Se a pessoa responder positivamente a 2 quest�es ela deve ser classificada como "Suspeita", entre 3 e 4 como
"C�mplice" e 5 como "Assassina". Caso contr�rio, ele ser� classificado como "Inocente".
*/

public class ExercInterrogatorio {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		List<String> respostas = new ArrayList<>();
		
		int numeroSim = 0;
		
		//Perguntas 
		System.out.println("---\tInterrogat�rio\t---");
		//Pergunta 1
		System.out.println("Telefonou para a v�tima?");
		String resposta = entrada.next();
		respostas.add(resposta);
		if(resposta.equalsIgnoreCase("sim")) numeroSim++;
		//Pergunta 2
		System.out.println("Esteve no local do crime?");
		resposta = entrada.next();
		respostas.add(resposta);
		if(resposta.equalsIgnoreCase("sim")) numeroSim++;
		//Pergunta 3
		System.out.println("Mora perto da v�tima?");
		resposta = entrada.next();
		respostas.add(resposta);
		if(resposta.equalsIgnoreCase("sim")) numeroSim++;
		//Pergunta 4 
		System.out.println("Devia para a v�tima?");
		resposta = entrada.next();
		respostas.add(resposta);
		//Pergunta 5
		System.out.println("J� trabalhou com a v�tima?");
		resposta = entrada.next();
		respostas.add(resposta);
		
		//Todas as respostas
		System.out.println("--------------------");
		System.out.println("---\tTodas as respostas\t---");
		for (String respostas1 : respostas) {
			System.out.println(respostas1);
		}
		
		//Seten�a
		if(numeroSim == 5) {
			System.out.println("O interrogado � o assassino!");
		} else if (numeroSim == 3 || numeroSim == 4) {
			System.out.println("O interrogado � o c�mplice");
		} else if (numeroSim == 2) {
			System.out.println("O interrogado � um suspeito!");
		} else if (numeroSim <= 1) {
			System.out.println("O interrogado � inocente!");
		}
		
		entrada.close();
	}

}
