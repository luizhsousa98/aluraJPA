package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabelas {

	public static void main(String[] args) {

		// Cria uma entitidade tabela
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");

		// criando entidades codigo sql
		EntityManager createEntityManager = emf.createEntityManager();
		
		createEntityManager.close();
		emf.close();

	}

}
