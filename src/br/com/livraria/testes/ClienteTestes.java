package br.com.livraria.testes;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.livraria.dao.ClienteDao;
import br.com.livraria.domain.Cliente;
import br.com.livraria.domain.Endereco;

public class ClienteTestes {

	private Cliente clienteNovo;
	private Endereco endereco;
	private ClienteDao clienteDao = new ClienteDao();

	public Cliente criarCliente() {
		Cliente cliente = new Cliente();
		endereco = new Endereco();
		endereco.setCep("79063179");
		endereco.setNumero("142");
		endereco.setRua("Maringa");
		endereco.setCidade("CG");
		endereco.setEstado("MS");

		cliente.setNome("Bonoro");
		cliente.setEmail("bonoro@gmail.com");
		Calendar data = Calendar.getInstance();
		data.set(1998, 02, 21);
		cliente.setDataNascimento(data);
		cliente.setEndereco(endereco);

		return cliente;
	}

	@Test
	@Ignore
	public void deveSalvar() {
		clienteNovo = criarCliente();
		try {
			clienteDao.cadastrarCliente(clienteNovo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void buscarPorEmail() {
		String email = "toonto";
		// System.out.println(clienteDao.buscarPorEmail("bonoro"));
		try {
			assertTrue(clienteDao.buscarPorEmail(email) != null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void deveDeletetar() {
		try {
			assertTrue(clienteDao.deletarPorCodigo(4L)==true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void deveAlterarEmail() throws SQLException {
		clienteDao.alterarEmail("novo@email", 5L);
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		Long codigo = 1L;
		try {
			Assert.assertTrue(clienteDao.buscarPorCodio(codigo)!=null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void deveListarClientes() {
		try {
			for (Cliente c : clienteDao.listarClientes()) {
				System.out.println("\n" + c.toString() + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
