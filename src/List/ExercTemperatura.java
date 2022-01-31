package List;

/*Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExercTemperatura {
	public static void main(String[] args) {
		
	Scanner entrada = new Scanner(System.in);
	List<Double> temperaturas = new ArrayList<>();
	
	for(int i = 0; i < 6; i++) {
		System.out.println("Digite a temperatura: ");
		double temp = entrada.nextDouble();
		temperaturas.add(temp);
	}
	
	//Exibir todas temperaturas 
	System.out.println("Todas as temperaturas: ");
	System.out.println(temperaturas);
	
	//Calculo média
	System.out.println("-------------");
	Double media = 0.0;
	Iterator<Double> iterator = temperaturas.iterator();
	while(iterator.hasNext()) {
		Double next = iterator.next();
		media += next;
	}
		media = media / 6;
		
		
		Iterator<Double> iterator1 = temperaturas.iterator();
		int count = 0;
		
		
		//Saída
		while(iterator1.hasNext()) {
			double temp1 = iterator1.next();
			
			if(temp1 > media) {
				switch (count) {
				case (0):
					System.out.println("1 - Janeiro: \n" + temp1 + "°C");
					break;
				case (1):
					System.out.println("2 - Fevereiro: \n" + temp1 + "°C");
					break;
				case (2):
					System.out.println("3 - Março: \n"+ temp1 + "°C");
					break;
				case (3):
					System.out.println("4 - Abril: \n" + temp1 + "°C");
					break;
				case (4):
					System.out.println("5 - Maio: \n"+ temp1 + "°C");
					break;
				case (5):
					System.out.println("6 - Junho: \n" + temp1 + "°C");
					break;
				default:
					System.out.println("Não ouve temperatura acima da média");
					break;
				}
				count ++;
			}
		}
	
	entrada.close();
}
}

	