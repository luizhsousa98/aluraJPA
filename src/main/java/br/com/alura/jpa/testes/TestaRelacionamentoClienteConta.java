package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {

	public static void main(String[] args) {

		Conta c = new Conta();
		c.setId(1L);

		Cliente cliente = new Cliente();
		cliente.setNome("Luiz");
		cliente.setEndereco("Rua de ouvidor, 50");
		cliente.setProfissao("Analista de Sistemas");
		cliente.setConta(c);

		Cliente cliente2 = new Cliente();
		cliente2.setNome("Nargos");
		cliente2.setEndereco("Rua de ouvidor, 50");
		cliente2.setProfissao("Analista de Sistemas");
		cliente2.setConta(c);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		em.persist(cliente);
		em.persist(cliente2);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
