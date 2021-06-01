package com.lucinda.managers;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lucinda.models.Revision;

@Stateless
public class RevisionManager {
	
	@PersistenceContext
	private EntityManager em;
	
	public void createRevision(Revision rev) {
		this.em.persist(rev);
	}
	
	public List<Revision> listRevs(Integer partId){
		List<Revision> revs = this.em.createQuery("select r from Revision r where part_id = ?1", Revision.class).setParameter(1, partId).getResultList();
		return revs;
	}

	
}
