package br.edu.infnet.testes;

import br.edu.infnet.app.DespachoPedido;
import br.edu.infnet.app.Endereco;
import br.edu.infnet.app.Pedido;
import br.edu.infnet.app.Prioridade;

public class PedidoTeste {

	public static void main(String[] args) {
		
		System.out.println("PRIORIDADE  DATA/HORA            CÓDIGO    CLIENTE                 QTD   VALOR      ENDEREÇO");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		
		DespachoPedido[] despachos = new DespachoPedido[4];

		Endereco endKelvin = new Endereco("Rua do Kelvin, 99", "Cidade do Kelvin", "12345-678");

		Pedido pKelvin = new Pedido("KLV1234");
		pKelvin.setPrioridade(Prioridade.URGENTE);
		pKelvin.setEndereco(endKelvin);
		pKelvin.impressao();
		despachos[0] = new DespachoPedido(pKelvin.getCodigo(), pKelvin.getDataCriacao());

		Endereco endElberth = new Endereco("Rua do Elberth, 99", "Cidade do Elberth", "12345-678");

		Pedido pElberth = new Pedido();
		pElberth.setCodigo("ABC1234");
		pElberth.setCliente("Elberth");
		pElberth.setQuantidade(3);
		pElberth.setValor(25.99);	
		pElberth.setEndereco(endElberth);
		pElberth.setPrioridade(Prioridade.URGENTE);
		pElberth.impressao();
		despachos[1] = new DespachoPedido(pElberth.getCodigo(), pElberth.getDataCriacao());

		try {
			Pedido pLucas = new Pedido("FLA1981", "Lucas Maciel", 6);
			pLucas.setValor(0);	
			pLucas.impressao();
		} catch (IllegalArgumentException e) {
			System.err.println("[error] " + e.getMessage());
		}
		
		Endereco endAnderson = new Endereco("Rua do Anderson, 99", "Cidade do Anderson", "12345-678");
		
		Pedido pAnderson = new Pedido("ZAP1010", "Anderson", 12, 12.13);
		pAnderson.setPrioridade(Prioridade.LEVE);
		pAnderson.setEndereco(endAnderson);
		pAnderson.impressao();
		despachos[2] = new DespachoPedido(pAnderson.getCodigo(), pAnderson.getDataCriacao());
		
		Endereco endereco = new Endereco("Rua do Pedido, 99", "Cidade do Pedido", "12345-678");

		Pedido pedido = new Pedido("ELI9876", "Elis", 12, 10);
		pedido.setEndereco(endereco);
		System.out.println("O pedido " + pedido.getCodigo() + " foi realizado em " + pedido.getDataCriacao() + ".");
		despachos[3] = new DespachoPedido(pedido.getCodigo(), pedido.getDataCriacao());

		System.out.println("=== RELATÓRIO DE DESPACHOS DE PEDIDO ===");
		for(DespachoPedido despacho : despachos) {
			System.out.printf(
					"%-9s %s%n",
					despacho.codigo(),
					despacho.dataCriacao()
				);
		}
		System.out.println("=== TOTAL DE PEDIDOS: " + Pedido.getTotalPedidos());
	}
}