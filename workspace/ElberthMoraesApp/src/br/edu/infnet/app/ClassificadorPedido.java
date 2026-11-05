package br.edu.infnet.app;

import java.util.Scanner;

public class ClassificadorPedido {

	public static void main(String[] args) {
		
		//repetição: WHILE, DO..WHILE, FOR, FOR..EACH

		Scanner in = new Scanner(System.in);
				
		int idade = 0;
		while(idade >= 0) {
			System.out.print("Informe a sua idade: ");
			idade = in.nextInt();
			
			if(idade < 0) {
				System.err.println("A idade " + idade + " está inválida! Ela precisa ser positiva!");
				return;
			}
			
			if(idade < 18) {
				System.out.println("Baby");
			} else if(idade < 30) {
				System.out.println("Teen");
			} else {
				System.out.println("Velhote");
			}
		}

		
		
		
	}

}
