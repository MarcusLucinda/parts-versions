package com.lucinda.managers;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lucinda.models.Groupp;
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
	
	public Part selectPart(Integer partId) {
		Part part = (Part) this.em.createQuery("SELECT p FROM Part p WHERE id = ?1").setParameter(1, partId).getSingleResult();
		return part;
	}
}
