package br.com.livraria.service;

import java.sql.SQLException;

import br.com.livraria.dao.ClienteDao;
import br.com.livraria.domain.Cliente;

public class ClienteService {

	private ClienteDao dao = new ClienteDao();

	public void cadastrarCliente(Cliente cliente) {
		try {
			dao.cadastrarCliente(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletarCliente(Long codigo) {
		try {
			dao.deletarPorCodigo(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterarEmail(String email, Long codigo) {
		try {
			dao.alterarEmail(email, codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void buscarporEmail(String email) {
		try {
			dao.buscarPorEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void buscarPorCodigo(Long codigo) {
		try {
			dao.buscarPorCodio(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void listar() {
		try {
			dao.listarClientes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}