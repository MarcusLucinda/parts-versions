package com.lucinda.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Part {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer revision;
	private LocalDate date;
	@ManyToOne
	private Groupp groupp;
	@OneToMany(mappedBy = "part")
	private List<Revision> revisions;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRevision() {
		return revision;
	}
	public void setRevision(Integer revision) {
		this.revision = revision;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Groupp getGroupp() {
		return groupp;
	}
	public void setGroupp(Groupp groupp) {
		this.groupp = groupp;
	}
	public List<Revision> getRevisions() {
		return revisions;
	}
	public void setRevisions(List<Revision> revisions) {
		this.revisions = revisions;
	}
	
	
	
	
	
	


	
	
	
}
