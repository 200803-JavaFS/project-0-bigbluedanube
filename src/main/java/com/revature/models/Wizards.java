package com.revature.models;

import java.io.Serializable;

public class Wizards implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int wizardId;
	private String firstName;
	private String lastName;
	private Vault vault;
	
	public Wizards() {
		super();
	}
	
	public Wizards(int wizardId, String firstName, String lastName, Vault vault) {
		super();
		this.wizardId = wizardId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vault = vault;
	}
	
	public Wizards(String firstName, String lastName, Vault vault) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.vault = vault;
		}

	public int getwizardId() {
		return wizardId;
	}

	public void setwizardId(int wizardId) {
		this.wizardId = wizardId;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Vault getVault() {
		return vault;
	}

	public void setVault(Vault vault) {		// THIS WAS A TYPO THAT IT WRECKED. EVERYTHING.
		this.vault = vault;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + wizardId);
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((vault == null) ? 0 : vault.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wizards other = (Wizards) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (vault == null) {
			if (other.vault != null)
				return false;
		} else if (!vault.equals(other.vault))
			return false;
		return true;
	}

//	@Override
	public String toString() {
		return "Wizards [wizardId=" + wizardId + ", firstName=" + firstName + ", lastName=" + lastName + ", Vault=" + vault + "]";
	}
	
}
