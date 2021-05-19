package com.lucinda.beans;


import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lucinda.managers.GrouppManager;
import com.lucinda.models.Groupp;

@Named("GrouppBean")
@RequestScoped 
public class GrouppBean implements Serializable {
	
	private List<Groupp> groupps;
	private Groupp groupp = new Groupp();
	@Inject
	private GrouppManager gm;
	
	public void listAll(){
		this.groupps = gm.listGroupps();
		for (Groupp groupp : groupps) {
			System.out.println("nome " + groupp.getName());
		}
	}
	
	public void add() {
		gm.createGroup(groupp);
		this.groupps = gm.listGroupps();
		this.groupp = new Groupp();
	}

	public List<Groupp> getGroupps() {
		return groupps;
	}

	public void setGroupps(List<Groupp> groupps) {
		this.groupps = groupps;
	}

	public Groupp getGroupp() {
		return groupp;
	}

	public void setGroupp(Groupp groupp) {
		this.groupp = groupp;
	}

	public GrouppManager getGm() {
		return gm;
	}

	public void setGm(GrouppManager gm) {
		this.gm = gm;
	}
	
	
}
