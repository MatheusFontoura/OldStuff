package br.edu.ctup.view;

import java.util.Scanner;
import br.edu.ctup.controller.ControllerCliente;
import br.edu.ctup.controller.ControllerPedido;
import br.edu.ctup.model.Cliente;
import br.edu.ctup.model.Pedido;
import java.text.SimpleDateFormat;


public class Principal {
	
	static ControllerCliente controllerCliente = new ControllerCliente();
	static ControllerPedido controllerPedido = new ControllerPedido();
	static Scanner scanner = new Scanner(System.in);
	public static Cliente cliente;
	public static Pedido pedido;
	public static String nomeCadastro;
	static float pagar = 0;
	static int op2 = 0;
	
	public static void main(String[] args) {
		cadastrarAdmin();
		cadastrarCozinha();
		try {
		int opcao = 0;
		do {
			menuPrincipal();
			opcao = scanner.nextInt();
			
			
			switch (opcao) {
			case 1:
				cadastrarCliente();
				break;
			case 2:
				logar();
				break;
			case 3:
				admin();
				break;
			case 4:
				cozinha();
				break;
			}
		}while(opcao>0 && opcao<4);	
		} catch (Exception e) {
			System.out.println("Digite uma das op��es existentes, por favor.");
			scanner.nextLine();
			menuPrincipal();
		}
	}
	
	public static void menuPrincipal() {
		System.out.println("1 - Novo Cliente.");
		System.out.println("2 - Entrar.");
		System.out.println("3 - Modo Administardor.");
		System.out.println("4 - Modo Cozinha.");
	}
	
public static void cadastrarCliente() {

		System.out.println("Bem vindo ao ambiente de cadastro.\n");
		System.out.println("O primeiro passo é escolher o seu login, ele deve ser único.\n");
		System.out.println("Escolha seu login:");
		String Login = scanner.next();
		boolean autenticarLogin = controllerCliente.autenticarCadastro(Login);
		if (autenticarLogin) {
			cliente = new Cliente();
			cliente.setLogin(Login);
			controllerCliente.cadastrarCliente(cliente);

			System.out.println("Informe seu nome:");
			cliente.setNome(scanner.next());
			System.out.println("Informe seu RG:");
			cliente.setRg(scanner.nextInt());
			System.out.println("Informe seu CPF:");
			cliente.setCpf(scanner.next());
			System.out.println("Informe seu enredeço:");
			cliente.setEndereco(scanner.next());
			System.out.println("Informe seu telefone:");
			cliente.setTelefone(scanner.nextInt());
			
			System.out.println("Escolha sua senha:");
			cliente.setSenha(scanner.next());

		}else  {
			System.out.println("O login escolhido já existe, por favor, escolha outro.\n");
			cadastrarCliente();
		}

	}
	
	public static void menuCliente(int indice) {
		cliente = new Cliente();
		System.out.println("1 - Cardápio.");
		System.out.println("2 - Alterar dados cadastrados.");
		System.out.println("3 - Sair.");
		int op = scanner.nextInt();
		if (op==1) {
			menuCardapio();
		}
		
		if (op==2) {
			System.out.println("Caso deseje manter os dados, apenas informe os já existentes.\n");
			System.out.println("Infome o novo nome:");
			cliente.setNome(scanner.next());
			System.out.println("Informe o novo endereço:");
			cliente.setEndereco(scanner.next());
			System.out.println("Informe o novo telefone:");
			cliente.setTelefone(scanner.nextInt());
			System.out.println("Informe a nova senha:");
			cliente.setSenha(scanner.next());
			
			System.out.println("Seus dados foram alterados com sucesso.\n");
				
		controllerCliente.alterarDadosCliente(indice, cliente);
		}
	}

	public static void menuSacolao() {
		System.out.println("\nEscolha como deseja finalizar sua compra.");
		System.out.println("1 - Dinheiro.");
		System.out.println("2 - Cartão Débito ou Crédito.");
		
		int op1 = scanner.nextInt();
		
		if (op1 == 1) {
			System.out.println("O valor total da sua compra é R$:" + pagar);
			System.out.println("Escolha o valor que deseja pagar em R$:");
			float pagamento = scanner.nextFloat();
			if (pagamento < pagar) {
			System.out.println("\nValor insuficiente, tente outra forma de pagamento.");
			menuSacolao();
			}
			if (pagamento == pagar) {
				System.out.println("\nCompra finalizada, volte sempre.\n");
				pagar = 0;
			}
			if (pagamento > pagar) {
			pagar = pagamento - pagar;
			System.out.println("\nSeu troco é de: R$" + pagar + "\nObrigado pela preferência, volte sempre.\n");
				pagar = 0;
			}
		}
		if (op1 == 2) {
			System.out.println("\nInforme o número do cartão: ");
			long nCartao = scanner.nextLong();
			System.out.println("Informe a senha do cartão: ");
			int sCartao = scanner.nextInt();
			System.out.println("Pagamento efetuado com sucesso.\n");
			}
		}
			
