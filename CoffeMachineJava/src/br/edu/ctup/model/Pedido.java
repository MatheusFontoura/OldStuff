package br.edu.ctup.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private Cliente c = new Cliente();
	private List<Produto> listaFinal = new ArrayList<>();
	private double valorTotal;
	private int numeroPedido;
	private String nomeCliente;
	private String descricaoProduto;
	
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public Cliente getC() {
		return c;
	}
	public void setC(Cliente c) {
		this.c = c;
	}
	public List<Produto> getListaFinal() {
		return listaFinal;
	}
	public void setListaFinal(List<Produto> listaFinal) {
		this.listaFinal = listaFinal;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
}