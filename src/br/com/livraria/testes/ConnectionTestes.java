package br.com.livraria.testes;

import org.junit.Assert;
import org.junit.Test;

import br.com.livraria.util.SingleConnection;

public class ConnectionTestes {

	@Test
	public void deveConectar() {
		Assert.assertTrue(SingleConnection.getConection()!=null);
	}
}
