package br.edu.infnet.app;

import java.util.Scanner;

public class Cafeteria {

	private static int totalCafes = 0;
	private static int totalCappuccinos = 0;
	private static int totalPaesQueijo = 0;
	private static int totalSanduiches = 0;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int opcao;

		/*
		 * RF11 / RF13
		 * Informações gerais controladas pelo main.
		 */
		int totalPedidos = 0;
		double totalVenda = 0;

		/*
		 * RF02
		 * O menu será executado pelo menos uma vez e continuará sendo exibido até a opção 0.
		 */
		do {

			/*
			 * RF17
			 * Método responsável apenas pela exibição do menu.
			 */
			exibirMenu();

			/*
			 * RF19
			 * Método responsável apenas por obter a opção.
			 */
			opcao = obterOpcao(in);

			/*
			 * RF25
			 * O switch passa a mostrar apenas as operações principais da aplicação.
			 */
			switch (opcao) {

			case 1:

				/*
				 * RF24
				 * Todo o fluxo de registro do pedido foi transferido para um método específico.
				 */
				double totalPedido = registrarPedido(in);

				/*
				 * RF11
				 * Contabiliza o pedido concluído.
				 */
				totalPedidos++;

				/*
				 * RF13
				 * Acumula o valor do pedido no total geral.
				 */
				totalVenda = totalVenda + totalPedido;

				break;

			case 2:

				exibirCardapio();

				break;

			case 3:

				exibirResumo(totalPedidos, totalCafes, totalCappuccinos, totalPaesQueijo, totalSanduiches, totalVenda);

				break;

			case 4:

				exibirSobre();

				break;
				
			case 5:

				analisarPedidoTexto(in);
				
				break;

			case 0:

				System.out.println("Encerrando a Cafeteria Java...");

				break;

			default:

				System.out.println("Opção inválida.");

				break;
			}

		/*
		 * RF26
		 * O main permanece como coordenador do fluxo geral.
		 */
		} while (opcao != 0);

