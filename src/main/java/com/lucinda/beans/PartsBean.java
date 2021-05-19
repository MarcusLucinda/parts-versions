package com.lucinda.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lucinda.managers.PartManager;
import com.lucinda.models.Part;



@Named("PartsBean")
@RequestScoped
public class PartsBean implements Serializable {

	private List<Part> parts;
	private Part part = new Part();
	@Inject
	private PartManager pm;
	private Integer grouppId;
	
	public void listAll(){
		this.parts = pm.listParts(grouppId);
		for (Part part : parts) {
			System.out.println("nome " + part.getName());
		}
	}
	
	public void add() {
		pm.createPart(part);;
		this.parts = pm.listParts(grouppId);
		this.part = new Part();
	}
	
	public List<Part> getParts() {
		return parts;
	}
	public void setParts(List<Part> parts) {
		this.parts = parts;
	}
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	public PartManager getPm() {
		return pm;
	}
	public void setPm(PartManager pm) {
		this.pm = pm;
	}

	public Integer getGrouppId() {
		return grouppId;
	}

	public void setGrouppId(Integer grouppId) {
		this.grouppId = grouppId;
	}
	
	
	
}
