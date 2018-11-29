package br.com.livraria.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.domain.Cliente;
import br.com.livraria.domain.Endereco;
import br.com.livraria.service.ClienteService;

@WebServlet("/cadastrarCliente")
public class ClienteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ClienteService service = new ClienteService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String  dataEmTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		String cep = req.getParameter("cep");
		String rua  = req.getParameter("rua");
		String numero = req.getParameter("numero");
		// TODO String bairro = req.getParameter("bairro");
		String cidade = req.getParameter("cidade");
		String estado = req.getParameter("uf");
		
		try { 
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			System.out.println(date);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
			writer.println("<html> <h1 style='color:red'>Erro na conversao da data </html>");
			return;
		}
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setDataNascimento(dataNascimento);
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		endereco.setRua(rua);
		endereco.setNumero(numero);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		cliente.setEndereco(endereco);
		
		service.cadastrarCliente(cliente);
		
		StringBuilder builder = new StringBuilder();
		builder.append("<hmtl>");
		builder.append("<h1 style='color:blue'>");
		builder.append("Cliente cadastrado "+cliente.getId());
		builder.append("</h1>");
		builder.append("</hmtl>");
	}
}
