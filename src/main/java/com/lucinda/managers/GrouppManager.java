package com.lucinda.managers;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lucinda.models.Groupp;

@Stateless
public class GrouppManager {
	
	@PersistenceContext
	private EntityManager em;
	
	public void createGroup(Groupp groupp) {
		this.em.persist(groupp);
	}
	
	public List<Groupp> listGroupps(){
		List<Groupp> groupps = this.em.createQuery("SELECT g FROM Groupp g", Groupp.class).getResultList();
		return groupps;
	}

}
