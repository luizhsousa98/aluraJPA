package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {

		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Neg�cios");

		Conta c = new Conta();
		// Conta que se associar� as movimenta��es
		c.setId(2L);

		// Ida a RJ
		Movimentacao m = new Movimentacao();
		m.setDescricao("Viagem � RJ");
		m.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		m.setData(LocalDateTime.now());
		m.setValor(new BigDecimal(300.0));
		// Usando um arrayList est�tico uma forma de adicionar valores
		m.setCategorias(Arrays.asList(categoria, categoria2));
		m.setConta(c);
		
		// Volta ao SP
		Movimentacao m2 = new Movimentacao();
		m2.setDescricao("Viagem � SP");
		m2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		m2.setData(LocalDateTime.now());
		m2.setValor(new BigDecimal(400.0));
		m2.setCategorias(Arrays.asList(categoria, categoria2));
		m2.setConta(c);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(categoria);
		em.persist(categoria2);
		em.persist(m);
		em.persist(m2);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
