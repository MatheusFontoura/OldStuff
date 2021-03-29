package br.edu.ctup.model;

/**
 * @author Matheus Fontoura
 *
 */
public class Game {
	private String nomeGame;
	private double precoProduto;
	private int quantidade;
	
	public String getNomeGame() {
		return nomeGame;
	}
	public void setNomeGame(String nomeGame) {
		this.nomeGame = nomeGame;
	}
	public double getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}