package br.edu.ctup.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ctup.model.Cliente;

public class ControllerCliente {
	static List<Cliente> listCliente = new ArrayList<Cliente>();


	public void cadastrarCliente (Cliente cliente) {
		listCliente.add(cliente);
}
	public static List<Cliente> listarClientes(){
		return listCliente;

	}

public int autenticarCliente(String login, String senha) {

		int indice = -1;
		for(int i = 0; i < listCliente.size(); i++) {
			//listCliente.get(i).getLogin() = acesse a posicao i lista e o conteudo do atributo
			if(listCliente.get(i).getLogin().equals(login) && 
					listCliente.get(i).getSenha().equals(senha)) {
				indice = i;
				break;
			}
		}
		//listCliente.get(2).setNome(nome);
		return indice;
	}


}
