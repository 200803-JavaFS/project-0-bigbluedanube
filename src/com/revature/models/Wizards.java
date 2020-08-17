package com.revature.models;

import java.io.Serializable;

public class Wizards implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int wizardId;
	private String firstName;
	private String lastName;
	private String wandWood;
	private String wandCore;
	private String patronus;
	private Vault vault;
	
	public Wizards() {
		super();
	}
	
	public Wizards(int wizardId, String firstName, String lastName, String wandWood, String wandCore,
		String patronus, Vault vault) {
		super();
		this.wizardId = wizardId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.wandWood = wandWood;
		this.wandCore = wandCore;
		this.patronus = patronus;
		this.vault = vault;
	}
	
	public Wizards(String firstName, String lastName, String wandWood, String wandCore,
			String patronus, Vault vault) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.wandWood = wandWood;
			this.wandCore = wandCore;
			this.patronus = patronus;
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

	public String getwandWood() {
		return wandWood;
	}

	public void setwandWood(String wandWood) {
		this.wandWood = wandWood;
	}
	
	public String getwandCore() {
		return wandCore;
	}

	public void setwandCore(String wandCore) {
		this.wandCore = wandCore;
	}
	
	public String getpatronus() {
		return patronus;
	}

	public void setpatronus(String patronus) {
		this.patronus = patronus;
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
		result = prime * result + wizardId;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((wandWood == null) ? 0 : wandWood.hashCode());
		result = prime * result + ((wandCore == null) ? 0 : wandCore.hashCode());
		result = prime * result + ((patronus == null) ? 0 : patronus.hashCode());
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
		if (wandWood == null) {
			if (other.wandWood != null)
				return false;
		} else if (!wandWood.equals(other.wandWood))
			return false;
		if (wandCore == null) {
			if (other.wandCore != null)
				return false;
		} else if (!wandCore.equals(other.wandCore))
			return false;
		if (wizardId != other.wizardId)
			return false;
		if (patronus == null) {
			if (other.patronus != null)
				return false;
		} else if (!patronus.equals(other.patronus))
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
		return "Wizards [wizardId=" + wizardId + ", firstName=" + firstName + ", lastName=" + lastName + ", wandWood="
				+ wandWood + ", wandCore=" + wandCore + ", patronus=" + patronus + ", Vault=" + vault + "]";
	}
	
	

}
