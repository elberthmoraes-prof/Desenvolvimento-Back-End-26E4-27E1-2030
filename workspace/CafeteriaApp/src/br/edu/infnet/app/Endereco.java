package br.edu.infnet.app;

public class Endereco {
	
	private String logradouro;
	private String cidade;
	private String cep;

	public Endereco(String logradouro, String cidade, String cep) {
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.cep = cep;
	}
	
	@Override
	public String toString() {
		return logradouro + " - " + cidade + " - " + cep;
	}
}