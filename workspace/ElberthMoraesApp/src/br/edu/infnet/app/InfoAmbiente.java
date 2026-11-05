package br.edu.infnet.app;

public class InfoAmbiente {

	public static void main(String[] args) {
		
		System.out.println("Elberth L C Moraes");
		
		//System.getProperties().list(System.out);
		
		String versaoJava = System.getProperty("java.specification.version");
		String vendorJava = System.getProperty("java.vendor");
		
		System.out.println("Propridade (java.specification.version): " + versaoJava);
		System.out.println("Propridade (java.vendor): " + vendorJava);
	}
}