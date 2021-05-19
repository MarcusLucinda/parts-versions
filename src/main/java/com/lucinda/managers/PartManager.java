package com.lucinda.managers;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lucinda.models.Part;

@Stateless
public class PartManager {

	@PersistenceContext
	private EntityManager em;
	
	public void createPart(Part part) {
		this.em.persist(part);
	}
	
	public List<Part> listParts(Integer grouppId){
		List<Part> parts = this.em.createQuery("select p from Part p where groupp_id = ?1", Part.class)
				.setParameter(1, grouppId).getResultList();
		return parts;
		
	}
}
