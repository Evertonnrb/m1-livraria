package br.com.livraria.testes;

import org.junit.Test;

import br.com.livraria.service.ClienteService;

public class ClienteServiceTestes {

	ClienteService service = new ClienteService();
	
	@Test
	public void listar() {
		service.listar();
	}
	
	
}
