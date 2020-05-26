package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaLuiz {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		//Fazendo select na classe conta buscando pelo id
		Conta contaDoLuiz = em.find(Conta.class, 1L);
		
		em.getTransaction().begin();
		
		//alterando saldo da conta de nulo para 1
		contaDoLuiz.setSaldo(new BigDecimal(100.0));
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}
