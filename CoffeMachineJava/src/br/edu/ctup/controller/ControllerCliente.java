package br.edu.ctup.controller;

import java.util.ArrayList;
import java.util.List;
import br.edu.ctup.model.Cliente;

public class ControllerCliente {
	
	public static List<Cliente> listCliente = new ArrayList<Cliente>();
	
	public void cadastrarCliente(Cliente cliente) 
		{ listCliente.add(cliente); }
	
	public List<Cliente> listarCliente() 
		{ return listCliente; }
	
	public Cliente buscarClientes(String cpf) {
		Cliente C = new Cliente();
		for(int i = 0; i <listCliente.size(); i++) {
			if(listCliente.get(i).getCpf().equals(cpf)) {
				C = listCliente.get(i);
				break;
			}
		}
		return C;
	}
	
	public int autenticarCliente(String login, String senha) {		
		int indice = -1;
		for(int i = 0; i <listCliente.size(); i++) {
			if(listCliente.get(i).getLogin().equals(login) &&
					listCliente.get(i).getSenha().equals(senha)) {
				indice = i;
				break;
			}
		}
		return indice;
	}
	
	public boolean autenticarCadastro(String login) {

        boolean autenticarCadastro = true;

        for (int i = 0; i < listCliente.size(); i++) {
            if (listCliente.get(i).getLogin().equals(login)) {
                autenticarCadastro = false;
                break;
            }
        }
        return autenticarCadastro;

    }
	
	public void alterarDadosCliente(int indice, Cliente cliente) {
		listCliente.get(indice).setNome(cliente.getNome());
		listCliente.get(indice).setEndereco(cliente.getEndereco());
		listCliente.get(indice).setTelefone(cliente.getTelefone());
		listCliente.get(indice).setSenha(cliente.getSenha());
	}
}
