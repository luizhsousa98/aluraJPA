package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();

		conta.setTitular("Luiz Henrique");
		conta.setNumero(1234);
		conta.setAgencia(4321);

		// Abrindo transação
		em.getTransaction().begin();
		
		// criando conta no banco
		em.persist(conta);
		
		// Qualquer comando ele inicia e finaliza a transação com o banco
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
