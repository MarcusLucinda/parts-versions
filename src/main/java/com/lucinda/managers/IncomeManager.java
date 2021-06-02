package com.lucinda.managers;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lucinda.models.Part;

@Stateless
public class IncomeManager {

	@PersistenceContext
	private EntityManager em;
	
	public List<Part> intervalParts (LocalDate startDate, LocalDate endDate){
		List<Part> parts = em.createQuery("SELECT p FROM Part p WHERE date BETWEEN ?1 AND ?2", Part.class)
				.setParameter(1, startDate).setParameter(2, endDate).getResultList();
		return parts;
	}
}
