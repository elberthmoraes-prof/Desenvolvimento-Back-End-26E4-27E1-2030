package br.edu.infnet.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
	private String codigo;
	private String cliente;
	private int quantidade;
	private double valor;
	private LocalDateTime dataCriacao;
	private Prioridade prioridade;
	private Endereco endereco;
	
	private static int totalPedidos;
	
	public Pedido() {
		cliente = "Cliente não informado";
		quantidade = 1;
		dataCriacao = LocalDateTime.now();
		prioridade = Prioridade.PADRAO;
		totalPedidos++;
	}
	
	public Pedido(String codigo) {
		this();
		this.codigo = codigo;		
	}
	
	public Pedido(String codigo, String cliente, int quantidade) {
		this(codigo);
		this.cliente = cliente;
		this.quantidade = quantidade;
	}
	
	public Pedido(String codigo, String cliente, int quantidade, double valor) {
		this(codigo, cliente, quantidade);
		this.valor = valor;
	}
	
	public void impressao() {
		System.out.printf(
			"%-10s %-19s %-9s %-23s %5d   R$ %7.2f   %s%n",
			prioridade,
			getDataCriacao(),
			codigo,
			cliente,
			quantidade,
			valor,
			endereco
		);
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setValor(double valor) {
		
		if(valor <= 0) {
			totalPedidos--;
			throw new IllegalArgumentException("O valor do pedido deve ser maior que zero.");
		}
		
		this.valor = valor;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDataCriacao() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		return dataCriacao.format(formatter);
	}
	
	public static int getTotalPedidos() {
		return totalPedidos;
	}
}