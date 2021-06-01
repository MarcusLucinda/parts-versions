package com.lucinda.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lucinda.managers.PartManager;
import com.lucinda.managers.RevisionManager;
import com.lucinda.models.Revision;

@Named("RevisionBean")
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
		this.revs = null;
		return "revsNav?faces-redirect=true&partId="+id;
	}

	public void listAll() {
		if(revs == null) {
			this.revs = rm.listRevs(partId);
		}
	}
	
	public String add() {
		this.rev.setPart(pm.selectPart(this.partId));
		rm.createRevision(rev);
		pm.updateRev(this.partId, this.rev.getRevision());
		this.revs = rm.listRevs(partId);
		this.rev = new Revision();
		return "revsNav?faces-redirect=true&partId="+this.partId;
	}

	public List<Revision> getRevs() {
		return revs;
	}

	public void setRevs(List<Revision> revs) {
		this.revs = revs;
	}

	public Revision getRev() {
		return rev;
	}

	public void setRev(Revision rev) {
		this.rev = rev;
	}

	public RevisionManager getRm() {
		return rm;
	}

	public void setRm(RevisionManager rm) {
		this.rm = rm;
	}

	public PartManager getPm() {
		return pm;
	}

	public void setPm(PartManager pm) {
		this.pm = pm;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	
	


}
