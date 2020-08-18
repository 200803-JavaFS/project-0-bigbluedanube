package com.revature;

import java.util.List;

import com.revature.daos.VaultDAO;
import com.revature.models.Vault;
import com.revature.utils.GringottsConsole;

public class Driver {

	private static VaultDAO vDao = new VaultDAO();
	
	public static void main(String[] args) {
		List<Vault> vaults = vDao.findAll();
		
		for (Vault v: vaults) {
			System.out.println(v);
		}
		
		Vault v = new Vault(777, true, 1000, false, false);
		
		System.out.println(vDao.addVault(v));
		
		GringottsConsole cons = new GringottsConsole();
		cons.beginApp();
		
	}

}
