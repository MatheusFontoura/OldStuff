package br.edu.ctup.view;

import java.util.Scanner;

import br.edu.ctup.controller.ControllerCliente;
import br.edu.ctup.controller.ControllerGame;
import br.edu.ctup.model.Cliente;
import br.edu.ctup.model.Game;

public class Principal {
	
	//declarar controller
		static ControllerCliente controllerCliente = new ControllerCliente();
		static ControllerGame controllerGame = new ControllerGame();
		static Cliente cliente;
		static Game game;
		static Scanner sc = new Scanner(System.in);
		
		public static void main(String[] args) {
			int opcao = 0;
			do {
				menu();
				opcao = sc.nextInt();
				
				switch (opcao) {
				case 1:
					cadastrarCliente();
					break;
				case 2:
					cadastrarGame();
					break;					
				case 3:
					logar();
					break;
				case 4:
					printCliente();
					break;
				case 5:
					printGame();
					break;							

				default:
					break;
				}
				
			}while(opcao>0 && opcao<5);
			
		}
		
		public static void menu() {
			System.out.println("1 - Cadastrar Jogador");
			System.out.println("2 - Cadastrar Game");
			System.out.println("3 - Logar");
			System.out.println("4 - Mostrar todos os jogadores");
			System.out.println("5 - Mostrar todos os games");
			System.out.println("6 - Sair");
		}
		
		public static void cadastrarCliente() {
			cliente = new Cliente();
			System.out.println("Digite nome");
			cliente.setNome(sc.next());
			System.out.println("Digite seu rg");
			cliente.setRg(sc.nextInt());
			System.out.println("Informe seu cpf");
			cliente.setCpf(sc.nextLong());
			System.out.println("Digite login");
			cliente.setLogin(sc.next());
			System.out.println("Digite senha");
			cliente.setSenha(sc.next());
			System.out.println("Cadastro realizado com sucesso");
			
			controllerCliente.cadastrarCliente(cliente);
			
		}
		
		public static void cadastrarGame() {
			game  = new Game();
			System.out.println("Digite o nome do jogo");
			game.setNomeGame(sc.next());
			System.out.println("Informe o preço");
			game.setPrecoProduto(sc.nextDouble());
			System.out.println("Informe a quantidade em estoque");
			game.setQuantidade(sc.nextInt());		
			
			controllerGame.cadastrarGame(game);
			
		}
				
		
		static public void printCliente() {
			for (Cliente cli : ControllerCliente.listarClientes()) {
				System.out.println(cli.getNome());
				System.out.println(cli.getLogin());
			}
		}
		
		static public void printGame() {
			for (Game cli: ControllerGame.listarGame()) {
				System.out.println(cli.getNomeGame());
				System.out.println(cli.getPrecoProduto());
				System.out.println(cli.getQuantidade());
			}
		}
		
		public static void logar() {
			System.out.println("Digite login");
			String login = sc.next();
			System.out.println("Digite senha");
			String senha = sc.next();
			
			int indice = controllerCliente.autenticarCliente(login, senha);
			if(indice>-1) {
				System.out.println("Você está logado!");
				menuCliente(indice);
			}else {
				System.out.println("Invalido, tente novamente!");
			}

	
		}
		
}
