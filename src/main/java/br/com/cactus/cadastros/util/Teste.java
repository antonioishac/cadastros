package br.com.cactus.cadastros.util;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cactus.cadastros.model.Municipio;

public class Teste {
	
	public static void main(String args[]) {
		
		EntityManager em = JPAUtil.getInstance().getEntityManager();
				
		String jpql = "SELECT m FROM Municipio m where m.nome like '%%' and m.uf.nome like '%%'";
		List<Municipio> lista = em.createQuery(jpql, Municipio.class).getResultList();
		
		for(Municipio ls : lista){
			
			System.out.println("Nome: " + ls.getNome() + " - Estado: " + ls.getUf().getNome());
		}
		
		System.out.println("tamanho da lista: " + lista.size());
		
	}

}
