package br.edu.ctup.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ctup.model.Cliente;
import br.edu.ctup.model.Game;

public class ControllerGame {		

	static List<Game> listGame = new ArrayList<Game>();
	
	public void cadastrarGame(Game game) {
		listGame.add(game);
	}
	public static List<Game> listarGame(){
		return listGame;
					
	}
	}	

	