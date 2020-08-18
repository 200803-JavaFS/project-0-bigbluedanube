package com.revature.models;

import java.io.Serializable;

public class Vault implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private int vaultNumber;
	private boolean acctActive;
	private double balance;
	private boolean isEmployee;
	private boolean isAdmin;
	
	public Vault() {
		super();
	}

	public Vault(int vaultNumber, boolean acctActive, double balance, boolean isEmployee, boolean isAdmin) {
		super();
		this.vaultNumber = vaultNumber;
		this.acctActive = acctActive;
		this.balance = balance;
		this.isEmployee = isEmployee;
		this.isAdmin = isAdmin;
	}

	public int getVaultNumber() {
		return vaultNumber;
	}

	public void setVaultNumber(int vaultNumber) {
		this.vaultNumber = vaultNumber;
	}

	public boolean getAcctActive() {
		return acctActive;
	}

	public void setAcctActive(boolean acctActive) {
		this.acctActive = acctActive;
	}
	
	public double getBalance (){
		return balance;
	}
	
	public void setBalance (double balance){
		this.balance = balance;
	}	

	public boolean getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((vaultNumber == null) ? 0 : vaultNumber.hashCode());
//		result = prime * result + ((acctActive == null) ? 0 : acctActive.hashCode());
//		result = prime * result + ((balance == null) ? 0 : balance.hashCode());		
//		result = prime * result + ((isEmployee == null) ? 0 : isEmployee.hashCode());
//		result = prime * result + ((isAdmin == null) ? 0 : isAdmin.hashCode());
//		return result;
//	}

	
	// Okay, I think we need to change the account types from Boolean to Int or String...
	// Perhaps 0 = Wizard, 1 = Gringotts Employee, 2 = Gringotts Admin
	// OR, just change the business logic here to make it fit the Boolean type because that makes sens to me.
	
	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Vault other = (Vault) obj;
//		if (vaultNumber == null) {
//			if (other.vaultNumber != null)
//				return false;
//		} else if (!vaultNumber.equals(other.vaultNumber))
//			return false;
//		if (acctActive == null) {
//			if (other.acctActive != null)
//				return false;
//		} else if (!acctActive.equals(other.acctActive))
//			return false;
//		if (isEmployee == null) {
//			if (other.isEmployee != null)
//				return false;
//		} else if (!isEmployee.equals(other.isEmployee))
//			return false;
//		if (isAdmin == null) {
//			if (other.isAdmin != null)
//				return false;
//		} else if (!isAdmin.equals(other.isAdmin))
//			return false;
//		return true;
//	}

	@Override
	public String toString() {
		return "Vault [Vault Number=" + vaultNumber + ", acctActive=" + acctActive + "balance=" + balance + ", isEmployee=" + isEmployee + ", isAdmin=" + isAdmin +"]";
	}
			

}