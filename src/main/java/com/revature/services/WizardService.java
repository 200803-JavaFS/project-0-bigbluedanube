package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.WizardsDAO;
import com.revature.daos.VaultDAO;
import com.revature.daos.IWizardsDAO;
import com.revature.daos.IVaultDAO;
import com.revature.models.Wizards;
import com.revature.models.Vault;

public class WizardService {

	private static IWizardsDAO dao = new WizardsDAO();
	private static IVaultDAO vDao = new VaultDAO();
	private static final Logger log = LogManager.getLogger(WizardService.class);

	public List<Wizards> findAll() {
		log.info("Retrieving all wizards");
		List<Wizards> list = dao.findAll();

		for (Wizards w : list) {
			if (w.getFirstName().equals("Albus")) {
				w.setVault(null);
			}
		}

		return list;
	}

	public Wizards findById(int wizardId) {
		log.info("finding a Wizard with id " + wizardId);
		return dao.findById(wizardId);
	}

	public boolean updateWizard(Wizards w) {
		log.info("Updating Wizards: " + w);
		if (dao.updateWizard(w)) {
			return true;
		}
		return false;
	}

	public boolean insertWizard(Wizards w) {

		if (w.getVault() != null) {
			List<Vault> list = vDao.findAll();
			boolean b = false;
			for (Vault v : list) {
				if (v.equals(w.getVault())) {
					b = true;
				}
			}
			if (b) {
				log.info("Inserting Wizard: " + w);
				if (dao.addWizard(w)) {
					return true;
				}
			} else {
				log.info("Inserting Wizard: " + w + " with a new vault: " + w.getVault());
				if (dao.addWizardWithVault(w)) {
					return true;
				}
			}
		} else {
			log.info("Inserting Wizard: " + w);
			if (dao.addWizard(w)) {
				return true;
			}
		}
		return false;
	}

	public boolean removeWizard(int wizardId) {
		log.info("Deleting Wizard with id: " + wizardId);
		if (dao.deleteWizard(wizardId)) {
			log.info("Wizard Deleted.");
			return true;
		}
		return false;
	}

}

