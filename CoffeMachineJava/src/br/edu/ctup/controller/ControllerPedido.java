package br.edu.ctup.controller;

import java.util.ArrayList;
import java.util.List;
import br.edu.ctup.model.Cliente;
import br.edu.ctup.model.Pedido;
import br.edu.ctup.model.Produto;

public class ControllerPedido {
	
	public static List<Pedido> listPedidao = new ArrayList<Pedido>();
	static List<Produto> listaPedidos = new ArrayList<>();
	public static List<Produto> sacola;
	Pedido z = new Pedido();
	
	public void menuSacola()
	{
		Produto produto1 = new Produto("Cerveja", 5.00);
		Produto produto2 = new Produto("Refrigerante", 6.00);
		Produto produto3 = new Produto("Suco Laranja", 5.50);
		Produto produto4 = new Produto("Café Expresso", 4.00);
		Produto produto5 = new Produto("Água", 2.50);
		Produto produto6 = new Produto("Salmão", 25.00);
		Produto produto7 = new Produto("Ossobuco", 450.00);
		Produto produto8 = new Produto("Salada", 7.50);
		Produto produto9 = new Produto("Batata Frita", 9.00);
		Produto produto10 = new Produto("Prato do dia", 15.00);
		
		listaPedidos.add(produto1);	
		listaPedidos.add(produto2);
		listaPedidos.add(produto3);
		listaPedidos.add(produto4);
		listaPedidos.add(produto5);
		listaPedidos.add(produto6);
		listaPedidos.add(produto7);
		listaPedidos.add(produto8);
		listaPedidos.add(produto9);
		listaPedidos.add(produto10);			
	}
	
	public List<Produto> listarPedidos()
	{ return listaPedidos; }
	
	public List<Pedido> listarPedidao() 
	{ return listPedidao; }
    
	
	public void cadastroSacola(Produto produto)
	{ sacola = new ArrayList<>();
	  sacola.add(produto); }
	
	public void finalizarPedido(Cliente c)
	{ Pedido produto = new Pedido();
	  produto.setC(c);
	  produto.setListaFinal(sacola); }
	
	public void cadastrarPedidao(Pedido pedido) 
	{ listPedidao.add(pedido); }
}
