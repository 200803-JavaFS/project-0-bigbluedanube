package com.revature.daos;

import java.util.List;

import com.revature.models.Vault;

public interface IVaultDAO {
	
	public List<Vault> findAll();
	public Vault findByNumber(int vaultNumber);
	public boolean addVault(Vault v);
	
	// public boolean emptyVault(Vault v);		// This works like "Close Account".
}