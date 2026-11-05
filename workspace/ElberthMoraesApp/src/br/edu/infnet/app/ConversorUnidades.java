package br.edu.infnet.app;

public class ConversorUnidades {

	public static void main(String[] args) {
		System.out.println("Conversão");
		
		int valorReferencia = 2690;
		
		int dia = 1; // horas = 2 * 24
		int hora = 20; // minutos= 20 * 60
		int minuto = 50;
		
		int resultado = dia * 24 * 60 + hora * 60 + minuto;
		
		System.out.println("Tempo em minutos: " + resultado);
		
		if(resultado > valorReferencia) {
			System.out.println("MAIOR");
		} else if (resultado < valorReferencia) {
			System.out.println("MENOR");
		} else {
			System.out.println("IGUAL");
		}
	}

}