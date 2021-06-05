package com.lucinda.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lucinda.managers.IncomeManager;
import com.lucinda.models.Revision;

@Named("IncomeBean")
@ApplicationScoped
public class IncomeBean implements Serializable {
	
	@Inject
	private IncomeManager im;
	private LocalDate startDate;
	private LocalDate endDate;
	private List<Revision> revs = new ArrayList<Revision>();
	private Double total;
	
	public String selectDates() {
		this.revs = im.intervalParts(startDate, endDate);
		Double sum = 0.0;
		for (Revision revision : revs) {
			sum += revision.getPrice();
		}
		this.total = sum;
		return "income?faces-redirect=true";
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public IncomeManager getIm() {
		return im;
	}

	public void setIm(IncomeManager im) {
		this.im = im;
	}

	public List<Revision> getRevs() {
		return revs;
	}

	public void setRevs(List<Revision> revs) {
		this.revs = revs;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	

	
}