	public static void logar() {
		System.out.println("Informe seu login:");
		String login = scanner.next();
		System.out.println("Informe sua senha:");
		String senha = scanner.next();
			
		int indice = controllerCliente.autenticarCliente(login, senha);
		if(indice>-1) {
			System.out.println("Entrou com sucesso.\n");
			nomeCadastro = cliente.getNome();
			menuCliente(indice); 	
		}else {
			System.out.println("Credenciais incorretas, tente novamente.\n");		
		}
	}

	public static void menuAdm(int indice) {
		System.out.println("=======================================");
		System.out.println("| Modo excluiso para administradores. |");
		System.out.println("=======================================");
		System.out.println("1 - Lista de clientes.");
		System.out.println("2 - Visualizar os pedidos.");
		System.out.println("3 - Sair.");	
		
		int opadm = scanner.nextInt();
		
		if (opadm == 1)
			imprimeListaCliente();
						
		if (opadm == 2) {
			System.out.println("Lista de todos os pedidos: ");
			 imprimeListaPedidos(); }
	}
	
	public static void cadastrarAdmin() {
        cliente = new Cliente();
        cliente.setLogin("admin");
        cliente.setSenha("admin");

        controllerCliente.cadastrarCliente(cliente);
    }
	
	public static void cadastrarCozinha() {
		cliente = new Cliente();
		cliente.setLogin("coz");
		cliente.setSenha("coz");
		
		controllerCliente.cadastrarCliente(cliente);
	}
	
    public static void admin() {
        System.out.println("Informe seu login:");
        String Login = scanner.next();
        System.out.println("Informe sua senha:");
        String Senha = scanner.next();

        int indice = controllerCliente.autenticarCliente(Login, Senha);
        if(indice>-1) {
            System.out.println("Entrou com sucesso.\n");
            menuAdm(indice); 
        }else {
            System.out.println("Credenciais incorretas, tente novamente.\n");
        }   
    }
    
    public static void cozinha() {
        System.out.println("Informe seu login:");
        String Login = scanner.next();
        System.out.println("Informe sua senha:");
        String Senha = scanner.next();
        
        int indice = controllerCliente.autenticarCliente(Login, Senha);
        if(indice>-1) {
        	System.out.println("Entrou com sucesso.\n");
        	menuCozinha(indice);
        	
        }else {
        	System.out.println("Credenciais incorretas, tente novamente \n");
        	cozinha();
        }
    }
    
    public static void menuCozinha(int indice) {
    System.out.println("=======================================");
	System.out.println("|    Modo excluiso para a cozinha.    |");
	System.out.println("=======================================");
	System.out.println("1 - Lista de pedidos pagos.");
	System.out.println("2 - Sair.");

	
	int opCoz = scanner.nextInt();
	
	if (opCoz == 1); {
	System.out.println("Pedidos em aberto: ");
		imprimeListaCozinha();
	}
	if (opCoz == 2);{
		menuPrincipal();
		}
    }
    
    public static void imprimeListaCozinha() {
    	for(Pedido pedido : ControllerPedido.listPedidao) {
    		System.out.println("\nCliente: " + pedido.getNomeCliente() + "\nProduto: " + pedido.getDescricaoProduto() + "\n");
    	}
    }
    
    public static void imprimeListaPedidos() {
        for (Pedido pedido : ControllerPedido.listPedidao) {
            System.out.println("\nCliente: " + pedido.getNomeCliente() +  "\nCódigo do produto: " + pedido.getNumeroPedido() + "\nValor do Produto: " + pedido.getValorTotal() + "\n" );
        }
    }
    
    public static void imprimeListaCliente() {
    	for (Cliente cliente : ControllerCliente.listCliente) {
    		System.out.println("Cliente:\n ");
    		System.out.println("Nome: " + cliente.getNome()+ "\nLogin: " + cliente.getLogin() + "\nEndereço: " + cliente.getEndereco() + "\nTelefone: " + cliente.getTelefone() + "\nRg: " + cliente.getRg() + "\nCpf: " + cliente.getCpf() + "\n");
    	}	
    }
    
