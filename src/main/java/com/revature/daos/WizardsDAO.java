package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Wizards;
import com.revature.models.Vault;
import com.revature.utils.ConnectionUtility;

public class WizardsDAO implements IWizardsDAO {

	private IVaultDAO vDao = new VaultDAO();

	@Override
	public List<Wizards> findAll() {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM wizards;";

			Statement statement = conn.createStatement();

			List<Wizards> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Wizards w = new Wizards(result.getInt("wizard_id"), result.getString("first_name"),
						result.getString("last_name"), null);
				if (result.getString("owner_fk") != null) {
					w.setVault(vDao.findByNumber(result.getInt("owner_fk")));
				}
				list.add(w);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Wizards findById(int id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM wizards WHERE wizard_id =" + id + ";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {
				Wizards w = new Wizards(result.getInt("wizard_id"), result.getString("first_name"),
						result.getString("last_name"), null);
				if (result.getString("owner_fk") != null) {
					w.setVault(vDao.findByNumber(result.getInt("owner_fk")));
				}
				return w;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addWizard(Wizards w) {
		try (Connection conn = ConnectionUtility.getConnection()) {

			String sql = "INSERT INTO wizards (first_name, last_name, owner_fk_fk)"
					+ "VALUES (?, ?, ?);";
			
			
			/* findAll Wizards
			 * for (int Wizards w in [list of all Wizards]){
			 * if statement: input Wizards firstName, lastName = firstName, lastNAme in list
			 * input WizardId = list wizardId
			 * wizardId becomes owner_fk for the addVault method.
			 */
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setString(++index, w.getFirstName());
			statement.setString(++index, w.getLastName());
			
			if(w.getVault()!=null) {
				Vault v = w.getVault();
				statement.setInt(++index, w.getVault().getVaultNumber());
			}else {
				statement.setInt(++index, 0);
			}

			statement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateWizard(Wizards w) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE wizards SET first_name = ?, last_name = ?, owner_fk_fk = ? WHERE wizard_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setString(++index, w.getFirstName());
			statement.setString(++index, w.getLastName());

			if(w.getVault()!=null) {
				Vault v = w.getVault();
				statement.setInt(++index, w.getVault().getVaultNumber());
			}else {
				statement.setString(++index, null);
			}
			statement.setInt(++index, w.getwizardId());
			
			statement.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteWizard(int wizardId) {		// this isn't happening.
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "DELETE FROM wizards WHERE wizard_id =" + wizardId + ";";

			Statement statement = conn.createStatement();

			statement.execute(sql);
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addWizardWithVault(Wizards w) {
		try (Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "BEGIN; "
					+ "INSERT INTO wizards (first_name, last_name, owner_fk_fk)"
					+ "VALUES (?, ?, ?);"
					+ "INSERT INTO vaults (acct_active, owner_fk, is_employee, is_admin)"
					+ "VALUES (?, ?, ?, ?);"
					+ "COMMIT;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			Vault v = w.getVault();
			
			int index = 0;
			statement.setInt(++index, w.getwizardId());
			statement.setString(++index, w.getFirstName());
			statement.setString(++index, w.getLastName());
			statement.setInt(++index, w.getVault().getVaultNumber());
			
			statement.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}