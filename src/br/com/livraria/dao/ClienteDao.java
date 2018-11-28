package br.com.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.livraria.domain.Cliente;
import br.com.livraria.domain.Endereco;
import br.com.livraria.util.SingleConnection;

public class ClienteDao {

	private Connection conn = SingleConnection.getConection();

	public boolean cadastrarCliente(Cliente cliente) throws SQLException {
		String sql = "insert into cliente (nome,email,data_nascimento,cep,rua,numero,cidade,estado)values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, cliente.getNome());
		pst.setString(2, cliente.getEmail());
		pst.setDate(3, new Date(cliente.getDataNascimento().getTimeInMillis()));
		pst.setString(4, cliente.getEndereco().getCep());
		pst.setString(5, cliente.getEndereco().getRua());
		pst.setString(6, cliente.getEndereco().getNumero());
		pst.setString(7, cliente.getEndereco().getCidade());
		pst.setString(8, cliente.getEndereco().getEstado());
		return pst.executeUpdate() > 0;

	}

	public List<Cliente> listarClientes() throws SQLException {
		String sql = "select*from cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Cliente c = createCliente(rs);
			clientes.add(c);
		}
		return clientes;
	}

	public Cliente buscarPorCodio(Long codigo) throws SQLException {
		String sql = "SELECT * FROM cliente WHERE id = " + codigo;
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Cliente cliente = createCliente(rs);
			return cliente;
		}
		return null;

	}

	public Cliente buscarPorEmail(String email) throws SQLException {
		String sql = "SELECT * FROM cliente WHERE email like ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, "%" + email + "%");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Cliente cliente = createCliente(rs);
			return cliente;
		}
		return null;
	}

	public Cliente createCliente(ResultSet rs) throws SQLException {
		Cliente c = new Cliente();
		Endereco endereco = new Endereco();
		c.setNome(rs.getString("nome"));
		c.setEmail(rs.getString("email"));
		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("data_nascimento"));
		c.setDataNascimento(data);
		endereco.setCep(rs.getString("cep"));
		endereco.setRua(rs.getString("rua"));
		endereco.setNumero(rs.getString("numero"));
		endereco.setCidade(rs.getString("cidade"));
		endereco.setEstado(rs.getString("estado"));
		return c;
	}

	public boolean deletarPorCodigo(Long codigo) throws SQLException {
		String sql = "delete from cliente where id = " + codigo;
		PreparedStatement pst = conn.prepareStatement(sql);
		return pst.execute();
	}

	public boolean alterarEmail(String email, Long codigo) throws SQLException {
		String sql = "update cliente set email = '" + email + "' where id = " + codigo;
		PreparedStatement pst = conn.prepareStatement(sql);
		return pst.executeUpdate() > 0;

	}

}
