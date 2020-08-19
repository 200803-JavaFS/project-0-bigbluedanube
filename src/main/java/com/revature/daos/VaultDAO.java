package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Vault;
import com.revature.utils.ConnectionUtility;

public class VaultDAO implements IVaultDAO {
	private static final Logger log = LogManager.getLogger(VaultDAO.class);
	
	@Override
	public List<Vault> findAll() {
		
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM vaults;";
			
			Statement statement = conn.createStatement();
			
			List<Vault> list = new ArrayList<>(); 
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Vault v = new Vault();
				v.setVaultNumber(result.getInt("vault_number"));
				v.setAcctActive(result.getBoolean("acct_active"));
//				v.setBalance(result).getDouble("balance");			// this was missing, now it's an error.
				v.setIsEmployee(result.getBoolean("is_employee"));
				v.setIsAdmin(result.getBoolean("is_admin"));
				list.add(v); 
			}
			
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public Vault findByNumber(int vaultNumber) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM vaults WHERE vault_number = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, vaultNumber);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				Vault v = new Vault();
				v.setVaultNumber(result.getInt("vault_number"));
				v.setAcctActive(result.getBoolean("acct_active"));
//				v.setBalance(result).getDouble("balance");			// this was missing, now it's an error.
				v.setIsEmployee(result.getBoolean("is_employee"));
				v.setIsAdmin(result.getBoolean("is_admin"));
				return v;
			} else {
				log.info("Failed Query: Vault not found.");			// had to import the logger to make this work.
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addVault(Vault v) {		// check the INSERT statement. Something is weird here.
		
		try(Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "INSERT INTO vaults (acct_active, vault_number, balance, is_employee, is_admin)"
					+ "VALUES (?, ?, ?, ?);";
			
//			String sql = "INSERT INTO vaults (acct_active, balance, is_employee, is_admin)"
//					+ "VALUES (?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setBoolean(++index, v.getAcctActive());
			statement.setInt(++index, v.getVaultNumber());
			statement.setDouble(++index, v.getBalance());
			statement.setBoolean(++index, v.getIsEmployee());
			statement.setBoolean(++index, v.getIsAdmin());	
			statement.execute();
			return true; 
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	// you  will need an "empty vault" boolean here.


}
