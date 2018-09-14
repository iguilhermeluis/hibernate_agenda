package com.guilherme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.guilherme.model.Cliente;

public class ClienteDao {
	
	EntityManager em;
	EntityManagerFactory factory;
	
	public ClienteDao() {
		em = getEntityManager();
	}
	
	private EntityManager getEntityManager() {
		factory = Persistence.createEntityManagerFactory("TestHibernateUnit");
		
		if(em == null){
			em = factory.createEntityManager();
		}
		
		return em;
	}
	
	public void encerrar() {
		factory.close();
		em.close();
	}
	
	//CRUD
	public Integer gravar(Cliente c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		return c.getId();
	}
	
	public void atualizar(Cliente c) {
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}
	
	public Cliente buscarPorId(Integer id){
		return (Cliente) em.find(Cliente.class, id);
	}
	
	public void remover(Integer id){
		Cliente c = buscarPorId(id);
		
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
	}
	
	public List<Cliente> getTodosObjetos(){
		return em.createQuery("from " + Cliente.class.getName()).getResultList();
	}

}
