package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();

		conta.setTitular("Márcia");
		conta.setAgencia(5678);
		conta.setNumero(8765);
		conta.setSaldo(new BigDecimal(480.0));

		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		em.close();

		EntityManager em2 = emf.createEntityManager();

		System.out.println("ID da Conta da Márcia " + conta.getId());
		conta.setSaldo(new BigDecimal(500.0));

		em2.getTransaction().begin();

		em2.merge(conta);

		em2.getTransaction().commit();

		em2.close();

		emf.close();
	}

}
