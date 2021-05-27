package com.lucinda.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lucinda.managers.GrouppManager;
import com.lucinda.managers.PartManager;
import com.lucinda.models.Part;

@Named("PartsBean")
@ApplicationScoped
public class PartsBean implements Serializable {

	private List<Part> parts;
	private Part part = new Part();
	@Inject
	private PartManager pm;
	@Inject
	private GrouppManager gm;
	private Integer grouppId;


	public String selectGroupp(Integer id) {
		this.parts = null;
		return "partsNav?faces-redirect=true&grouppId="+id;
	}

	public void listAll() {
		if(parts == null) {
			this.parts = pm.listParts(grouppId);
			for (Part part : parts) {
				System.out.println("nome " + part.getName());
			}
		}
	}

	public String add() {
		this.part.setGroupp(gm.selectGroupp(this.grouppId));
		this.part.setRevision(0);
		pm.createPart(part);;
		this.parts = pm.listParts(grouppId);
		this.part = new Part();
		return "partsNav?faces-redirect=true&grouppId="+this.grouppId;
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
