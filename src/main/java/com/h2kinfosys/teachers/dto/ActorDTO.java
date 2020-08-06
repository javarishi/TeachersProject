package com.h2kinfosys.teachers.dto;

import java.sql.Timestamp;

public class ActorDTO {
	
	private String firstName = null;
	private String lastName = null;
	private Timestamp lastupdate = null;
	private int actorId = 0;

	@Override
	public String toString() {
		return "ActorDTO [firstName=" + firstName + ", lastName=" + lastName + ", lastupdate=" + lastupdate
				+ ", actorId=" + actorId + "]";
	}

	public ActorDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the lastupdate
	 */
	public Timestamp getLastupdate() {
		return lastupdate;
	}

	/**
	 * @param lastupdate the lastupdate to set
	 */
	public void setLastupdate(Timestamp lastupdate) {
		this.lastupdate = lastupdate;
	}

	/**
	 * @return the actorId
	 */
	public int getActorId() {
		return actorId;
	}

	/**
	 * @param actorId the actorId to set
	 */
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

}
