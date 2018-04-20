package br.com.pgam.test;

import br.com.pgam.connection.ConnectionFactory;

public class ConectionTest {

	public void connect() {
		
		try {
			new ConnectionFactory().getConnection();
			System.out.println("Conectado com sucesso.");
		} catch (Exception e) {
			System.out.println("Erro na conex�o.");
		}
		
	}
	
	public static void main(String[] args) {

		ConectionTest test = new ConectionTest();
		test.connect();

	}

}