		in.close();
	}

	/*
	 * RF17
	 * Responsabilidade: apresentar o menu principal.
	 */
	public static void exibirMenu() {

		System.out.println();
		System.out.println("===== CAFETERIA JAVA =====");
		System.out.println();
		System.out.println("1 - Novo pedido");
		System.out.println("2 - Exibir cardapio");
		System.out.println("3 - Exibir resumo de vendas");
		System.out.println("4 - Sobre o sistema");
		System.out.println("5 - Analisar pedido em texto");
		System.out.println("0 - Sair");
		System.out.println();
	}

	/*
	 * RF19
	 * Responsabilidade: obter a opção escolhida pelo usuário.
	 */
	public static int obterOpcao(Scanner tela) {

		System.out.print("Escolha uma opção: ");

		int minhaOpcao = tela.nextInt();

		System.out.println();

		return minhaOpcao;
	}

	/*
	 * RF24
	 * Responsabilidade: coordenar todo o processo relacionado ao registro de um novo pedido.
	 */
	public static double registrarPedido(Scanner tela) {

		System.out.println("===== NOVO PEDIDO =====");

		String nome = obterNome(tela);

		System.out.println();

		exibirCardapio();

		System.out.println("0 - Finalizar o pedido");

		double totalPedido = 0;

		int codigo = obterProduto(tela);

		/*
		 * RF06
		 * O código 0 funciona como sentinela.
		 */
		while (codigo != 0) {

			String produto = null;
			double preco = 0;
			boolean produtoValido = true;

			/*
			 * RF07
			 * Identificação do produto.
			 */
			switch (codigo) {

			case 1:

				produto = "Cafe";
				preco = 5;

				break;

			case 2:

				produto = "Cappuccino";
				preco = 8;

				break;

			case 3:

				produto = "Pao de queijo";
				preco = 6;

				break;

			case 4:

				produto = "Sanduiche";
				preco = 12;

				break;

			default:

				produtoValido = false;

				System.out.println("Produto inválido.");

				break;
			}


			if (produtoValido) {

				/*
				 * RF23 / RF08
				 * Obtém uma quantidade válida.
				 */
				int quantidade = obterQuantidade(tela);

				/*
				 * RF22 / RF09
				 * Calcula o subtotal.
				 */
				double subTotal = calcularSubTotal(quantidade, preco);

				totalPedido = totalPedido + subTotal;

				/*
				 * RF10
				 * Atualização dos contadores dos produtos vendidos.
				 */
				switch (codigo) {

				case 1:

					totalCafes = totalCafes + quantidade;

					break;

				case 2:

					totalCappuccinos = totalCappuccinos + quantidade;

					break;

				case 3:

					totalPaesQueijo = totalPaesQueijo + quantidade;

					break;

				case 4:

					totalSanduiches =totalSanduiches + quantidade;

					break;
				}

				exibirItem(produto, preco, quantidade, subTotal);
			}

			codigo = obterProduto(tela);
		}


		/*
		 * RF12
		 * Apresenta o fechamento do pedido.
		 */
		exibirPedidoFinalizado(nome, totalPedido);

		return totalPedido;
	}

	/*
	 * RF18
	 * Responsabilidade: apresentar o cardápio.
	 */
	public static void exibirCardapio() {

		System.out.println("===== CARDAPIO =====");

		System.out.println("1 - Cafe ............. R$ 5,00");

		System.out.println("2 - Cappuccino ....... R$ 8,00");

		System.out.println("3 - Pao de queijo .... R$ 6,00");

		System.out.println("4 - Sanduiche ........ R$ 12,00");
	}

	/*
	 * Responsabilidade: obter o nome do cliente.
	 */
	public static String obterNome(Scanner tela) {

		tela.nextLine();

		System.out.print("Nome do cliente: ");

		return tela.nextLine();
	}

	/*
	 * Responsabilidade: obter o código do produto.
	 */
	public static int obterProduto(Scanner tela) {

		System.out.println();

		System.out.print("Informe o código do produto: ");

		return tela.nextInt();
	}

	/*
	 * RF23 / RF08
	 * Responsabilidade: obter uma quantidade válida.
	 */
	public static int obterQuantidade(Scanner tela) {

		System.out.print("Informe a quantidade desejada: ");

		int qtde = tela.nextInt();

		while (qtde <= 0) {

			System.out.println("Quantidade inválida.");

			System.out.print("Informe novamente a quantidade: ");

			qtde = tela.nextInt();
		}

		return qtde;
	}

	/*
	 * RF22 / RF09
	 * Responsabilidade: calcular o subtotal de um item.
	 */
	public static double calcularSubTotal(int quantidade, double preco) {

		return quantidade * preco;
	}

	/*
	 * Responsabilidade: apresentar os dados de um item.
	 */
	public static void exibirItem(String produto, double preco, int quantidade, double subTotal) {

		System.out.println();

		System.out.println("Produto: " + produto);

		System.out.println("Preço: R$ " + preco);

		System.out.println("Quantidade: " + quantidade);

		System.out.println("----");

		System.out.println("Subtotal: R$ " + subTotal);
	}

	/*
	 * RF12
	 * Responsabilidade: apresentar o fechamento do pedido.
	 */
	public static void exibirPedidoFinalizado(String nome, double totalPedido) {

		System.out.println();

		System.out.println("===== PEDIDO FINALIZADO =====");

		System.out.println("Cliente: " + nome);

		System.out.println("Total do Pedido: R$ " + totalPedido);
	}

	/*
	 * RF21 / RF14
	 * Responsabilidade: apresentar o resumo geral das vendas.
	 */
	public static void exibirResumo(int totalPedidos, int totalCafes, int totalCappuccinos, int totalPaesQueijo, int totalSanduiches, double totalVenda) {

		System.out.println("===== RESUMO DE VENDAS =====");

		System.out.println("Pedidos realizados: " + totalPedidos);

		System.out.println("Cafes vendidos: " + totalCafes);

		System.out.println("Cappuccinos vendidos: " + totalCappuccinos);

		System.out.println("Paes de queijo vendidos: " + totalPaesQueijo);

		System.out.println("Sanduiches vendidos: " + totalSanduiches);

		System.out.println("Total arrecadado: R$ " + totalVenda
		);
	}

	/*
	 * RF20 / RF15
	 * Responsabilidade: apresentar informações sobre o ambiente de execução.
	 */
	public static void exibirSobre() {

		System.out.println("===== SOBRE O SISTEMA =====");

		System.out.println("Java: " + System.getProperty("java.version"));

		System.out.println("Sistema operacional: " + System.getProperty("os.name"));

		System.out.println("Diretorio atual: " + System.getProperty("user.dir"));
	}
	
	public static void analisarPedidoTexto(Scanner tela){
		
		System.out.println("==== ANALISAR PEDIDO EM TEXTO ====");
		
		tela.nextLine();
		
		System.out.print("Informe o pedido: ");
		
		String pedido = tela.nextLine();
		
		if(pedido.isBlank()) {
			System.err.println("Pedido não informado.");
			return;
		}
		
		String[] campos = pedido.split(";");

		if(campos.length != 3) {
			System.err.println("Formato de pedido inválido.");
			return;
		}
		
		System.out.println("Código: " + campos[0]);
		
		System.out.println("Quantidade: " + campos[1]);
		
		System.out.println("Nome: " + campos[2]);		
	}
}