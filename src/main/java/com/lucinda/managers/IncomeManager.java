package com.lucinda.managers;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lucinda.models.Revision;

@Stateless
public class IncomeManager {

	@PersistenceContext
	private EntityManager em;
	
	public List<Revision> intervalParts (LocalDate startDate, LocalDate endDate){
		List<Revision> revisions = em.createQuery("SELECT r FROM Revision r WHERE date BETWEEN ?1 AND ?2", Revision.class)
				.setParameter(1, startDate).setParameter(2, endDate).getResultList();
		return revisions;
	}
}
