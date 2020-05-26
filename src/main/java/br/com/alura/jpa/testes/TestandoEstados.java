package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	public static void main(String[] args) {

		// Transient
		Conta conta = new Conta();

		conta.setTitular("Almiro");
		conta.setAgencia(123123);
		conta.setNumero(12387128);
		conta.setSaldo(new BigDecimal(34.90));
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		// Transient -> Managed
		em.persist(conta);

		// Managed -> Removed
		// deletando conta
		em.remove(conta);

		em.getTransaction().commit();
		em.close();

		emf.close();

	}

}
