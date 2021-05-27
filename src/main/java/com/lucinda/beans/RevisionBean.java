package com.lucinda.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lucinda.managers.PartManager;
import com.lucinda.managers.RevisionManager;
import com.lucinda.models.Revision;

@Named
@ApplicationScoped
public class RevisionBean implements Serializable {

	private List<Revision> revs;
	private Revision rev = new Revision();
	@Inject
	private RevisionManager rm;
	@Inject
	private PartManager pm;
	private Integer partId;

	public String selectPart(Integer id) {
		this.rev = null;
		return "revsNav?faces-redirect=true&partId="+id;
	}

	public void listAll() {
		if(rev == null) {
			this.revs = rm.listRevs(partId);
		}
	}
	
	public String add() {
		this.rev.setPart(pm.selectPart(this.partId));
		rm.createRevision(rev);
		this.revs = rm.listRevs(partId);
		this.rev = new Revision();
		return "revsNav?faces-redirect=true&partId="+this.partId;
	}


}
