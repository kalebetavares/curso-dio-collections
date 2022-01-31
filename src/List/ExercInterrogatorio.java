package List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como
"Cúmplice" e 5 como "Assassina". Caso contrário, ele será classificado como "Inocente".
*/

public class ExercInterrogatorio {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		List<String> respostas = new ArrayList<>();
		
		int numeroSim = 0;
		
		//Perguntas 
		System.out.println("---\tInterrogatório\t---");
		//Pergunta 1
		System.out.println("Telefonou para a vítima?");
		String resposta = entrada.next();
		respostas.add(resposta);
		if(resposta.equalsIgnoreCase("sim")) numeroSim++;
		//Pergunta 2
		System.out.println("Esteve no local do crime?");
		resposta = entrada.next();
		respostas.add(resposta);
		if(resposta.equalsIgnoreCase("sim")) numeroSim++;
		//Pergunta 3
		System.out.println("Mora perto da vítima?");
		resposta = entrada.next();
		respostas.add(resposta);
		if(resposta.equalsIgnoreCase("sim")) numeroSim++;
		//Pergunta 4 
		System.out.println("Devia para a vítima?");
		resposta = entrada.next();
		respostas.add(resposta);
		//Pergunta 5
		System.out.println("Já trabalhou com a vítima?");
		resposta = entrada.next();
		respostas.add(resposta);
		
		//Todas as respostas
		System.out.println("--------------------");
		System.out.println("---\tTodas as respostas\t---");
		for (String respostas1 : respostas) {
			System.out.println(respostas1);
		}
		
		//Setença
		if(numeroSim == 5) {
			System.out.println("O interrogado é o assassino!");
		} else if (numeroSim == 3 || numeroSim == 4) {
			System.out.println("O interrogado é o cúmplice");
		} else if (numeroSim == 2) {
			System.out.println("O interrogado é um suspeito!");
		} else if (numeroSim <= 1) {
			System.out.println("O interrogado é inocente!");
		}
		
		entrada.close();
	}

}
