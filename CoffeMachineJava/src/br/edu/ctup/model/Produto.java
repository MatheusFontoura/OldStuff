package br.edu.ctup.model;

public class Produto {
	
	public String descricao;
	public double valor;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Produto (String descricao, double valor)
	{
		this.descricao = descricao;
		this.valor = valor;
	}
}
