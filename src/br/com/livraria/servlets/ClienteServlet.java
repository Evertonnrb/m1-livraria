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
import br.com.livraria.service.ClienteService;

@WebServlet("/cadastrarCliente")
public class ClienteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ClienteService service = new ClienteService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		//String  dataNascimento = req.getParameter("dataNascimento");
		Calendar dataNasc = null;
		/*try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
			dataNasc = Calendar.getInstance();
			dataNasc.setTime(data);
		}catch (java.text.ParseException e) {
			out.print("Erro na coversao da data "+e);
			e.printStackTrace();
		}*/
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		//cliente.setDataNascimento(dataNasc);
		service.cadastrarCliente(cliente);
		resp.setContentType("text/html");
		
		StringBuilder html = new StringBuilder();
		html.append("<body> <h1 style='color:blue'>");
		html.append("Cliente cadastrado com sucesso!");
		html.append("<a href='cadastrar-cliente.html'>voltar a pagina de cadastro</a>");
		html.append("</h1> <body>");
		out.println(html.toString());
	}
}