    public static void menuCardapio() {
		try {
			int op2 = 0;
			do {
				
				System.out.println("============== CARDÁPIO ================");
				System.out.println("===== PRATOS ===========================");
				System.out.println("[1]  - Batata Frita - R$9,00.          |");
				System.out.println("[2]  - Ossobuco     - R$450,00.        |");
				System.out.println("[3]  - Prato do dia - R$15,00.         |");
				System.out.println("[4]  - Salada       - R$7,50.          |");
				System.out.println("[5]  - Salmão       - R$25,00.         |");
				System.out.println("===== BEBIDAS ==========================");
				System.out.println("[6]  - Água         - R$2,50.          |");
				System.out.println("[7]  - Café Gelado  - R$4,00.          |");
				System.out.println("[8]  - Cerveja      - R$5,00.          |");
				System.out.println("[9]  - Refrigerante - R$6,00.          |");
				System.out.println("[10] - Suco         - R$5,00.          |");
				System.out.println("========================================");
				System.out.println("[11] - Finalizar Pedido.               |");
				System.out.println("========================================");

				op2 = scanner.nextInt();

				switch (op2) {
				case 1:
					pagar = (float) (pagar + 9.00);
	                    pedido = new Pedido();
	                    pedido.setNumeroPedido(op2);
	                    pedido.setValorTotal(9);
	                    pedido.setNomeCliente(nomeCadastro);
	                    pedido.setDescricaoProduto("Batata Frita");
	                    controllerPedido.cadastrarPedidao(pedido);       
					break;
				case 2:
					pagar = (float) (pagar + 450.00);
						pedido = new Pedido();
						pedido.setNumeroPedido(op2);
						pedido.setValorTotal(450);
						pedido.setNomeCliente(nomeCadastro);
						pedido.setDescricaoProduto("Ossobuco");
						controllerPedido.cadastrarPedidao(pedido);
					break;
				case 3:
					pagar = (float) (pagar + 15.00);
					pedido = new Pedido();
					pedido.setNumeroPedido(op2);
					pedido.setValorTotal(15);
					pedido.setNomeCliente(nomeCadastro);
					pedido.setDescricaoProduto("Prato do Dia");
					controllerPedido.cadastrarPedidao(pedido);
					break;
				case 4:
					pagar = (float) (pagar + 7.50);
					pedido = new Pedido();
					pedido.setNumeroPedido(op2);
					pedido.setValorTotal(7.5);
					pedido.setNomeCliente(nomeCadastro);
					pedido.setDescricaoProduto("Salada");
					controllerPedido.cadastrarPedidao(pedido);
					break;
				case 5:
					pagar = (float) (pagar + 25.00);
					pedido = new Pedido();
					pedido.setNumeroPedido(op2);
					pedido.setValorTotal(25);
					pedido.setNomeCliente(nomeCadastro);
					pedido.setDescricaoProduto("Salmão");
					controllerPedido.cadastrarPedidao(pedido);
					break;
				case 6:
					pagar = (float) (pagar + 2.50);
					pedido = new Pedido();
					pedido.setNumeroPedido(op2);
					pedido.setValorTotal(2.5);
					pedido.setNomeCliente(nomeCadastro);
					pedido.setDescricaoProduto("Água");
					controllerPedido.cadastrarPedidao(pedido);
					break;
				case 7:
					pagar = (float) (pagar + 4.00);
					pedido = new Pedido();
					pedido.setNumeroPedido(op2);
					pedido.setValorTotal(4);
					pedido.setNomeCliente(nomeCadastro);
					pedido.setDescricaoProduto("Café Gelado");
					controllerPedido.cadastrarPedidao(pedido);
					break;
				case 8:
					pagar = (float) (pagar + 5.00);
					pedido = new Pedido();
					pedido.setNumeroPedido(op2);
					pedido.setValorTotal(5);
					pedido.setNomeCliente(nomeCadastro);
					pedido.setDescricaoProduto("Cerveja");
					controllerPedido.cadastrarPedidao(pedido);
					break;
				case 9:
					pagar = (float) (pagar + 6.00);
					pedido = new Pedido();
					pedido.setNumeroPedido(op2);
					pedido.setValorTotal(6);
					pedido.setNomeCliente(nomeCadastro);
					pedido.setDescricaoProduto("Refrigerante");
					controllerPedido.cadastrarPedidao(pedido);
					break;
				case 10:
					pagar = (float) (pagar + 5.50);
					pedido = new Pedido();
					pedido.setNumeroPedido(op2);
					pedido.setValorTotal(5.5);
					pedido.setNomeCliente(nomeCadastro);
					pedido.setDescricaoProduto("Suco");
					controllerPedido.cadastrarPedidao(pedido);
					break;
				case 11:
					if (pagar == 0) {
						menuPrincipal();
					} else {
						System.out.println("\nSua compra foi finalizada, estas são as informações: ");
						String data = "dd/MM/yyyy";
						String hora = "h:mm - a";
						String data1, hora1;
						java.util.Date agora = new java.util.Date();;
						SimpleDateFormat formata = new SimpleDateFormat(data);
						data1 = formata.format(agora);
						formata = new SimpleDateFormat(hora);
						hora1 = formata.format(agora);
						System.out.print("\nData: " + data1 + "\nHorário: " + hora1);
						System.out.println("\nValor Total: " + "R$" + pagar);	
						for(Pedido pedido : ControllerPedido.listPedidao) {				    		
				    		String totalPedido = pedido.getDescricaoProduto();
				    		System.out.println(totalPedido);
				    		pedido.setDescricaoProduto("");
				    	}
						menuSacolao();				
					}

					break;
				case 12:
					menuPrincipal();
					break;
				default:
					break;
				}
			} while (op2 > 0 && op2 <= 10);
		} catch (Exception e) {
			System.out.println("\r\nComando inválido, tente novamente.\r\n");
			scanner.nextLine();
			menuPrincipal();
		}
	}    
}
